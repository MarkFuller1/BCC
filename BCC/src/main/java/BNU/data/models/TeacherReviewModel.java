package BNU.data.models;



import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import BNU.data.Review;
import BNU.logic.ReviewController;

public class TeacherReviewModel {
	private JLabel professor;
	private JLabel professorName;
	private JLabel lblClass;
	private JLabel lblClassName;
	private JLabel score;
	private JLabel helpfulness;
	private JButton btnBack;
	private JButton addReview;
	private JLabel teachingAbility;
	private JLabel workload;
	private JLabel scoreScore;
	private JLabel helpfulnessScore;
	private JLabel teachingAbilityScore;
	private JLabel workloadScore;
	private JScrollPane scrollPane;
	private JPanel scrollPanePanel;
	private ArrayList<Review> reviews;
	private ArrayList<ReviewController> RC;
	
	public ArrayList<ReviewController> getRC() {
		return RC;
	}

	public void setRC(ArrayList<ReviewController> rC) {
		RC = rC;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public JButton getAddReview() {
		return addReview;
	}

	public void setAddReview(JButton addReview) {
		this.addReview = addReview;
	}

	public JLabel getProfessor() {
		return professor;
	}

	public void setProfessor(JLabel professor) {
		this.professor = professor;
	}

	public JLabel getProfessorName() {
		return professorName;
	}

	public void setProfessorName(JLabel professorName) {
		this.professorName = professorName;
	}

	public JLabel getLblClass() {
		return lblClass;
	}

	public void setLblClass(JLabel lblClass) {
		this.lblClass = lblClass;
	}

	public JLabel getLblClassName() {
		return lblClassName;
	}

	public void setLblClassName(JLabel lblClassName) {
		this.lblClassName = lblClassName;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public JLabel getHelpfulness() {
		return helpfulness;
	}

	public void setHelpfulness(JLabel helpfulness) {
		this.helpfulness = helpfulness;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JLabel getTeachingAbility() {
		return teachingAbility;
	}

	public void setTeachingAbility(JLabel teachingAbility) {
		this.teachingAbility = teachingAbility;
	}

	public JLabel getWorkload() {
		return workload;
	}

	public void setWorkload(JLabel workload) {
		this.workload = workload;
	}

	public JLabel getScoreScore() {
		return scoreScore;
	}

	public void setScoreScore(JLabel scoreScore) {
		this.scoreScore = scoreScore;
	}

	public JLabel getHelpfulnessScore() {
		return helpfulnessScore;
	}

	public void setHelpfulnessScore(JLabel helpfulnessScore) {
		this.helpfulnessScore = helpfulnessScore;
	}

	public JLabel getTeachingAbilityScore() {
		return teachingAbilityScore;
	}

	public void setTeachingAbilityScore(JLabel teachingAbilityScore) {
		this.teachingAbilityScore = teachingAbilityScore;
	}

	public JLabel getWorkloadScore() {
		return workloadScore;
	}

	public void setWorkloadScore(JLabel workloadScore) {
		this.workloadScore = workloadScore;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getScrollPanePanel() {
		return scrollPanePanel;
	}

	public void setScrollPanePanel(JPanel scrollPanePanel) {
		this.scrollPanePanel = scrollPanePanel;
	}

	
}
