package BNU.data;

public class Course {
	
	String course;
	String rating;
	String numberOfReviews;
	
	public Course(String course, String rating, String numberOfReviews) {
		super();
		this.course = course;
		this.rating = rating;
		this.numberOfReviews = numberOfReviews;
	}
	
	public String getCourse() {
		return course;
	}
	public void setcourse(String course) {
		this.course = course;
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
