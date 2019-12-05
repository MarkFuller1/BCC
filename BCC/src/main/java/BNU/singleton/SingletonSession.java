package BNU.singleton;

import BNU.logic.service.proxy.SmartProxy;

/**
 * 
 * @author Kevin
 * 
 * Singleton GoF Design Pattern
 * Creational
 * 
 * This class follows the singleton design pattern because only one instance
 * of it will exist. The existence of only one object is controlled by the 
 * private constructor. This program uses this singleton as a session
 * monitor to track which user is logged into the application and whether that
 * user is an admin. This is useful because the program will need to know
 * in certain instances who the user is and whether they are an admin. 
 */

public class SingletonSession {
	static String userName;
	static boolean isAdmin;
	
    private static final SingletonSession SINGLE_INSTANCE = new SingletonSession();
    
    private SingletonSession() {
    }

    private SingletonSession(String userName, boolean isAdmin) {
    	  SingletonSession.setUserName(userName);
      	  SingletonSession.setAdmin(isAdmin);
    }

  public static SingletonSession getInstance() {
      return SINGLE_INSTANCE;
    }
  
  public static SingletonSession getInstance(String userName, boolean isAdmin) {
  	  SingletonSession.setUserName(userName);
  	  SingletonSession.setAdmin(isAdmin);
      return SINGLE_INSTANCE;
    }

public static String getUserName() {
	return userName;
}

public static void setUserName(String userName) {
	SmartProxy sp = new SmartProxy();
	String cleanUN = sp.sanatizeInput(userName);
	SingletonSession.userName = cleanUN;
}

public static boolean isAdmin() {
	return isAdmin;
}

public static void setAdmin(boolean isAdmin) {
	SingletonSession.isAdmin = isAdmin;
}
	

}
