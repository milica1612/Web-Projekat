package services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Comment;
import dao.CommentDAO;


@Path("/comments")
public class CommentService {
		
	@Context
	public ServletContext ctx;
	String contextPath;
	
	public CommentService() {
	}
	
	@PostConstruct
		public void init() throws NoSuchAlgorithmException, IOException {
		if (ctx.getAttribute("commentDAO") == null) {
	    	contextPath = ctx.getRealPath("");
			ctx.setAttribute("commentDAO", new CommentDAO(contextPath));
			System.out.println(contextPath);
		}
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment postComment(Comment comment, @Context HttpServletRequest request) throws NoSuchAlgorithmException {
		
		System.out.println("comment");
		CommentDAO commentDao = (CommentDAO) ctx.getAttribute("commentDAO");
		
		Comment added = (Comment) commentDao.addNewComment(comment);
			
		if(added == null) {
			return null;
		}
			
		return added;
		}
}
