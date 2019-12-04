package BNU.data.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import BNU.data.Review;
import BNU.logic.AdminController;
import BNU.logic.UserReviewController;

public class ReviewModel2 { 
	
	private JButton btnUp;
	private JButton flag;
	private JButton btnDown;
	private JLabel reviewScore;
	private Integer scores;
	private JScrollPane reviewScrollPane;
	private JLabel studentReview;
	private JLabel reviewerID;
	private JButton btnMessageReviewer;
	private JPanel panel;
	private JTextArea textArea;
	private Integer count;
	private String RID;
	
	
	
	public String getRID() {
		return RID;
	}
	public void setRID(String rID) {
		RID = rID;
	}
	public JButton getFlag() {
		return flag;
	}
	public void setFlag(JButton flag) {
		this.flag = flag;
	}
	public Integer getScores() {
		return scores;
	}
	public void setScores(Integer score) {
		this.scores = score;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
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
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	
public void createUserItem(String content, String score, String professor, String courseName, UserReviewController urc) {  //Should take a database object as a parameter and populate this info using a record.
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		panel.setSize(804,200);
		panel.setVisible(true);
		
		g.insets = new Insets(5,5,5,5);

		// review score label
		setReviewScore(new JLabel(score));
		getReviewScore().setHorizontalAlignment(SwingConstants.CENTER);
		getReviewScore().setFont(new Font("Segoe UI", Font.PLAIN, 30));
		g.gridx = 0;
		g.gridy = 3;
		panel.add(getReviewScore(), g);
		
		// scroll pane
		setReviewScrollPane(new JScrollPane());
		reviewScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		g.gridx = 1;
		g.gridy = 1;
		g.gridwidth = 3;
		g.gridheight = 3;
		panel.add(getReviewScrollPane(), g);
		
		// text pane
		setTextArea(new JTextArea());
		getTextArea().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getTextArea().setEditable(false);
		getTextArea().setText(content);
		
		getTextArea().setColumns(50);
		getTextArea().setRows(5);
		getTextArea().setEditable(true);
		getTextArea().setLineWrap(true);
		getTextArea().setWrapStyleWord(true);
		
		getReviewScrollPane().setViewportView(getTextArea());
		
		// reviewer label
		setReviewerID(new JLabel(courseName));
		getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		panel.add(getReviewerID(), g);
		
		JLabel Professor = new JLabel(professor);
		Professor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 2;
		panel.add(Professor, g);
		
		// submit edits button
		setBtnMessageReviewer(new JButton("Submit Edits"));
		getBtnMessageReviewer().setForeground(Color.BLACK);
		getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.BOLD, 14));
		getBtnMessageReviewer().setPreferredSize(new Dimension(120, 100));
		g.gridx = 4;
		g.gridy = 1;
		g.gridwidth = 1;
		g.gridheight = 3;
		panel.add(getBtnMessageReviewer(), g);
		getBtnMessageReviewer().addActionListener(urc);
		getBtnMessageReviewer().setActionCommand("ed"+this.getCount().toString());
		
		setPanel(panel);
	
		
	}
	

public void createAdminItem(String professor, String courseName, String content, AdminController ac ) {  //Should take a database object as a parameter and populate this info using a record.
	
	panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	GridBagConstraints g = new GridBagConstraints();
	panel.setSize(804,200);
	panel.setVisible(true);
	
	g.insets = new Insets(5,5,5,5);
	
	// up button
	setBtnUp(new JButton("Approve"));
	getBtnUp().setForeground(Color.GREEN);
	getBtnUp().setFont(new Font("Segoe UI", Font.PLAIN, 18));
	g.gridx = 0;
	g.gridy = 1;
	panel.add(getBtnUp(), g);
	getBtnUp().addActionListener(ac);
	getBtnUp().setActionCommand("approve"+getCount().toString());
	
	// down button
	setBtnDown(new JButton("Remove"));
	getBtnDown().setForeground(Color.RED);
	getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
	g.gridx = 0;
	g.gridy = 3;
	panel.add(getBtnDown(), g);
	getBtnDown().addActionListener(ac);
	getBtnDown().setActionCommand("delete"+getCount().toString());


	// scroll pane
	setReviewScrollPane(new JScrollPane());
	reviewScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	g.gridx = 1;
	g.gridy = 1;
	g.gridwidth = 3;
	g.gridheight = 3;
	panel.add(getReviewScrollPane(), g);
	
	// text pane
	setTextArea(new JTextArea());
	getTextArea().setFont(new Font("Segoe UI", Font.PLAIN, 12));
	getTextArea().setEditable(false);
	getTextArea().setText(content);
	
	getTextArea().setColumns(65);
	getTextArea().setRows(3);
	getTextArea().setEditable(false);
	getTextArea().setLineWrap(true);
	getTextArea().setWrapStyleWord(true);
	
	getReviewScrollPane().setViewportView(getTextArea());
	
	// reviewer label
	setReviewerID(new JLabel(courseName));
	getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
	g.gridx = 1;
	g.gridy = 0;
	g.gridwidth = 2;
	g.gridheight = 1;
	panel.add(getReviewerID(), g);
	
	JLabel Professor = new JLabel(professor);
	Professor.setFont(new Font("Segoe UI", Font.BOLD, 14));
	g.gridx = 3;
	g.gridy = 0;
	g.gridwidth = 1;
	g.gridheight = 1;
	panel.add(Professor, g);
	
	setPanel(panel);

	
}
	
}
