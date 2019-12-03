package BNU.data.database;

public class DatabaseOperationException extends Exception {

	private String message;
	
	public DatabaseOperationException(String message){
		this.message = message;
	}
	
	public final String getMessage() {
		return this.message;
	}
}
