package beans;

public class Location {

	private long id;
	private double length;
	private double width;
	private Address address;
	
	public Location() {
		
	}
	public Location(long id, double length, double width, Address address) {
		super();
		this.id = id;
		this.length = length;
		this.width = width;
		this.address = address;		
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAdress(Address address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
}
