package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Amenities;
import beans.Apartment;
import beans.ApartmentStatus;
import beans.Role;
import beans.User;

public class ApartmentDAO {
	
	private HashMap<Long, Apartment> apartments = new HashMap<Long, Apartment>(); 
	//private HashMap<String, Amenities> amenities = new HashMap<String, Amenities>(); 
	private String contextPath;
	
	public ApartmentDAO(String path) {
		super();
		this.contextPath = path;
	}

	public Apartment addNewApartment(Apartment apartment) {	
		
		Apartment newApartment = createNewApartment(apartment);
		apartments.put(newApartment.getId(), newApartment);
		try {
			saveApartments(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newApartment;
		
	}
	
	private Apartment createNewApartment(Apartment apartment) {
		long id = apartments.size() + 1;
		Apartment newApartment = new Apartment(
				id,
				apartment.getType(), 
				apartment.getRoomNumber(),
				apartment.getNumberOfGuests(),
				apartment.getLocation(),
				apartment.getHost(),
				apartment.getPrice(),
				apartment.getCheckinTime(),
				apartment.getCheckoutTime(),
				ApartmentStatus.INACTIVE,
				false);
		
		return newApartment;
	}
	
	public HashMap<Long,Apartment> loadApartments(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File apartmentFile = new File(contextPath + "/apartments.json");
	    
	    boolean created = apartmentFile.createNewFile();
	    if (created) {
	       
	       mapper.writeValue(apartmentFile, apartments);
	    }
	 
	    return mapper.readValue(apartmentFile, new TypeReference<HashMap<Long,Apartment>>() {});
	}
	
	
	public void saveApartments(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File apartmentFile = new File(contextPath + "/apartments.json");
	    apartmentFile.createNewFile();
	    mapper.writeValue(apartmentFile, apartments);
	}

	public Collection<Apartment> getAllApartments(String role, User user) {
		ArrayList<Apartment> retApartments = new ArrayList<Apartment>();
		
		switch (role) {
		case "GUEST":
			for (Apartment apartment : apartments.values()) {
				if(apartment.isActive() && apartment.getStatus().equals("ACTIVE")) {
					retApartments.add(apartment);
				}
			}
			break;
		case "HOST":
			ArrayList<Long> ap = user.getApartmentsForRent();
			for (Apartment apartment : apartments.values()) {
					if(apartment.isActive() && apartment.getStatus().equals("ACTIVE") && ap.contains(apartment.getId())) {
						retApartments.add(apartment);
					}
			}
			break;
		case "ADMINISTRATOR": 
			for (Apartment apartment : apartments.values()) {
				if(apartment.isActive()){
					retApartments.add(apartment);
				}
			}
			break;
			
		default:
			break;
		}
		
		return retApartments;
	}

}
