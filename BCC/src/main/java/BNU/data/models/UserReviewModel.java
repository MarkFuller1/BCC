package BNU.data.models;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class UserReviewModel {
	private JLabel User;
	private JLabel reviewH;
	private JLabel UserName;
	private JLabel lblClass;
	private JLabel lblClassName;
	private JLabel score;
	private JLabel helpfulness;
	private JButton btnBack;
	private JButton btnMessage;
	private JButton log_out;
	private JScrollPane scrollPane;
	private JPanel scrollPanePanel;

		
	
	
	public JLabel getReviewH() {
		return reviewH;
	}

	public void setReviewH(JLabel reviewH) {
		this.reviewH = reviewH;
	}

	public JButton getLog_out() {
		return log_out;
	}

	public void setLog_out(JButton log_out) {
		this.log_out = log_out;
	}

	public JLabel getUser() {
		return User;
	}

	public void setUser(JLabel User) {
		this.User = User;
	}

	public JLabel getUserName() {
		return UserName;
	}

	public void setUserName(JLabel UserName) {
		this.UserName = UserName;
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
	public JButton getBtnMessage() {
		return btnMessage;
	}

	public void setBtnMessage(JButton btnMessage) {
		this.btnMessage = btnMessage;
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
