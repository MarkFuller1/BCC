package BNU.data.database;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import BNU.data.Course;
import BNU.data.Message;
import BNU.data.Professor;
import BNU.data.Review;
import BNU.singleton.SingletonSession;


public class DatabaseMock extends AbstractDB {

	public static Map<String, String> userCreds = new HashMap<String, String>();;
    public static Vector<Review> reviewVect = new Vector<Review>();
	@Override
	public boolean validateUserImpl(String userName, String password) {
		userCreds.put("aspartame", "aspartame");
		boolean isValid = false;
		if (userCreds.get(userName) != null && userCreds.get(userName).equals(password)) {
			isValid = true;
		}

		// Originally what worked
//		if(userName.compareToIgnoreCase("aspartame") == 0 && password.compareToIgnoreCase("aspartame") == 0) { 
//			isValid = true;
//		}

		return isValid;
	}

	@Override
	public String[] getAllProfessorsImpl() {
		String[] professors = new String[3];
		professors[0] = "Dr. Nikola Tesla";
		professors[1] = "Dr. Thomas Edison";
		professors[2] = "Dr. Alexander Grahm-Bell";

		return professors;
	}

	@Override
	public String[] getAllClassesImpl() {
		String[] classes = new String[3];
		classes[0] = "Adventures in Multi-Threading";
		classes[1] = "Quantum Computing for Beginners";
		classes[2] = "Intro to GoLang";

		return classes;
	}

//	@Override
//	public String[] getPossibleClasses() {
//		String [] classes = new String[16];
//		classes[0] = "CSI 1430";
//		classes[1] = "CSI 1440";
//		classes[2] = "CSI 2350";		
//		classes[3] = "CSI 2334";
//		classes[4] = "CSI 3334";
//		classes[5] = "CSI 3471";		
//		classes[6] = "CSI 3344";
//		classes[7] = "CSI 3336";
//		classes[8] = "CSI 3335";		
//		classes[9] = "CSI 3372";
//		classes[10] = "CSI 3439";
//		classes[11] = "CSI 4337";	
//		classes[12] = "CSI 4321";
//		classes[13] = "PHI 1310";
//		classes[14] = "CSI 43C9";
//		classes[15] = "CSI 4330";
//		return classes;
//	}

	public String[] getAllProfessorsForClassImpl(String className) {
		String[] a = { "Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell" };
		String[] b = { "Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell" };
		String[] c = { "Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell" };

		switch (className) {
		case "Adventures in Multi-Threading":
			return a;
		case "Quantum Computing for Beginners":
			return b;
		case "Intro to GoLang":
			return c;
		}
		return null;
	}

	public Professor getProfessorImpl(String prof) {
		ArrayList<Professor> profs = new ArrayList<>();
		String[] courses = { "Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang" };

		profs.add(new Professor("Dr. Nikola Tesla", "99", "4", courses));
		profs.add(new Professor("Dr. Thomas Edison", "99", "4", courses));
		profs.add(new Professor("Dr. Alexander Grahm-Bell", "99", "4", courses));

		switch (prof) {
		case "Dr. Nikola Tesla":
			return profs.get(0);
		case "Dr. Thomas Edison":
			return profs.get(1);
		case "Dr. Alexander Grahm-Bell":
			return profs.get(2);

		}
		return null;
	}

	@Override
	public String[] getAllClassesForProfessorImpl(String professorName) {
		String[] a = { "Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang" };
		String[] b = { "Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang" };
		String[] c = { "Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang" };
		System.out.println(professorName);
		switch (professorName) {
		case "Dr. Nikola Tesla":
			return a;
		case "Dr. Thomas Edison":
			return b;
		case "Dr. Alexander Grahm-Bell":
			return c;
		}
		return null;
	}

	public Course getCourseImpl(String course) {
		ArrayList<Course> courses = new ArrayList<>();
		String[] profs = { "Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell" };

		courses.add(new Course("Adventures in Multi-Threading", "99", "4"));
		courses.add(new Course("Quantum Computing for Beginners", "99", "4"));
		courses.add(new Course("Intro to GoLang", "99", "4"));

		switch (course) {
		case "Adventures in Multi-Threading":
			return courses.get(0);
		case "Quantum Computing for Beginners":
			return courses.get(1);
		case "Intro to GoLang":
			return courses.get(2);

		}
		return null;
	}

