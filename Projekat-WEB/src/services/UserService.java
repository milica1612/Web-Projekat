package services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;

import beans.User;
import dao.UserDAO;

@Path("/users")
public class UserService {
	
	@Context
	public ServletContext ctx;
	String contextPath;
	
	public UserService() {
	}
	
	@PostConstruct
		public void init() throws NoSuchAlgorithmException, IOException {
		if (ctx.getAttribute("userDAO") == null) {
	    	contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDAO(contextPath));
		}
	}
	
	//pronalazi ulogovanog korisnika
	@GET
	@Path("/active")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("username") String username, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User activeUser = (User) request.getSession(false).getAttribute("user");
		
		return userDao.getUser(activeUser);
	}
	
	@GET
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getAllUsers(@Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");

		return userDao.getAllUsers();
	}
		
	@GET
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> findUsersByUserName(@PathParam("username") String username, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return userDao.findUserByUserName(username);
	}
	
	@GET
	@Path("/{gender}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<User> findUsersByGender(@PathParam("gender") String gender, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return userDao.findUserByGender(gender);
	}
	
	@GET
	@Path("/{role}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> findUsersByRole(@PathParam("role") String role, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return userDao.findUserByRole(role);
	}
	

	
	@PUT
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User editUser(@PathParam("username") String username, 
						 User newUser,
						 @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User activeUser = (User) request.getSession(false).getAttribute("user");
		
		return userDao.editUser(activeUser, username, newUser);
	}

}
