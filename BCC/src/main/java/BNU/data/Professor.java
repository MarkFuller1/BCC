package BNU.data;

import java.sql.ResultSet;

public class Professor {
	public String professor;
	String rating;
	String numberOfReviews;
	String[] courses;
	
	public Professor(String professor, String rating, String numberOfReviews, String[] courses) {
		super();
		this.professor = professor;
		this.rating = rating;
		this.numberOfReviews = numberOfReviews;
		this.courses = courses;
	}
	
	public Professor(String name) {
		this.professor = name;
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
