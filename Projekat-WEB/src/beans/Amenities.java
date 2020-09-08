package beans;

public class Amenities {

	private long id;
	private String name;
	private boolean active;
	
	public Amenities() {
		this.active = true;
	}
	
	public Amenities(long id, String name, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
