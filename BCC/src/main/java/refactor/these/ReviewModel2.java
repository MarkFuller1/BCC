package refactor.these;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ReviewModel2 {
	
	private JButton btnUp;
	private JButton btnDown;
	private JLabel reviewScore;
	private JScrollPane reviewScrollPane;
	private JLabel studentReview;
	private JLabel reviewerID;
	private JButton btnMessageReviewer;
	private JPanel panel;
	private JTextPane textPane;
	
	
	public JButton getBtnUp() {
		return btnUp;
	}
	public void setBtnUp(JButton btnUp) {
		this.btnUp = btnUp;
	}
	public JButton getBtnDown() {
		return btnDown;
	}
	public void setBtnDown(JButton btnDown) {
		this.btnDown = btnDown;
	}
	public JLabel getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(JLabel reviewScore) {
		this.reviewScore = reviewScore;
	}
	public JScrollPane getReviewScrollPane() {
		return reviewScrollPane;
	}
	public void setReviewScrollPane(JScrollPane reviewScrollPane) {
		this.reviewScrollPane = reviewScrollPane;
	}
	public JLabel getStudentReview() {
		return studentReview;
	}
	public void setStudentReview(JLabel studentReview) {
		this.studentReview = studentReview;
	}
	public JLabel getReviewerID() {
		return reviewerID;
	}
	public void setReviewerID(JLabel reviewerID) {
		this.reviewerID = reviewerID;
	}
	public JButton getBtnMessageReviewer() {
		return btnMessageReviewer;
	}
	public void setBtnMessageReviewer(JButton btnMessageReviewer) {
		this.btnMessageReviewer = btnMessageReviewer;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextPane getTextPane() {
		return textPane;
	}
	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
	
	
	
	public void createReviewItem() {  //Should take a database object as a parameter and populate this info using a record.
		//ReviewModel rm = new ReviewModel();
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		panel.setSize(804,200);
		panel.setVisible(true);
		
		g.insets = new Insets(5,5,5,5);
		
		// up button
		setBtnUp(new JButton("+"));
		getBtnUp().setForeground(Color.GREEN);
		getBtnUp().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 1;
		panel.add(getBtnUp(), g);


		// down button
		setBtnDown(new JButton("-"));
		getBtnDown().setForeground(Color.RED);
		getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 3;
		panel.add(getBtnDown(), g);

		// review score label
		setReviewScore(new JLabel("4"));
		getReviewScore().setHorizontalAlignment(SwingConstants.CENTER);
		getReviewScore().setFont(new Font("Segoe UI", Font.PLAIN, 30));
		g.gridx = 0;
		g.gridy = 2;
		panel.add(getReviewScore(), g);

		// scroll pane
		setReviewScrollPane(new JScrollPane());
		g.gridx = 1;
		g.gridy = 1;
		g.gridwidth = 3;
		g.gridheight = 3;
		panel.add(getReviewScrollPane(), g);
		
		// text pane
		setTextPane(new JTextPane());
		getTextPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getTextPane().setEditable(false);
		/*
		getTextPane().setText("Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n"
				+ "Write a professional review about your professor here please\n");
				*/
		
		getTextPane().setText("Perpetual motion, the action of a device that, once set in motion,\n"
				+ " would continue in motion forever, with no additional energy required to maintain it.\n"
				+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\n" + 
				"Perpetual motion, although impossible to produce, has fascinated both inventors and the general\n"
				+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\n"
				+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot work\n"
				+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters from\n"
				+ " attempting to break, circumvent, or ignore those laws.");
		
		getReviewScrollPane().setViewportView(getTextPane());
		
		// reviewer label
		setReviewerID(new JLabel("Steven Jobs"));
		getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		panel.add(getReviewerID(), g);
		
		// message button
		setBtnMessageReviewer(new JButton("Message Reviewer"));
		getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 2;
		g.fill = g.HORIZONTAL;
		panel.add(getBtnMessageReviewer(), g);
		

		setPanel(panel);
	
		
	}
	
	
}
