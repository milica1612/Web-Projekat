package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
	
		if(apartments.containsKey(apartment.getId())) {
			return null;
		}
		
		Apartment newApartment = createNewApartment(apartment);
		apartments.put(newApartment.getId(), newApartment);
		try {
			saveApartments(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apartment;
		
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
	
	public User postAmenities(Amenities amenities) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getAmenities(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User editAmenities(Long id, Amenities amenities2) {
		// TODO Auto-generated method stub
		return null;
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
	
}
