package BNU.data.models;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TeachersByClassModel {
	
	//title
	private JLabel txt_Title;
	
	//Sub titles
	private JLabel lab_Teachers;
	private JLabel lab_Ratings;
	private JLabel lab_NumOfReviews;
	
	//Scroll panel window
	private JScrollPane scrollPane;
	private JPanel scrollPanePanel;
	private List<JComponent> classes;
	private JPanel TeacherP;
	
	//top pane extras
	private JButton back;
	private JTextField txt_Email;
	
	
	
	public JPanel getTeacherP() {
		return TeacherP;
	}
	public void setTeacherP(JPanel teacherP) {
		TeacherP = teacherP;
	}
	public JLabel getTxt_Title() {
		return txt_Title;
	}
	public void setTxt_Title(JLabel txt_Title) {
		this.txt_Title = txt_Title;
	}
	public JLabel getLab_Teachers() {
		return lab_Teachers;
	}
	public void setLab_Teachers(JLabel lab_Teachers) {
		this.lab_Teachers = lab_Teachers;
	}
	public JLabel getLab_Ratings() {
		return lab_Ratings;
	}
	public void setLab_Ratings(JLabel lab_Ratings) {
		this.lab_Ratings = lab_Ratings;
	}
	public JLabel getLab_NumOfReviews() {
		return lab_NumOfReviews;
	}
	public void setLab_NumOfReviews(JLabel lab_NumOfReviews) {
		this.lab_NumOfReviews = lab_NumOfReviews;
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
	public void setScrollPanePanel(JPanel scrollPanel) {
		this.scrollPanePanel = scrollPanel;
	}
	public List<JComponent> getClasses() {
		return classes;
	}
	public void setClasses(List<JComponent> list) {
		this.classes = list;
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		this.back = back;
	}
	public JTextField getTxt_Email() {
		return txt_Email;
	}
	public void setTxt_Email(JTextField txt_Email) {
		this.txt_Email = txt_Email;
	}
	
	
}
