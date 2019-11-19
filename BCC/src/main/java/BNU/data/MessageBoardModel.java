package BNU.data;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MessageBoardModel {
	
	private JLabel UserName;
	private JButton btnBack;
	private JButton btnMessage;
	private JButton log_out;


	private JLabel teachingAbility;
	private JLabel workload;
	private JLabel scoreScore;


	private JLabel helpfulnessScore;
	private JLabel teachingAbilityScore;
	private JLabel workloadScore;
	private JScrollPane scrollPane;
	private JPanel user;
	private JScrollPane userList;
	private JPanel scrollPanePanel;
	private JPanel big;
	private JPanel search;
	private JTextArea bar;
	
	
	
	

	
	
	public JPanel getSearch() {
		return search;
	}

	public void setSearch(JPanel search) {
		this.search = search;
	}

	public JTextArea getBar() {
		return bar;
	}

	public void setBar(JTextArea bar) {
		this.bar = bar;
	}

	public JPanel getUser() {
		return user;
	}

	public void setUser(JPanel user) {
		this.user = user;
	}

	public JPanel getBig() {
		return big;
	}

	public void setBig(JPanel big) {
		this.big = big;
	}

	public JScrollPane getUserList() {
		return userList;
	}

	public void setUserList(JScrollPane userList) {
		this.userList = userList;
	}

	public JButton getLog_out() {
		return log_out;
	}

	
	public void setLog_out(JButton log_out) {
		this.log_out = log_out;
	}

	public JLabel getUserName() {
		return UserName;
	}

	public void setUserName(JLabel UserName) {
		this.UserName = UserName;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	public JButton getBtnMessage() {
		return btnMessage;
	}

	public void setBtnMessage(JButton btnMessage) {
		this.btnMessage = btnMessage;
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

