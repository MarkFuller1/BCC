package BNU.data.database;

public class DatabaseConnectionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message = "Unable to connect to the database";
	
	DatabaseConnectionException(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