	@SuppressWarnings("null")
	public String[][] getAllCourseInfoByProfImpl(String prof) {
		String[][] courseObjs = new String[3][3];

		courseObjs[0][0] = "Dr. Nikola Tesla";
		courseObjs[0][1] = "99";
		courseObjs[0][2] = "4";

		courseObjs[1][0] = "Dr. Thomas Edison";
		courseObjs[1][1] = "99";
		courseObjs[1][2] = "4";

		courseObjs[2][0] = "Dr. Alexander Grahm-Bell";
		courseObjs[2][1] = "99";
		courseObjs[2][2] = "4";

		return courseObjs;
	}

	@Override
	public String[][] getAllTeacherInfoByCourseImpl(String courseName) {
		String[][] courseObjs = new String[3][3];

		courseObjs[0][0] = "Dr. Nikola Tesla";
		courseObjs[0][1] = "99";
		courseObjs[0][2] = "4";

		courseObjs[1][0] = "Dr. Thomas Edison";
		courseObjs[1][1] = "99";
		courseObjs[1][2] = "4";

		courseObjs[2][0] = "Dr. Alexander Grahm-Bell";
		courseObjs[2][1] = "99";
		courseObjs[2][2] = "4";

		return courseObjs;
	}

	public boolean submitCredentialsImpl(String userName, String password) {
		boolean submitted = false;

		if (userCreds.put(userName, password) == null) {
			submitted = true;
		}

		return submitted;
	}

	public String[][] getAllReviewsForTeacherClassImpl(String professorName, String className) {
		final int NUM_OF_REVIEWS = 10;
		// Vector<String[]> reviews = new Vector<String[]>();
		String[][] strReviews = new String[NUM_OF_REVIEWS][3];

		for (int i = 0; i < NUM_OF_REVIEWS; i++) {
			strReviews[i][0] = "Perpetual motion, the action of a device that, once set in motion,\n"
					+ " would continue in motion forever, with no additional energy required to maintain it.\n"
					+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\n"
					+ "Perpetual motion, although impossible to produce, has fascinated both inventors and the general\n"
					+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\n"
					+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot work\n"
					+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters from\n"
					+ " attempting to break, circumvent, or ignore those laws.";
			strReviews[i][1] = "5";
			strReviews[i][2] = "Steven Jobs";

		}
		return strReviews;
	}

	public String[] getOverallProfessorRatingsImpl(String professorName) {

		Map<String, String[]> profRatings = new HashMap<String, String[]>();
		profRatings.put("Dr. Nikola Tesla", new String[] { "100", "100", "100", "100" });
		profRatings.put("Dr. Thomas Edison", new String[] { "90", "90", "90", "90" });
		profRatings.put("Dr. Alexander Grahm-Bell", new String[] { "80", "80", "80", "80" });

		if (profRatings.containsKey(professorName)) {
			return profRatings.get(professorName);
		}

		return new String[] { "80", "80", "80", "80" };
	}

	@Override
	public String[][] getAllReviewsForUserImpl(String userName) {
		final int NUM_OF_REVIEWS = 10;
		// Vector<String[]> reviews = new Vector<String[]>();
		String[][] strReviews = new String[NUM_OF_REVIEWS][4];

		for (int i = 0; i < NUM_OF_REVIEWS; i++) {
			strReviews[i][0] = "Perpetual motion, the action of a device that, once set in motion,\n"
					+ " would continue in motion forever, with no additional energy required to maintain it.\n"
					+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\n"
					+ "Perpetual motion, although impossible to produce, has fascinated both inventors and the general\n"
					+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\n"
					+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot work\n"
					+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters from\n"
					+ " attempting to break, circumvent, or ignore those laws.";
			strReviews[i][1] = "5";
			strReviews[i][2] = "Steven Jobs";
			strReviews[i][3] = "CSI 1430";

		}
		return strReviews;
	}

	// String text, Timestamp time, String sender, String receiver)
	
