package beans;

public class Comment {

	private long id;
	private String guest;
	private long apartment;
	private String text;
	private int grade;
	private boolean active;
	
	public Comment() {
		this.active = true;
	}
	
	public Comment(long id, String guest, long apartment, String text, int grade, boolean active) {
		super();
		this.id = id;
		this.guest = guest;
		this.apartment = apartment;
		this.text = text;
		this.grade = grade;
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

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public long getApartment() {
		return apartment;
	}

	public void setApartment(long apartment) {
		this.apartment = apartment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
