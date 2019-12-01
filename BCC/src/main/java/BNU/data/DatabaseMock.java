package BNU.data;

import java.awt.LayoutManager;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DatabaseMock implements dbWrapper{
	
	
	
	
	@Override
	public String[] getAllProfessors() {
		String [] professors = new String[3];
		professors[0] = "Dr. Nikola Tesla";
		professors[1] = "Dr. Thomas Edison";
		professors[2] = "Dr. Alexander Grahm-Bell";
		
		return professors;
	}

	@Override
	public String[] getAllClasses() {
		String [] classes = new String[3];
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

	public String[] getAllProfessorsForClass(String className) {
		String [] a = {"Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell"};
		String [] b = {"Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell"};
		String [] c = {"Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell"};
		
		switch(className) {
		case "Adventures in Multi-Threading":
			return a;
		case "Quantum Computing for Beginners":
			return b;
		case "Intro to GoLang":
			return c;
		}
		return null;
	}

	@Override
	public Professor getProfessor(String prof) {
		ArrayList<Professor> profs = new ArrayList<>();
		String [] courses = {"Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang"};
		
		profs.add(new Professor("Dr. Nikola Tesla",  "99", "4", courses));
		profs.add(new Professor("Dr. Thomas Edison",  "99", "4", courses));
		profs.add(new Professor("Dr. Alexander Grahm-Bell",  "99", "4", courses));
		
		switch(prof) {
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
	public String[] getAllClassesForProfessor(String professorName) {
		String [] a = {"Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang"};
		String [] b = {"Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang"};
		String [] c = {"Adventures in Multi-Threading", "Quantum Computing for Beginners", "Intro to GoLang"};
		System.out.println(professorName);
		switch(professorName) {
		case "Dr. Nikola Tesla":
			return a;
		case "Dr. Thomas Edison":
			return b;
		case "Dr. Alexander Grahm-Bell":
			return c;
		}
		return null;
	}
	
	@Override
	public Course getCourse(String course) {
		ArrayList<Course> courses = new ArrayList<>();
		String [] profs = {"Dr. Nikola Tesla", "Dr. Thomas Edison", "Dr. Alexander Grahm-Bell"};
		
		courses.add(new Course("Adventures in Multi-Threading",  "99", "4", profs));
		courses.add(new Course("Quantum Computing for Beginners",  "99", "4", profs));
		courses.add(new Course("Intro to GoLang",  "99", "4", profs));
		
		switch(course) {
		case "Adventures in Multi-Threading":
			return courses.get(0);
		case "Quantum Computing for Beginners":
			return courses.get(1);
		case "Intro to GoLang":
			return courses.get(2);
			
		}
		return null;
	}

	@Override
	public boolean validateUser(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	//String text, Timestamp time, String sender, String receiver)
	@Override
	public ArrayList<Message> getAllMessages(String sender, String receiver) {
		ArrayList<Message> messages = new ArrayList<>();
		
		String mess = "Hello there!";
		String mess1 = "Hello there mi amigo!";
		String mess2 = "Hello there! What was the class like";
		String mess3 = "Hello there! Not too sure what class?";
		String mess4 = "Hello there! CSI 1430 of course!";
		String mess5 = "Hello there! Oh yea it was pretty easy";
		String mess6 = "Hello there! WHo taught it?";
		String mess7 = "Hello there! DR. Booth";
		
		messages.add(new Message(mess, new Timestamp(System.currentTimeMillis()), sender, receiver));
		messages.add(new Message(mess1, new Timestamp(System.currentTimeMillis()), receiver, sender));
		messages.add(new Message(mess2, new Timestamp(System.currentTimeMillis()), sender, receiver));
		messages.add(new Message(mess3, new Timestamp(System.currentTimeMillis()), receiver, sender));
		messages.add(new Message(mess4, new Timestamp(System.currentTimeMillis()), sender, receiver));
		messages.add(new Message(mess5, new Timestamp(System.currentTimeMillis()), receiver, sender));
		messages.add(new Message(mess6, new Timestamp(System.currentTimeMillis()), sender, receiver));
		messages.add(new Message(mess7, new Timestamp(System.currentTimeMillis()), receiver, sender));
		
		
		return messages;
	}

	@Override
	public String[] getAllFlagged() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getReceiver() {
		String u = "You";
		return u;
	}
	
	public String getSender() {
		String u = "KCP";
		return u;
	}
	

	@Override
	public String[] getAllUserMessagers(String receiver) {
		String [] users = {"MarkFuller","KevinKulda", "ConnorWoodahl", "MO10", "CR7",
				"Dr. Cerny", "Lebron", "Tarjan", "Edison", "Lincoln", "ChickHearn", "KCP", "D12"};
		
		return users;
	}

	@Override
	public void upvote() {
		//update the database
		
	}

	@Override
	public void downvote() {
		//update the database
		
	}

	@Override
	public ArrayList<Review> getReviews(String prof, String c) {
		ArrayList<Review> revs = new ArrayList<>();
		//String description, Timestamp time, String user, String professor, String class1
		String des = "Perpetual motion, the action of a device that, once set in motion,\r\n" + 
				" would continue in motion forever, with no additional energy required to maintain it.\r\n" + 
				" Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\r\n" + 
				"Perpetual motion, although impossible to produce, has fascinated both inventors and the general \r\n" + 
				" public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\r\n" + 
				" virtually free and limitless source of power. The fact that perpetual-motion machines cannot\r\n" + 
				" because they violate the laws of thermodynamics has not discouraged inventors and hucksters \r\n" + 
				" attempting to break, circumvent, or ignore those laws.";
		
		
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer1", "Dr. Cerny", "CSI 3471"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer2", "Dr. Cerny", "CSI 3472"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer3", "Dr. Cerny", "CSI 3473"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer4", "Dr. Cerny", "CSI 3474"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer5", "Dr. Cerny", "CSI 3475"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer6", "Dr. Cerny", "CSI 3476"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer7", "Dr. Cerny", "CSI 3477"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer8", "Dr. Cerny", "CSI 1471"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer9", "Dr. Cerny", "CSI 2472"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer10", "Dr. Cerny", "CSI 4473"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer11", "Dr. Cerny", "CSI 5474"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer12", "Dr. Cerny", "CSI 6475"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer13", "Dr. Cerny", "CSI 7476"));
		revs.add(new Review(des, new Timestamp(System.currentTimeMillis()), "HAppyReviewer14", "Dr. Cerny", "CSI 8477"));
		
		
		
		return revs;
	}

	@Override
	public Boolean isUpvoteValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean isDownvoteValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void sendMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	
}
