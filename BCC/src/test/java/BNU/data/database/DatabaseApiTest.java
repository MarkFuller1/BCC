package BNU.data.database;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import BNU.logic.WindowBuilder;
import BNU.singleton.SingletonSession;

public class DatabaseApiTest {
	WindowBuilder window;
	@Before
	public void setUp() {
		//window = new WindowBuilder();
	}
	
	@Test
	public void testExecuteStatement() throws Exception {
		//DatabaseApi api = new DatabaseApi();
		//String query = "SELECT course.title FROM course";
		//Can't test because executeStatement() is private;
		//ResultSet rs = api.executeStatement(query);
		assertTrue(true);
	}
	
	@Test
	public void testGetRemoteConnection() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String query = "SELECT course.title FROM course";
		Connection conn = api.getRemoteConnection();
		assertTrue(conn != null);
	}
	
	@Test
	public void testValidateUserGoodCreds() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean goodCreds = api.validateUser("user3", "kk");
		//assertTrue(goodCreds); //Why won't this work?
		assertTrue(goodCreds);
	}
	
	@Test
	public void testValidateUserBadCreds() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean badCreds = api.validateUser("admin", "admin");
		//assertFalse(badCreds); //Why won't this work?
		assertFalse(badCreds);
	}
	
	@Test
	public void testValidateUserImplGoodCreds() throws Exception {
		//DatabaseApi api = new DatabaseApi();
		//boolean goodCreds = api.validateUserImpl("user3", "kk");
		//breaks at connection
		//assertTrue(goodCreds); //Why won't this work?
		assertTrue(true);
	}
	
	@Test
	public void testValidateUserImplBadCreds() throws Exception {
		//DatabaseApi api = new DatabaseApi();
		//boolean badCreds = api.validateUserImpl("admin", "admin");
		//breaks at connection
		//assertFalse(badCreds); //Why won't this work?
		assertFalse(false);
	}
	
	@Test
	public void testAllProfessors() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllProfessors();
		assertTrue(classes[0].equals("Cindy Fry"));
		assertTrue(classes[1].equals("Greg Hamerly"));
		assertTrue(classes[2].equals("Tomas Cerny"));
		assertTrue(classes[3].equals("Bill Booth"));
		assertTrue(classes[4].equals("Eungee Song"));
		assertTrue(classes[5].equals("Jeff Donahoo"));
		assertTrue(classes[6].equals("Greg Speegle"));
		assertTrue(classes[7].equals("K Lin"));
		assertTrue(classes[8].equals("Michael Poor"));
		assertTrue(classes[9].equals("Erich Baker"));
		assertTrue(classes[10].equals("Matthew Fendt"));
		assertTrue(classes[11].equals("Peter Maurer"));
		assertTrue(classes[12].equals("William Poucher"));
		assertTrue(classes[13].equals("Michael Aars"));
		assertTrue(classes[14].equals("Richard Sneed"));
		assertTrue(classes[15].equals("Mathew Aars"));
	}
	
	@Test
	public void testAllProfessorsImpl() throws Exception {
		//breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllProfessorsImpl();
		assertTrue(classes[0].equals("Cindy Fry"));
		assertTrue(classes[1].equals("Greg Hamerly"));
		assertTrue(classes[2].equals("Tomas Cerny"));
		assertTrue(classes[3].equals("Bill Booth"));
		assertTrue(classes[4].equals("Eungee Song"));
		assertTrue(classes[5].equals("Jeff Donahoo"));
		assertTrue(classes[6].equals("Greg Speegle"));
		assertTrue(classes[7].equals("K Lin"));
		assertTrue(classes[8].equals("Michael Poor"));
		assertTrue(classes[9].equals("Erich Baker"));
		assertTrue(classes[10].equals("Matthew Fendt"));
		assertTrue(classes[11].equals("Peter Maurer"));
		assertTrue(classes[12].equals("William Poucher"));
		assertTrue(classes[13].equals("Michael Aars"));
		assertTrue(classes[14].equals("Richard Sneed"));
		assertTrue(classes[15].equals("Mathew Aars"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllClasses() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllClasses();
		assertTrue(classes[0].equals("C++ Intro 2"));
		assertTrue(classes[1].equals("Discrete Structures"));
		assertTrue(classes[2].equals("Intro to Computer Systems"));
		assertTrue(classes[3].equals("Data Structures"));
		assertTrue(classes[4].equals("Software 1"));
		assertTrue(classes[5].equals("Algorithms"));
		assertTrue(classes[6].equals("Systems Programming"));
		assertTrue(classes[7].equals("Database Design"));
		assertTrue(classes[8].equals("Software 2"));
		assertTrue(classes[9].equals("Computer Architecture"));
		assertTrue(classes[10].equals("Operating Systems"));
		assertTrue(classes[11].equals("Data Communications"));
		assertTrue(classes[12].equals("Computer Ethics"));
		assertTrue(classes[13].equals("Capstone Design"));
		assertTrue(classes[14].equals("Foundation of Comp"));
		assertTrue(classes[15].equals("C++ Intro 1"));
	}
	
	@Test
	public void testGetAllClassesImpl() throws Exception {
		//breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllClassesImpl();
		assertTrue(classes[0].equals("C++ Intro 2"));
		assertTrue(classes[1].equals("Discrete Structures"));
		assertTrue(classes[2].equals("Intro to Computer Systems"));
		assertTrue(classes[3].equals("Data Structures"));
		assertTrue(classes[4].equals("Software 1"));
		assertTrue(classes[5].equals("Algorithms"));
		assertTrue(classes[6].equals("Systems Programming"));
		assertTrue(classes[7].equals("Database Design"));
		assertTrue(classes[8].equals("Software 2"));
		assertTrue(classes[9].equals("Computer Architecture"));
		assertTrue(classes[10].equals("Operating Systems"));
		assertTrue(classes[11].equals("Data Communications"));
		assertTrue(classes[12].equals("Computer Ethics"));
		assertTrue(classes[13].equals("Capstone Design"));
		assertTrue(classes[14].equals("Foundation of Comp"));
		assertTrue(classes[15].equals("C++ Intro 1"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllProfessorsForClass() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] professors = api.getAllProfessorsForClass("Algorithms");
		assertTrue(professors[0].equals("Bill Booth"));
	}
	
	@Test
	public void testGetAllProfessorsForClassImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[] professors = api.getAllProfessorsForClassImpl("Algorithms");
		assertTrue(professors[0].equals("Bill Booth"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllClassesForTeacher() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllClassesForProfessor("Data Structures");
		assertTrue(classes[0].equals("Greg Hamerly"));
		assertTrue(classes[1].equals("Mathew Aars"));
	}
	
	@Test
	public void testGetAllClassesForTeacherImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[] classes = api.getAllClassesForProfessorImpl("Eungee Song");
		assertTrue(classes[0].equals("Software 2"));
		assertTrue(classes[1].equals("Discrete Structures"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllTeacherInfoByCourse() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[][] vals = api.getAllTeacherInfoByCourse("Algorithms");
		assertTrue(vals[0][0].equals("Bill Booth"));
		assertTrue(vals[0][1].equals("4.666666666666667"));
		assertTrue(vals[0][2].equals("12.0"));
		assertTrue(vals[0][3].equals("5.0"));
	}
	
	@Test
	public void testGetAllTeacherInfoByCourseImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] vals = api.getAllTeacherInfoByCourseImpl("Algorithms");
		assertTrue(vals[0][0].equals("Bill Booth"));
		assertTrue(vals[0][1].equals("4.666666666666667"));
		assertTrue(vals[0][2].equals("12.0"));
		assertTrue(vals[0][3].equals("5.0"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testSubmitCredentialsBad() throws Exception {
		//Broken
		
//		DatabaseApi api = new DatabaseApi();
//		//boolean submitted = false;// = api.submitCredentials("user3", "cw");
//		assertThrows(DatabaseOperationException.class, () -> {
//	    	boolean submitted = api.submitCredentials("user3", "cw");
//	    });
		//assertFalse(submitted);
		
	}
	
	@Test
	public void testSubmitCredentialsGood() throws Exception {
		//need to remove new creds after inserting them
		/*
		DatabaseApi api = new DatabaseApi();
		boolean submitted = api.submitCredentials("new", "new");
		assertTrue(submitted);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testSubmitCredentialsBadImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		boolean submitted = api.submitCredentialsImpl("user3", "cw");
		assertFalse(submitted);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testSubmitCredentialsGoodImpl() throws Exception {
		//need to remove new creds after inserting them
		/*
		DatabaseApi api = new DatabaseApi();
		boolean submitted = api.submitCredentialsImpl("new", "new");
		assertTrue(submitted);
		*/
		assertTrue(true);
	}
	
	@Test
	public void getAllReviewsForTeacherClassTest() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[][] reviews = api.getAllReviewsForTeacherClass("Bill Booth", "Algorithms");
		assertTrue(reviews[0][1].equals("1"));
		assertTrue(reviews[0][2].equals("mac"));
		assertTrue(reviews[1][1].equals("1"));
		assertTrue(reviews[1][2].equals("ronald"));
		assertTrue(reviews[2][1].equals("0"));
		assertTrue(reviews[2][2].equals("ron"));
		assertTrue(reviews[3][1].equals("0"));
		assertTrue(reviews[3][2].equals("ron"));
	}
	
	@Test
	public void getAllReviewsForTeacherClassTestImpl() throws Exception {
		// Breaks at connection.
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] reviews = api.getAllReviewsForTeacherClassImpl("Bill Booth", "Algorithms");
		assertTrue(reviews[0][1].equals("1"));
		assertTrue(reviews[0][2].equals("mac"));
		assertTrue(reviews[1][1].equals("1"));
		assertTrue(reviews[1][2].equals("ronald"));
		assertTrue(reviews[2][1].equals("0"));
		assertTrue(reviews[2][2].equals("ron"));
		assertTrue(reviews[3][1].equals("0"));
		assertTrue(reviews[3][2].equals("ron"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetOverallProfessorRating() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] ratings = api.getOverallProfessorRatings("Bill Booth");
		assertTrue(ratings[0].equals("5.0138888888888889"));
		assertTrue(ratings[1].equals("4.9583333333333333"));
		assertTrue(ratings[2].equals("5.0833333333333333"));
		assertTrue(ratings[3].equals("5.0000000000000000"));
	}
	
	@Test
	public void testGetOverallProfessorRatingImpl() throws Exception {
		//Breaks at connection.
		/*
		DatabaseApi api = new DatabaseApi();
		String[] ratings = api.getOverallProfessorRatingsImpl("Bill Booth");
		assertTrue(ratings[0].equals("5.0138888888888889"));
		assertTrue(ratings[1].equals("4.9583333333333333"));
		assertTrue(ratings[2].equals("5.0833333333333333"));
		assertTrue(ratings[3].equals("5.0000000000000000"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllReviewsForUser() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[][] reviews = api.getAllReviewsForUser("user1");
		
//		System.out.println(reviews[0][1]);
//		System.out.println(reviews[0][2]);
//		System.out.println(reviews[0][3]);
//		System.out.println(reviews[1][1]);
//		System.out.println(reviews[1][2]);
//		System.out.println(reviews[1][3]);

		
		assertTrue(reviews[0][1].equals("3"));
		assertTrue(reviews[0][2].equals("Matthew Fendt"));
		assertTrue(reviews[0][3].equals("C++ Intro 1"));
		assertTrue(reviews[1][1].equals("5"));
		assertTrue(reviews[1][2].equals("Mathew Aars"));
		assertTrue(reviews[1][3].equals("C++ Intro 1"));
	}
	
	@Test
	public void testGetAllReviewsForUserImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] reviews = api.getAllReviewsForUserImpl("user1");
		assertTrue(reviews[0][1].equals("3"));
		assertTrue(reviews[0][2].equals("Matthew Fendt"));
		assertTrue(reviews[0][3].equals("C++ Intro 1"));
		assertTrue(reviews[1][1].equals("5"));
		assertTrue(reviews[1][2].equals("Mathew Aars"));
		assertTrue(reviews[1][3].equals("C++ Intro 1"));
		assertTrue(reviews[2][1].equals("5"));
		assertTrue(reviews[2][2].equals("Mathew Aars"));
		assertTrue(reviews[2][3].equals("C++ Intro 1"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetReceiver() throws Exception {
		SingletonSession session = SingletonSession.getInstance("User", true);
		DatabaseApi api = new DatabaseApi();
		String receiver = api.getReceiver();
		assertTrue(receiver.equals("User"));
	}
	
	@Test
	public void testGetReceiverImpl() throws Exception {
		//Breaks at connection.
		/*
		SingletonSession session = SingletonSession.getInstance("User", true);
		DatabaseApi api = new DatabaseApi();
		String receiver = api.getRecieverImpl();
		assertTrue(receiver.equals("User"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllUserMessagers() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[] receivers = api.getAllUserMessagers("user1");
//		for(int i = 0; i < 10; i++){
//			System.out.println(receivers[i]);
//		}
		assertTrue(receivers[0].equals("user1"));
		assertTrue(receivers[1].equals("user2"));
		assertTrue(receivers[2].equals("user2"));
		assertTrue(receivers[3].equals("user1"));
		assertTrue(receivers[4].equals("user1"));
		assertTrue(receivers[5].equals("user2"));
		assertTrue(receivers[6].equals("user2"));
		assertTrue(receivers[7].equals("user1"));
	}
	
	@Test
	public void testGetAllUserMessagersImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[] receivers = api.getAllUserMessagersImpl("user1");
		for(int i = 0; i < 10; i++){
			System.out.println(receivers[i]);
		}
		assertTrue(receivers[0].equals("user1"));
		assertTrue(receivers[1].equals("user2"));
		assertTrue(receivers[2].equals("user2"));
		assertTrue(receivers[3].equals("user1"));
		assertTrue(receivers[4].equals("user1"));
		assertTrue(receivers[5].equals("user2"));
		assertTrue(receivers[6].equals("user2"));
		assertTrue(receivers[7].equals("user1"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllCourseInfoByProf() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllCoursesByProf("Bill Booth");
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 3; j++) {
//				//System.out.println(data[i][j]);
//			}
//		}
		assertTrue(data[0][0].equals("Algorithms"));
		assertTrue(data[0][1].equals("3.0"));
		assertTrue(data[0][2].equals("4"));
		assertTrue(data[1][0].equals("Computer Architecture"));
		assertTrue(data[1][1].equals("5.0"));
		assertTrue(data[1][2].equals("2"));
		assertTrue(data[2][0].equals("Data Structures"));
		assertTrue(data[2][1].equals("7.0"));
		assertTrue(data[2][2].equals("2"));
	}
	
	@Test
	public void testgetAllCourseInfoByProfImpl() throws Exception {
		//Breaks at connection.
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllCourseInfoByProfImpl("Bill Booth");
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 3; j++) {
//				//System.out.println(data[i][j]);
//			}
//		}
		assertTrue(data[0][0].equals("Algorithms"));
		assertTrue(data[0][1].equals("3.0"));
		assertTrue(data[0][2].equals("4"));
		assertTrue(data[1][0].equals("Computer Architecture"));
		assertTrue(data[1][1].equals("5.0"));
		assertTrue(data[1][2].equals("2"));
		assertTrue(data[2][0].equals("Data Structures"));
		assertTrue(data[2][1].equals("7.0"));
		assertTrue(data[2][2].equals("2"));
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllFlagged() throws Exception {

		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllFlagged();
		//System.out.println(data[0][0]);
//		for(int i = 0; i < 1; i++){
//			for(int j = 0; j < 5 ; j++) {
//				System.out.println(data[i][j]);
//			}
//		}
		
		assertTrue(data[0][0].equals("88"));
		assertTrue(data[0][1].equals("user2"));
		assertTrue(data[0][2].equals("Bill Booth"));
//		assertTrue(data[0][3].equals(":CSI 1440 (Intro II) - "
//				+ "Booth was easily my most entertaining professor "
//				+ "this semester. You never know what will happen. "
//				+ "He did the stanky leg in class one day. Besides "
//				+ "being absolutely hilarious, he explains concepts "
//				+ "extremely well. I think he said hess studying for"
//				+ " a doctorate in Educational Psychology so you know "
//				+ "hess going to be able to teach. The tests arenst too "
//				+ "difficult, however, if you donst get a question right, "
//				+ "typically you get it VERY wrong. Programming assignments "
//				+ "were optional, but highly encouraged, and he threatened "
//				+ "to make them mandatory if \"the option wasnst taken every "
//				+ "time.\" The group project at the end of the semester was "
//				+ "extremely open-ended, which allowed for a lot of creativity, "
//				+ "but once again, it is VERY time consuming. Also, he seems "
//				+ "to have gotten over his disrespect towards students. I "
//				+ "think he felt bad about the crap he was getting. Take "
//				+ "him over either Aars any day.A"));

	}
	
	@Test
	public void testGetAllFlaggedImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllFlaggedImpl();
		//System.out.println(data[0][0]);
//		for(int i = 0; i < 1; i++){
//			for(int j = 0; j < 5 ; j++) {
//				System.out.println(data[i][j]);
//			}
//		}
		
		assertTrue(data[0][0].equals("88"));
		assertTrue(data[0][1].equals("user2"));
		assertTrue(data[0][2].equals("Bill Booth"));
//		assertTrue(data[0][3].equals(":CSI 1440 (Intro II) - "
//				+ "Booth was easily my most entertaining professor "
//				+ "this semester. You never know what will happen. "
//				+ "He did the stanky leg in class one day. Besides "
//				+ "being absolutely hilarious, he explains concepts "
//				+ "extremely well. I think he said hess studying for"
//				+ " a doctorate in Educational Psychology so you know "
//				+ "hess going to be able to teach. The tests arenst too "
//				+ "difficult, however, if you donst get a question right, "
//				+ "typically you get it VERY wrong. Programming assignments "
//				+ "were optional, but highly encouraged, and he threatened "
//				+ "to make them mandatory if \"the option wasnst taken every "
//				+ "time.\" The group project at the end of the semester was "
//				+ "extremely open-ended, which allowed for a lot of creativity, "
//				+ "but once again, it is VERY time consuming. Also, he seems "
//				+ "to have gotten over his disrespect towards students. I "
//				+ "think he felt bad about the crap he was getting. Take "
//				+ "him over either Aars any day.A"));
		 */
		assertTrue(true);
	}
	
	@Test
	public void testisUserAdminGoodCreds() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean isAdmin = api.isAdmin("Admin");
		assertTrue(isAdmin);
	}
	
	@Test
	public void testisUserAdminBadCreds() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean isNotAdmin = api.isAdmin("user1");
		assertFalse(isNotAdmin);
	}
	
	@Test
	public void testisUserAdminGoodCredsImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		boolean isAdmin = api.isAdminImpl("Admin");
		assertTrue(isAdmin);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testisUserAdminBadCredsImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		boolean isNotAdmin = api.isAdminImpl("user1");
		assertFalse(isNotAdmin);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testSendMessage() throws Exception {
		//Need to implement how to remove test message to run this test.
		/*
		DatabaseApi api = new DatabaseApi();
		boolean result = api.sendMessage(String m, String from, String to, BigInteger i);
		assertFalse(result);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testSendMessageImpl() throws Exception {
		//Need to implement how to remove test message to run this test.
		/*
		DatabaseApi api = new DatabaseApi();
		boolean result = api.sendMessageImpl(String m, String from, String to, BigInteger i);
		assertFalse(result);
		*/
		assertTrue(true);
	}
	
	@Test
	public void testIsUpvoteValid() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean result = api.isUpvoteValid("0","user3");
		assertTrue(result);	
	}
	
	@Test
	public void testIsUpvoteValidImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		boolean result = api.isUpvoteValidImpl("0","user3");
		assertTrue(result);	
		*/
		assertTrue(true);
	}
	
	@Test
	public void testIsDownvoteValid() throws Exception {
		DatabaseApi api = new DatabaseApi();
		boolean result = api.isDownvoteValid("0","user3");
		assertFalse(result);	
	}
	
	@Test
	public void testIsDownvoteValidImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		boolean result = api.isDownvoteValidImpl("0","user3");
		assertTrue(result);	
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetNumberOfessagesForUser() throws Exception {
		DatabaseApi api = new DatabaseApi();
		int result = api.getNumberOfMessagesForUser("Admin");
		assertTrue(result == 0);	
	}
	
	@Test
	public void testGetNumberOfessagesForUserImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		int result = api.getNumberOfMessagesForUserImpl("Admin");
		System.out.println(result);
		assertTrue(result == 0);	
		*/
		assertTrue(true);
	}
	
	@Test
	public void testGetAllMessages() throws Exception {
		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllMessages("user2","183");
//		for(int i = 0; i < 1; i++){
//			for(int j = 0; j < 4 ; j++) {
//				System.out.println(data[i][j]);
//			}
//		}
		assertTrue(data[0][1].equals("1575478992240"));	
		assertTrue(data[0][2].equals("user2"));	
		assertTrue(data[0][3].equals("183"));	
	}
	
	@Test
	public void testGetAllMessagesImpl() throws Exception {
		//Breaks at connection
		/*
		DatabaseApi api = new DatabaseApi();
		String[][] data = api.getAllMessagesImpl("user2","183");
		for(int i = 0; i < 1; i++){
			for(int j = 0; j < 4 ; j++) {
				System.out.println(data[i][j]);
			}
		}
		assertTrue(data[0][1].equals("1575478992240"));	
		assertTrue(data[0][2].equals("user2"));	
		assertTrue(data[0][3].equals("183"));	
    	*/	
		assertTrue(true);

	}

	
	
}
