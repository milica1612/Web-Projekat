package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Address;
import beans.Amenities;
import beans.Apartment;
import beans.ApartmentStatus;
import beans.ApartmentType;
import beans.Location;
import beans.Role;
import beans.User;

public class ApartmentDAO {
	
	private HashMap<Long, Apartment> apartments = new HashMap<Long, Apartment>(); 
	//private HashMap<String, Amenities> amenities = new HashMap<String, Amenities>(); 
	private String contextPath;
	
	public ApartmentDAO(String path) throws NoSuchAlgorithmException, IOException {
		this.contextPath = path;
		System.out.println(contextPath);
		
    	apartments = loadApartments(contextPath);
	}

	public void addTestData() {
		Address a = new Address(3, "", "", 1);
		Location location = new Location(3, 3, 3, a);
		Apartment apa1 = new Apartment(6, ApartmentType.ROOM, 5, 5, location, "zorana",
				30, null, null, ApartmentStatus.ACTIVE, true);
		apartments.put(apa1.getId(), apa1);
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
				ApartmentStatus.ACTIVE,
				true);
		
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

	public Collection<Apartment> getAllApartments(User user) {
		ArrayList<Apartment> retApartments = new ArrayList<Apartment>();
		Role role = user.getRole();
		switch (role) {
		case GUEST:
		
			for (Apartment apartment : apartments.values()) {
				System.out.println(apartment.getId());
				if(apartment.isActive() && apartment.getStatus().equals(ApartmentStatus.ACTIVE)) {
					System.out.println(apartment.getId());
					retApartments.add(apartment);
				}
			}
			break;
		case HOST:
			ArrayList<Long> ap = user.getApartmentsForRent();
			for (Apartment apartment : apartments.values()) {
					if(apartment.isActive() && ap.contains(apartment.getId())) {
						retApartments.add(apartment);
					}
			}
			break;
		default: 
			for (Apartment apartment : apartments.values()) {
				if(apartment.isActive()){
					retApartments.add(apartment);
				}
			}
			break;
		}
		
		return retApartments;
	}
	
	
}
