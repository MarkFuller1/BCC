package com.BNU.pages.teachersByClass;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourseProfessor extends JPanel {
	JLabel professor;
	JLabel rating;
	JLabel numOfReviews;

	public CourseProfessor(Professor professor) {
		this.professor = new JLabel(professor.getProfessor());
		this.professor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.professor.setBounds(70, 265, 143, 33);
		this.rating = new JLabel(professor.getRating());
		this.rating.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.rating.setBounds(70, 265, 143, 33);
		this.numOfReviews = new JLabel(professor.getNumberOfReviews());
		this.numOfReviews.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.numOfReviews.setBounds(70, 265, 143, 33);
		this.compilePanel();
	}

	public JLabel getProfessor() {
		return professor;
	}

	public void setProfessor(JLabel professor) {
		this.professor = professor;
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
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 220, 10));
		this.add(this.getProfessor());
		this.add(this.getRating());
		this.add(this.getNumOfReviews());

		return this;
	}
}
