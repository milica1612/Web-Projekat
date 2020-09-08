package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Amenities;
import beans.Role;
import beans.User;

public class AmenitiesDAO {

	
	private HashMap<Long, Amenities> amenities = new HashMap<Long, Amenities>(); 
	private String contextPath;
	
	public AmenitiesDAO(String contextPath) throws NoSuchAlgorithmException, IOException {
		this.contextPath = contextPath;
		System.out.println(contextPath);
		amenities = loadAmenities(contextPath);
	}
	
	public HashMap<Long,Amenities> loadAmenities(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File amenitiesFile = new File(contextPath + "/amenities.json");
	    
	    boolean created = amenitiesFile.createNewFile();
	    if (created) {
	       
	       mapper.writeValue(amenitiesFile, amenities);
	    }
	 
	    return mapper.readValue(amenitiesFile, new TypeReference<HashMap<Long,Amenities>>() {});
	}
	
	//upisivanje u novi fajl 
	public void saveAmenities(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File amenitiesFile = new File(contextPath + "/amenities.json");
	    amenitiesFile.createNewFile();
	    mapper.writeValue(amenitiesFile, amenities);
	}

	public Amenities addNewAmenities(Amenities amenities2) {
		if(!isNameUnique(amenities2)) {
			
			return null;
		}
		Amenities newAmenitie = createNewAmenitie(amenities2);
		amenities.put(newAmenitie.getId(), newAmenitie);
		try {
			saveAmenities(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newAmenitie;
	}
	
	private Amenities createNewAmenitie(Amenities amenitie) {
		long id = amenities.size() + 1;
		Amenities newAmenitie = new Amenities(id, amenitie.getName(), true);
		return newAmenitie;
	}
	
	private boolean isNameUnique(Amenities amenities2) {
			for (Amenities am : amenities.values()) {
				if(am.getName().equals(amenities2.getName())) {
					return false;
				}
			}
		return true;
	}
	

	public Amenities findAmenitie(Amenities amenitie) {
		Amenities existing = amenities.get(amenitie.getId());
		
		return existing;
		
	}
	public Amenities editAmenities(Long id, Amenities amenities2) {
		Amenities existing = findAmenitie(amenities2);
		if(!isNameUnique(amenities2)) {
			return null;
		}
		existing.setName(amenities2.getName());
		amenities.put(id, existing);
		try {
			saveAmenities(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existing;
	}
}
