package beans;

import java.time.LocalTime;
import java.util.ArrayList;

public class Apartment {
	private long id;
	private ApartmentType type;
	private int roomNumber;
	private int numberOfGuests;
	private Location location;
	private ArrayList<Long> rentingDates;
	private ArrayList<Long> availableDates;
	private String host;
	private double price;
	private ArrayList<Long> comments;
	private ArrayList<String> images;
	private LocalTime checkinTime;
	private LocalTime checkoutTime;
	private ApartmentStatus status;
	private ArrayList<Long> amenities;
	private ArrayList<Long> reservations;
	private boolean active;
	
	private Apartment() {
		this.active = true;
	}

	public Apartment(long id, ApartmentType type, int roomNumber, int numberOfGuests, Location location, String host,
			double price, LocalTime checkinTime, LocalTime checkoutTime, ApartmentStatus status, boolean active) {
		super();
		this.id = id;
		this.type = type;
		this.roomNumber = roomNumber;
		this.numberOfGuests = numberOfGuests;
		this.location = location;
		this.host = host;
		this.price = price;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.status = status;
		this.amenities = new ArrayList<Long>();
		this.reservations = new ArrayList<Long>();
		this.availableDates = new ArrayList<Long>();
		this.rentingDates = new ArrayList<Long>();
		this.comments = new ArrayList<Long>();
		this.images = new ArrayList<String>();
		this.active = active;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ApartmentType getType() {
		return type;
	}

	public void setType(ApartmentType type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public LocalTime getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(LocalTime checkinTime) {
		this.checkinTime = checkinTime;
	}

	public LocalTime getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(LocalTime checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public ApartmentStatus getStatus() {
		return status;
	}

	public void setStatus(ApartmentStatus status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Long> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Long> comments) {
		this.comments = comments;
	}

	public ArrayList<Long> getAmenities() {
		return amenities;
	}

	public void setAmenities(ArrayList<Long> amenities) {
		this.amenities = amenities;
	}

	public ArrayList<Long> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Long> reservations) {
		this.reservations = reservations;
	}
	
}
