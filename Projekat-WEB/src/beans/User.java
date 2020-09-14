package beans;

import java.util.ArrayList;

public class User {

		private String username; //id
		private String password;
		private String firstName;
		private String lastName;
		private Gender gender;
		private Role role;
		private ArrayList<Long> apartmentsForRent = new ArrayList<Long>();
		private ArrayList<Long> rentedApartments;
		
		
		public void setApartmentsForRent(ArrayList<Long> apartmentsForRent) {
			this.apartmentsForRent = apartmentsForRent;
		}

		public void setRentedApartments(ArrayList<Long> rentedApartments) {
			this.rentedApartments = rentedApartments;
		}
		private ArrayList<Long> reservations;
		private boolean active;
		
		public User() {
			this.active = true;
		}	

		public User(String username, String password, String firstName, String lastName, Gender gender, Role role, boolean active) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.role = role;
			this.active = active;
			this.apartmentsForRent = new ArrayList<Long>();
			this.rentedApartments = new ArrayList<Long>();
			this.reservations = new ArrayList<Long>();
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public ArrayList<Long> getApartmentsForRent() {
			return apartmentsForRent;
		}
		public void addApartmentsForRent(long apartmentForRent) {
			this.apartmentsForRent.add(apartmentForRent);
		}
		public ArrayList<Long> getRentedApartments() {
			return rentedApartments;
		}
		public void addRentedApartments(long rentedApartment) {
			this.rentedApartments.add(rentedApartment);
		}
		public User(String username, String password, String firstName, String lastName, Gender gender, Role role,
				ArrayList<Long> apartmentsForRent, ArrayList<Long> rentedApartments, ArrayList<Long> reservations,
				boolean active) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.role = role;
			this.apartmentsForRent = apartmentsForRent;
			this.rentedApartments = rentedApartments;
			this.reservations = reservations;
			this.active = active;
		}

		public ArrayList<Long> getReservations() {
			return reservations;
		}
		public void setReservations(ArrayList<Long> reservations) {
			this.reservations = reservations;
		}

		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
}
