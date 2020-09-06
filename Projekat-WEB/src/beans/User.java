package beans;

import java.util.ArrayList;

public class User {

		private String username; //id
		private String password;
		private String firstName;
		private String lastName;
		private Gender gender;
		private Role role;
		private ArrayList<String> apartmentsForRent;
		private ArrayList<String> rentedApartments;
		private ArrayList<String> reservations;
		
		public User() {
			
		}	
		
		public User(String username, String password, String firstName, String lastName) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			
		}
		
		public User(String username, String password, String firstName, String lastName, Gender gender, Role role) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.role = role;
			this.apartmentsForRent = new ArrayList<String>();
			this.rentedApartments = new ArrayList<String>();
			this.reservations = new ArrayList<String>();
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
		public ArrayList<String> getApartmentsForRent() {
			return apartmentsForRent;
		}
		public void setApartmentsForRent(ArrayList<String> apartmentsForRent) {
			this.apartmentsForRent = apartmentsForRent;
		}
		public ArrayList<String> getRentedApartments() {
			return rentedApartments;
		}
		public void setRentedApartments(ArrayList<String> rentedApartments) {
			this.rentedApartments = rentedApartments;
		}
		public ArrayList<String> getReservations() {
			return reservations;
		}
		public void setReservations(ArrayList<String> reservations) {
			this.reservations = reservations;
		}
}