	//public ArrayList<Message> getAllMessages(String sender, String receiver) {
	public String[][] getAllMessagesImpl(String sender, String receiver) {
		//ArrayList<Message> messages = new ArrayList<>();
		
		String[][] msgs = new String[8][4];
		
		msgs[0][0] = "Hello there!";
		msgs[1][0] = "Hello there mi amigo!";
		msgs[2][0] = "Hello there! What was the class like";
		msgs[3][0] = "Hello there! Not too sure what class?";
		msgs[4][0] = "Hello there! CSI 1430 of course!";
		msgs[5][0] = "Hello there! Oh yea it was pretty easy";
		msgs[6][0] = "Hello there! WHo taught it?";
		msgs[7][0] = "Hello there! DR. Booth";
		
		for(int i = 0; i < 8; i++) {
			msgs[i][1] = new Timestamp(System.currentTimeMillis()).toString();
			msgs[i][2] = sender;
			msgs[i][3] = receiver;
		}
		
		//String mess = "Hello there!";
		//String mess1 = "Hello there mi amigo!";
		//String mess2 = "Hello there! What was the class like";
		//String mess3 = "Hello there! Not too sure what class?";
		//String mess4 = "Hello there! CSI 1430 of course!";
		//String mess5 = "Hello there! Oh yea it was pretty easy";
		//String mess6 = "Hello there! WHo taught it?";
		//String mess7 = "Hello there! DR. Booth";
		
//		messages.add(new Message(mess, new Timestamp(System.currentTimeMillis()), sender, receiver));
//		messages.add(new Message(mess1, new Timestamp(System.currentTimeMillis()), receiver, sender));
//		messages.add(new Message(mess2, new Timestamp(System.currentTimeMillis()), sender, receiver));
//		messages.add(new Message(mess3, new Timestamp(System.currentTimeMillis()), receiver, sender));
//		messages.add(new Message(mess4, new Timestamp(System.currentTimeMillis()), sender, receiver));
//		messages.add(new Message(mess5, new Timestamp(System.currentTimeMillis()), receiver, sender));
//		messages.add(new Message(mess6, new Timestamp(System.currentTimeMillis()), sender, receiver));
//		messages.add(new Message(mess7, new Timestamp(System.currentTimeMillis()), receiver, sender));
		
		
		return msgs;
	}

	public String[] getAllFlaggedImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReceiverImpl() {
		return SingletonSession.getInstance().getUserName();
	}

	public String getSender() {
		String u = "KCP";
		return u;
	}

	@Override
	public String[] getAllUserMessagersImpl(String receiver) {
		String[] users = { "MarkFuller", "KevinKulda", "ConnorWoodahl", "MO10", "CR7", "Dr. Cerny", "Lebron", "Tarjan",
				"Edison", "Lincoln", "ChickHearn", "KCP", "D12" };

		return users;
	}

	public ArrayList<Review> getReviewsImpl(String prof, String c) {
		ArrayList<Review> revs = new ArrayList<>();
		// String description, Timestamp time, String user, String professor, String
		// class1
		String des = "Perpetual motion, the action of a device that, once set in motion,\r\n"
				+ " would continue in motion forever, with no additional energy required to maintain it.\r\n"
				+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\r\n"
				+ "Perpetual motion, although impossible to produce, has fascinated both inventors and the general \r\n"
				+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\r\n"
				+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot\r\n"
				+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters \r\n"
				+ " attempting to break, circumvent, or ignore those laws.";

		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3471"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3472"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3473"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3474"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3475"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3476"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 3477"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 1471"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 2472"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 4473"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 5474"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 6475"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 7476"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer", "Dr. Cerny", "CSI 8477"));

		return revs;
	}

	@Override
	protected Connection getRemoteConnection() throws DatabaseConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getRecieverImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSenderImpl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void upvoteImpl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void downvoteImpl() {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void setNewReview(String userName, String professorName, String className, String content, String tA,
			String h, String wL) {
		Review rev = new Review(content, new Timestamp(System.currentTimeMillis()),userName, professorName,className, 
				new Integer(tA), new Integer(h), new Integer(wL));
		System.out.println(rev.toString());
		reviewVect.add(rev);
		
		
	}





	@Override
	public boolean isAdmin(String userName) {
		boolean isAdmin = false;
		if(userCreds.get(userName) != null ){
			isAdmin = true;
		}
		return true;//returning true instead of isAdmin to simplify development
	}

	@Override
	protected String[][] getAllMessagesImpl(String receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Boolean sendMessageImpl(Message m, String from, String to, String date) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
