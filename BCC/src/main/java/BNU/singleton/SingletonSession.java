package BNU.singleton;

public class SingletonSession {
	static String userName;
	static boolean isAdmin;
	
    private static final SingletonSession SINGLE_INSTANCE = new SingletonSession(userName, isAdmin);
    
    private SingletonSession() {
    	SingletonSession.userName = "plug";
    	SingletonSession.isAdmin = false;
    }

    private SingletonSession(String userName, boolean isAdmin) {
    	SingletonSession.userName = userName;
    	SingletonSession.isAdmin = isAdmin;
    }

  public static SingletonSession getInstance() {

      return SINGLE_INSTANCE;

    }
  
  public static SingletonSession getInstance(String userName, boolean isAdmin) {
  	  SingletonSession.userName = userName;
  	  SingletonSession.isAdmin = isAdmin;
      return SINGLE_INSTANCE;

    }

public static String getUserName() {
	return userName;
}

public static void setUserName(String userName) {
	SingletonSession.userName = userName;
}

public static boolean isAdmin() {
	return isAdmin;
}

public static void setAdmin(boolean isAdmin) {
	SingletonSession.isAdmin = isAdmin;
}
	

}
