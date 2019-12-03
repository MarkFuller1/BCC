package BNU.data.models;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SetReviewModel {
	
	private JTextField teachingR;
	private JTextField helpfulnessR;
	private JTextField workloadR;
	private JTextArea descriptionR;
	private JLabel teaching;
	private JLabel description;
	private JLabel helpfulness;
	private JLabel workload;
	private JLabel classL;
	private JLabel teacher;
	private JButton submit;
	private JButton back;
	
	
	public JTextField getTeachingR() {
		return teachingR;
	}
	public void setTeachingR(JTextField teachingR) {
		this.teachingR = teachingR;
	}
	public JTextField getHelpfulnessR() {
		return helpfulnessR;
	}
	public void setHelpfulnessR(JTextField helpfulnessR) {
		this.helpfulnessR = helpfulnessR;
	}
	public JTextField getWorkloadR() {
		return workloadR;
	}
	public void setWorkloadR(JTextField workloadR) {
		this.workloadR = workloadR;
	}
	public JTextArea getDescriptionR() {
		return descriptionR;
	}
	public void setDescriptionR(JTextArea descriptionR) {
		this.descriptionR = descriptionR;
	}
	public JLabel getTeaching() {
		return teaching;
	}
	public void setTeaching(JLabel teaching) {
		this.teaching = teaching;
	}
	public JLabel getDescription() {
		return description;
	}
	public void setDescription(JLabel description) {
		this.description = description;
	}
	public JLabel getHelpfulness() {
		return helpfulness;
	}
	public void setHelpfulness(JLabel helpfulness) {
		this.helpfulness = helpfulness;
	}
	public JLabel getWorkload() {
		return workload;
	}
	public void setWorkload(JLabel workload) {
		this.workload = workload;
	}
	public JLabel getClassL() {
		return classL;
	}
	public void setClassL(JLabel classL) {
		this.classL = classL;
	}
	public JLabel getTeacher() {
		return teacher;
	}
	public void setTeacher(JLabel teacher) {
		this.teacher = teacher;
	}
	public JButton getSubmit() {
		return submit;
	}
	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		this.back = back;
	}
	
	
	
}
