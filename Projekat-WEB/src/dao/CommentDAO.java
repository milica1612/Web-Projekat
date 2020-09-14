package dao;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Comment;

public class CommentDAO {
	
	private HashMap<Long, Comment> comments = new HashMap<Long, Comment>(); 
	private String contextPath;
	
	public CommentDAO(String path) {
		super();
		this.contextPath = path;
	}
	
	public Comment addNewComment(Comment comment) {	
		
		Comment newComment = createNewComment(comment);
		comments.put(newComment.getId(), newComment);
		try {
			saveComments(contextPath);
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return newComment;
	}
	
	private Comment createNewComment(Comment comment) {
		
		long id = comments.size() + 1;
		Comment newComment = new Comment(
				id,
				comment.getGuest(),
				comment.getApartment(),
				comment.getText(),
				comment.getGrade(),
				true
				);
		
		return newComment;
	}
	
	public HashMap<Long, Comment> loadComments(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File commentFile = new File(contextPath + "/comments.json");
	    
	    boolean created = commentFile.createNewFile();
	    if (created) {
	       
	       mapper.writeValue(commentFile, comments);
	    }
	 
	    return mapper.readValue(commentFile, new TypeReference<HashMap<Long, Comment>>() {});
	}
	
	
	public void saveComments(String contextPath) throws IOException, NoSuchAlgorithmException {
	    ObjectMapper mapper = new ObjectMapper();
	    File commentFile = new File(contextPath + "/comments.json");
	    commentFile.createNewFile();
	    mapper.writeValue(commentFile, comments);
	}
}
