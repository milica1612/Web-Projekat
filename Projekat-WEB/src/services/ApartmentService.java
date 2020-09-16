package services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Apartment;
import beans.Comment;
import beans.User;
import dao.ApartmentDAO;
import dao.CommentDAO;
import dao.ReservationDAO;
import dao.UserDAO;

@Path("/apartments")
public class ApartmentService {
	
	@Context
	public ServletContext ctx;
	String contextPath;
	
	public ApartmentService() {
	}
	
	@PostConstruct
		public void init() throws NoSuchAlgorithmException, IOException {
		if (ctx.getAttribute("apartmentDAO") == null) {
	    	contextPath = ctx.getRealPath("");
			ctx.setAttribute("apartmentDAO", new ApartmentDAO(contextPath));
			System.out.println(contextPath);
		}
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Apartment postApartment(Apartment apartment, @Context HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
		
		System.out.println("apartment");
		ApartmentDAO apartmentDao = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		
		User user = (User) request.getSession().getAttribute("user");
		String host = user.getUsername();
		apartment.setHost(host);
		
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
					
		Apartment added = (Apartment) apartmentDao.addNewApartment(apartment);
		userDao.addNewApartment(host, added);
			
		if(added == null) {
			return null;
		}
			
		return added;
		}
	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getAllApartments(@Context HttpServletRequest request) {
		
		ApartmentDAO apartmentDao = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		User user = (User) request.getSession().getAttribute("user");
		
		String newUser = user.getRole().toString();
		System.out.println(newUser);
		
		return apartmentDao.getAllApartments(user);
	}

	/*
	@POST
	@Path("/addcomment")
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
