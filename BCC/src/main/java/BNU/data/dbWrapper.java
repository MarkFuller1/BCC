package BNU.data;

import java.util.ArrayList;

public interface dbWrapper {
	boolean validateUser(String userName, String password); //new
	
	String[] getAllProfessors();
	
	String[] getAllClasses();
	
	String[] getAllProfessorsForClass(String className);

	Professor getProfessor(String Prof);

	String[] getAllClassesForProfessor(String professorName);

	Course getCourse(String course);
	
	// my added functions 
	ArrayList<Message> getAllMessages(String sender, String receiver);
	
	String[] getAllFlagged();
	
	String getReceiver();
	
	String getSender();
	
	String[] getAllUserMessagers(String receiver);
	
	void upvote();
	
	void downvote();
	
	void sendMessage(Message m);
	
	ArrayList<Review> getReviews(String prof, String c);
	
	Boolean isUpvoteValid();
	
	Boolean isDownvoteValid();

}
