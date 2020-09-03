package dao;

import java.io.BufferedWriter;
import java.util.HashMap;

import org.apache.tomcat.jni.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

public class UserDAO {

	private HashMap<String, User> users = new HashMap<String, User>();
	
	public UserDAO(){
		
	}
	
	public User addNew(User user){
		users.put(user.getUsername(), user);
		return user;
	}
	
	public void save(String contextPath) {
		ObjectMapper mapper = new ObjectMapper();
		File userFile = new File();
	}
	
}
