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

import beans.Apartment;
import beans.Comment;
import beans.Reservation;
import beans.User;
import dao.ApartmentDAO;
import dao.CommentDAO;
import dao.ReservationDAO;


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
	
/*	@POST
	//@Path("/addcomment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment postComment(Apartment apartment, Comment comment, @Context HttpServletRequest request) throws NoSuchAlgorithmException {
		
		System.out.println("comment");
		CommentDAO commentDao = (CommentDAO) ctx.getAttribute("commentDAO");
		
		User user = (User) request.getSession().getAttribute("user");
		
		ReservationDAO reservationDao = (ReservationDAO) ctx.getAttribute("reservationDAO");
				
		String guest = user.getUsername();
		comment.setGuest(guest);
		Comment added = null;
		
		if(reservationDao.newComment(apartment, user)) {
		
		added = (Comment) commentDao.addNewComment(comment);
		}
		
		if(added == null) {
			return null;
		}
			
		return added;
		}*/
}
