package beans;

public class Address {

	private String streetAndNumber;
	private String city;
	private long postNumber;
	
	public Address() {
		
	}
	
	public Address(String streetAndNumber, String city, long postNumber) {
		super();
		this.streetAndNumber = streetAndNumber;
		this.city = city;
		this.postNumber = postNumber;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(long postNumber) {
		this.postNumber = postNumber;
	}
	
	
	
	
}
