package beans;

import java.time.LocalDate;

import beans.Status;

public class Reservation {

	private long id;
	private long apartment;
	private LocalDate date;
	private int nights;
	private double price;
	private String message;
	private String guest;
	private Status status;
	private boolean active;
	
	public Reservation() {
		this.active = true;
	}
	
	public Reservation(long id, long apartment, LocalDate date, int nights, double price, String message, String guest,
			Status status, boolean active) {
		super();
		this.id = id;
		this.apartment = apartment;
		this.date = date;
		this.nights = nights;
		this.price = price;
		this.message = message;
		this.guest = guest;
		this.status = status;
		this.active = active;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public long getApartment() {
		return apartment;
	}
	public void setApartment(long apartment) {
		this.apartment = apartment;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
