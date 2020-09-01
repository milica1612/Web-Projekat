package beans;

import java.util.ArrayList;

public class Apartment {

	private String id;
	private ApartmentType type;
	private int roomNumber;
	private int numberOfGuests;
	private Location location;
	private ArrayList<Long> rentingDates;
	private ArrayList<Long> availableDates;
	private String host;
	private ArrayList<String> comments;
	private ArrayList<String> images;
	private int checkinTime;
	private int checkoutTime;
	private ApartmentStatus status;
	private ArrayList<String> amenities;
	private ArrayList<String> reservations;
	
	private Apartment() {
		
	}
	
	public Apartment(String id, ApartmentType type, int roomNumber, int numberOfGuests, Location location, String host,
			int checkinTime, int checkoutTime, ApartmentStatus status) {
		super();
		this.id = id;
		this.type = type;
		this.roomNumber = roomNumber;
		this.numberOfGuests = numberOfGuests;
		this.location = location;
		this.host = host;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.status = status;
		this.amenities = new ArrayList<String>();
		this.reservations = new ArrayList<String>();
		this.availableDates = new ArrayList<Long>();
		this.rentingDates = new ArrayList<Long>();
		this.comments = new ArrayList<String>();
		this.images = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ApartmentType getType() {
		return type;
	}

	public void setType(ApartmentType type) {
		this.type = type;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Long> getRentingDates() {
		return rentingDates;
	}

	public void setRentingDates(ArrayList<Long> rentingDates) {
		this.rentingDates = rentingDates;
	}

	public ArrayList<Long> getAvailableDates() {
		return availableDates;
	}

	public void setAvailableDates(ArrayList<Long> availableDates) {
		this.availableDates = availableDates;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public int getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(int checkinTime) {
		this.checkinTime = checkinTime;
	}

	public int getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(int checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public ApartmentStatus getStatus() {
		return status;
	}

	public void setStatus(ApartmentStatus status) {
		this.status = status;
	}

	public ArrayList<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(ArrayList<String> amenities) {
		this.amenities = amenities;
	}

	public ArrayList<String> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<String> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
	

	
}
