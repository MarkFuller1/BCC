package com.BNU.pages.teachersByClass;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfessorCourse extends JPanel{
	JLabel course;
	JLabel rating;
	JLabel numOfReviews;
	
	public JLabel getCourse() {
		return course;
	}
	public void setCourse(JLabel course) {
		this.course = course;
	}
	public JLabel getRating() {
		return rating;
	}
	public void setRating(JLabel rating) {
		this.rating = rating;
	}
	public JLabel getNumOfReviews() {
		return numOfReviews;
	}
	public void setNumOfReviews(JLabel numOfReviews) {
		this.numOfReviews = numOfReviews;
	}
	
	public JPanel compilePanel() {
		this.setLayout(new FlowLayout());
		this.add(course);
		this.add(rating);
		this.add(numOfReviews);
		
		return this;
	}
}
