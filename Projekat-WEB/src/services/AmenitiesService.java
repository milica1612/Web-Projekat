package services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Amenities;
import beans.User;
import dao.AmenitiesDAO;
import dao.ApartmentDAO;

@Path("/amenities")
public class AmenitiesService {
	
	@Context
	public ServletContext ctx;
	String contextPath;
	
	public AmenitiesService() {
	}
	
	@PostConstruct
		public void init() throws NoSuchAlgorithmException, IOException {
		if (ctx.getAttribute("amenitiesDAO") == null) {
	    	contextPath = ctx.getRealPath("");
			ctx.setAttribute("amenitiesDAO", new AmenitiesDAO(contextPath));
		}
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Amenities postAmenitie(Amenities amenities,
						 @Context HttpServletRequest request) {
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		System.out.println(contextPath);
		return amenitiesDAO.addNewAmenities(amenities);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Amenities editAmenities(@PathParam("id") Long id, 
						 Amenities amenities,
						 @Context HttpServletRequest request) {
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		
		return amenitiesDAO.editAmenities(id, amenities);
	}

}
