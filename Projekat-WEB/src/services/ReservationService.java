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

import beans.Reservation;
import dao.ReservationDAO;

@Path("/reservations")
public class ReservationService {
	
	@Context
	public ServletContext ctx;
	String contextPath;
	
	public ReservationService() {
	}
	
	@PostConstruct
		public void init() throws NoSuchAlgorithmException, IOException {
		if (ctx.getAttribute("reservationDAO") == null) {
	    	contextPath = ctx.getRealPath("");
			ctx.setAttribute("reservationDAO", new ReservationDAO(contextPath));
			System.out.println(contextPath);
		}
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation postReservation(Reservation reservation, @Context HttpServletRequest request) throws NoSuchAlgorithmException {
		
		System.out.println("reservation");
		ReservationDAO reservationDao = (ReservationDAO) ctx.getAttribute("reservationDAO");
		
		Reservation added = (Reservation) reservationDao.addNewReservation(reservation);
			
		if(added == null) {
			return null;
		}
			
		return added;
		}
}


