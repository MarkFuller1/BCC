package BNU.data;

import java.sql.ResultSet;

public class Professor {
	String professor;
	String rating;
	String numberOfReviews;
	
	public Professor(String professor, String rating, String numberOfReviews) {
		super();
		this.professor = professor;
		this.rating = rating;
		this.numberOfReviews = numberOfReviews;
	}
	
	public Professor(ResultSet entry) {
		//TODO: work this out
	}
	
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setNumberOfReviews(String numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
}
