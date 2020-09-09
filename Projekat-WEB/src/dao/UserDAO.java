package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Gender;
import beans.Role;
import beans.User;

public class UserDAO {

	private HashMap<String, User> users = new HashMap<String, User>(); 
	private String contextPath;
	
	public UserDAO(String contextPath) throws NoSuchAlgorithmException, IOException {
		this.contextPath = contextPath;
		System.out.println(contextPath);
		users = loadUsers(contextPath);
	}
	
	public User addNewUser(User user) throws IOException, NoSuchAlgorithmException{
		if(users.containsKey(user.getUsername())) {
			return null;
		}
		User newUser = createNewUser(user);
		users.put(newUser.getUsername(), newUser);
		saveUsers(contextPath);
		return user;
	}
	
	private User createNewUser(User user) {
		User newUser = new User(user.getUsername(), 
				user.getPassword(), 
				user.getFirstName(), 
				user.getLastName(), 
				getGender(user.getGender().toString()),
				Role.GUEST, 
				true);
		
		return newUser;
	}
	
	private Gender getGender(String gender ) {
		switch (gender) {
		case "MALE":
			return Gender.MALE;
		default:
			return Gender.FEMALE;
		}
	}
	
	private Role getRole(String role ) {
		switch (role) {
		case "HOST":
			return Role.HOST;
		case "GUEST":
			return Role.GUEST;
		default:
			return Role.ADMIN;
		}
	}

	public User findUser(User user) {
		User checkUser = users.get(user.getUsername());
		if (checkUser == null) {
			return null;
		} 
		if(checkUser.isActive()) {
			return users.get(user.getUsername());
		}
		return null;
	}
	
	public User validatePassword(User user) {
		User existing = findUser(user);
		if(existing == null) {
			return null;
		}else if(!existing.getPassword().equals(user.getPassword())) {
			return null;
		}
		return existing;
		
	}
	
	//ucitavanje liste korisnika iz fajla
	public HashMap<String,User> loadUsers(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File userFile = new File(contextPath + "/users.json");
	    
	    boolean created = userFile.createNewFile();
	    if (created) {
	       
	       mapper.writeValue(userFile, users);
	    }
	 
	    return mapper.readValue(userFile, new TypeReference<HashMap<String,User>>() {});
	}
	
	//upisivanje u novi fajl 
	public void saveUsers(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File userFile = new File(contextPath + "/users.json");
	    userFile.createNewFile();
	    mapper.writeValue(userFile, users);
	}
	
	public User getUser(User user) {
		User activeUser = users.get(user.getUsername());
		if(activeUser == null) {
			return null;
		} else if(!activeUser.isActive()) {
			return null;
		}
		
		return activeUser;
	}

	public User editUser(User activeUser, String username, User newUser) {
		User user = findUser(activeUser);
		if(user == null) {
			return null;
		}
		
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setPassword(newUser.getPassword());
		user.setGender(getGender(newUser.getGender().toString()));
		users.put(user.getUsername(), user);
		try {
			saveUsers(contextPath);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public Collection<User> getAllUsers() {
		ArrayList<User> retUsers = new ArrayList<User>();
		
		for (User user : users.values()) {
		
			if(user.isActive()) {
				retUsers.add(user);
			}
		}
		
		return retUsers;
	}

	public Collection<User> findUserByUserName(String username) {
		ArrayList<User> active = (ArrayList<User>) getAllUsers();
		ArrayList<User> retUsers = new ArrayList<User>();
		
		for (User user : active) {
			if(user.getUsername().contains(username)) {
				retUsers.add(user);
			}
		}
		return retUsers;
	}

	public Collection<User> findUserByRole(String role) {
		ArrayList<User> active = (ArrayList<User>) getAllUsers();
		ArrayList<User> retUsers = new ArrayList<User>();
		
		for (User user : active) {
			if(user.getRole().equals(getRole(role))) {
				retUsers.add(user);
			}
		}
		return retUsers;
	}

	public Collection<User> findUserByGender(String gender) {
		ArrayList<User> active = (ArrayList<User>) getAllUsers();
		ArrayList<User> retUsers = new ArrayList<User>();
		
		for (User user : active) {
			if(user.getGender().equals(getGender(gender))) {
				retUsers.add(user);
			}
		}
		return retUsers;
	}
		
}
