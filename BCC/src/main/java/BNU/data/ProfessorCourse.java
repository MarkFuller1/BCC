package BNU.data;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfessorCourse extends JPanel {
	JLabel professor;
	JLabel rating;
	JLabel numOfReviews;
	public JButton select;

	
	public ProfessorCourse(Course course) {
		this.professor = new JLabel(course.getCourse());
		this.professor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.professor.setBounds(70, 265, 143, 33);
		this.rating = new JLabel(course.getRating());
		this.rating.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.rating.setBounds(70, 265, 143, 33);
		this.numOfReviews = new JLabel(course.getNumberOfReviews());
		this.numOfReviews.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.numOfReviews.setBounds(70, 265, 143, 33);
		this.select = new JButton("Select");
		this.select.setActionCommand("professor:" + course.getCourse());

		this.compilePanel();
	}

	public JButton getSelect() {
		return select;
	}

	public void setSelect(JButton select) {
		this.select = select;
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
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel b = new JPanel();
		b.setPreferredSize(new Dimension(200, 100));
		b.add(this.select);
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(280, 100));
		p.add(this.getProfessor());
		JPanel r = new JPanel();
		r.setPreferredSize(new Dimension(200, 100));
		r.add(this.getRating());
		JPanel n = new JPanel();
		n.setPreferredSize(new Dimension(200, 100));
		n.add(this.getNumOfReviews());
		this.add(b);
		this.add(p);
		this.add(r);
		this.add(n);

		return this;
	}
}
