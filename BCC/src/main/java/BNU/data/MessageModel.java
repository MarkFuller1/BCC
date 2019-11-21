package BNU.data;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class MessageModel {
	
	private JButton btnUp;
	private JButton btnDown;
	private JButton log_out;
	private JLabel UserId;
	private JScrollPane MessageScrollPane;
	private JLabel studentMessage;
	private JLabel MessagerID;
	private JButton btnMessageMessageer;
	private JPanel panel;
	private JTextPane textPane;
	
	
	
	public JButton getLog_out() {
		return log_out;
	}
	public void setLog_out(JButton log_out) {
		this.log_out = log_out;
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
	public JLabel getUserId() {
		return UserId;
	}
	public void setUserId(JLabel UserId) {
		this.UserId = UserId;
	}
	public JScrollPane getMessageScrollPane() {
		return MessageScrollPane;
	}
	public void setMessageScrollPane(JScrollPane MessageScrollPane) {
		this.MessageScrollPane = MessageScrollPane;
	}
	public JLabel getStudentMessage() {
		return studentMessage;
	}
	public void setStudentMessage(JLabel studentMessage) {
		this.studentMessage = studentMessage;
	}
	public JLabel getMessagerID() {
		return MessagerID;
	}
	public void setMessagerID(JLabel MessageerID) {
		this.MessagerID = MessageerID;
	}
	public JButton getBtnMessageMessageer() {
		return btnMessageMessageer;
	}
	public void setBtnMessageMessageer(JButton btnMessageMessageer) {
		this.btnMessageMessageer = btnMessageMessageer;
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
	
	
	
	public void createMessageItem() {  //Should take a database object as a parameter and populate this info using a record.
		//MessageModel rm = new MessageModel();
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setSize(604,200);
		panel.setVisible(true);
	
		
		// Message score label
		setUserId(new JLabel("Dennis Ritchie"));
		getUserId().setHorizontalAlignment(SwingConstants.CENTER);
		getUserId().setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panel.add(getUserId());

		// scroll pane
		setMessageScrollPane(new JScrollPane());
		panel.add(getMessageScrollPane());
		
		// text pane
		setTextPane(new JTextPane());
		getTextPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getTextPane().setEditable(false);
		
		getTextPane().setText("Perpetual motion, the action of a device that, once set in motion,\n"
				+ " would continue in motion forever, with no additional energy required to maintain it.\n"
				+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\n" + 
				"Perpetual motion, although impossible to produce, has fascinated both inventors and the general\n"
				+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\n"
				+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot work\n"
				+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters from\n"
				+ " attempting to break, circumvent, or ignore those laws.");
		getMessageScrollPane().setViewportView(getTextPane());

		setPanel(panel);
	
		
	}
	
	
}


