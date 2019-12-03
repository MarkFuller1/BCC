package BNU.data.models;


import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import BNU.data.Message;

public class MessageBoardModel {
	
	private JLabel UserName;
	private JButton btnBack;
	private JButton btnMessage;
	private JButton log_out;
	private String sender;

	private JScrollPane scrollPane;
	private JPanel user;
	private JScrollPane userList;
	private JPanel scrollPanePanel;
	private JPanel left;
	private JPanel right;
	private JPanel big;
	private JPanel search;
	private JTextArea bar;

	private ArrayList<Message> messages;
	private String receiver;
	private String [] users;
	
	

	
	
	public JPanel getLeft() {
		return left;
	}

	public void setLeft(JPanel left) {
		this.left = left;
	}

	public JPanel getRight() {
		return right;
	}

	public void setRight(JPanel right) {
		this.right = right;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

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

