package BNU.singleton;

import BNU.logic.service.proxy.SmartProxy;

public class SingletonSession {
	static String userName;
	static boolean isAdmin;
	
    private static final SingletonSession SINGLE_INSTANCE = new SingletonSession();
    
    private SingletonSession() {
    	//SingletonSession.setUserName("plug");
    	//SingletonSession.setAdmin(false);
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
