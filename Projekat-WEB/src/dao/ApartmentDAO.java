package dao;

import java.util.HashMap;

import beans.Amenities;
import beans.Apartment;
import beans.User;

public class ApartmentDAO {
	
	private HashMap<String, Apartment> apartments = new HashMap<String, Apartment>(); 
	private HashMap<String, Amenities> amenities = new HashMap<String, Amenities>(); 
	private String contextPath;
	
	public ApartmentDAO(String path) {
		super();
		this.contextPath = path;
	}

	public User postAmenities(Amenities amenities2) {
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
	
	
	

}
