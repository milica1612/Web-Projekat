package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Apartment;
import beans.ApartmentStatus;
import beans.Reservation;
import beans.Status;

public class ReservationDAO {
	
	private HashMap<Long, Reservation> reservations = new HashMap<Long, Reservation>(); 
	private String contextPath;
	
	public ReservationDAO(String path) {
		super();
		this.contextPath = path;
	}
	
	public Reservation addNewReservation(Reservation reservation) {	
		
		if(reservations.containsKey(reservation.getId())) {
			return null;
		}
		
		Reservation newReservation = createNewReservation(reservation);
		reservations.put(newReservation.getId(), newReservation);
		try {
			saveReservations(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return reservation;
	}
	
	
	
	private Reservation createNewReservation(Reservation reservation) {
		long id = reservations.size() + 1;
		Reservation newReservation = new Reservation(
				id,
				reservation.getApartment(),
				reservation.getDate(),
				reservation.getNights(),
				reservation.getPrice(),
				reservation.getMessage(),
				reservation.getGuest(),
				Status.CREATED,
				true
				);
		
		return newReservation;
	}
	
	public HashMap<Long, Reservation> loadReservations(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File reservationFile = new File(contextPath + "/reservations.json");
	    
	    boolean created = reservationFile.createNewFile();
	    if (created) {
	       
	       mapper.writeValue(reservationFile, reservations);
	    }
	 
	    return mapper.readValue(reservationFile, new TypeReference<HashMap<Long, Reservation>>() {});
	}
	
	
	public void saveReservations(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File reservationFile = new File(contextPath + "/reservaions.json");
	    reservationFile.createNewFile();
	    mapper.writeValue(reservationFile, reservations);
	}
}
