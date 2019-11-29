package BNU.data;

public class DatabaseOperationException extends Exception {

	private String message;
	
	public DatabaseOperationException(String message){
		this.message = message;
	}
	
	public final String getMessage() {
		return this.message;
	}
}
