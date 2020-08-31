package beans;

public class Reservation {

	private String id;
	private String apartment;
	private long date;
	private int nights;
	private double price;
	private String message;
	private String guest;
	private Status status;
	
	public Reservation() {
	}
	
	public Reservation(String id, String apartment, long date, int nights, double price, String message, String guest,
			Status status) {
		super();
		this.id = id;
		this.apartment = apartment;
		this.date = date;
		this.nights = nights;
		this.price = price;
		this.message = message;
		this.guest = guest;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
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
