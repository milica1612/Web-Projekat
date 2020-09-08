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
import javax.ws.rs.core.Response;

import beans.Apartment;
import beans.User;
import dao.ApartmentDAO;
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
	public Apartment postApartment(Apartment apartment, @Context HttpServletRequest request) throws NoSuchAlgorithmException {
		
		System.out.println("apartment");
		ApartmentDAO apartmentDao = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		
		String host = (String) request.getSession().getAttribute("user");
		
		apartment.setHost(host);
		
		Apartment added = (Apartment) apartmentDao.addNewApartment(apartment);
			
		if(added == null) {
			return null;
		}
			
		return added;
		}
}
