package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

public class UserDAO {

	private HashMap<String, User> users = new HashMap<String, User>(); 
	private String contextPath;
	
	public UserDAO(String contextPath) throws NoSuchAlgorithmException, IOException {
		this.contextPath = contextPath;
		loadUsers(contextPath);
	}
	
	public User addNewUser(User user) throws IOException, NoSuchAlgorithmException{
		if(users.containsKey(user.getUsername())) {
			return null;
		}
		users.put(user.getUsername(), user);
		saveUsers(contextPath);
		return user;
	}
	
	public User findUser(User user) {
		if(users.containsKey(user.getUsername())){
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
}
