package com.BNU.pages.register;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class RegisterModel {
	private JButton but_Register;
	private JLabel lab_Title;
	private JLabel lab_Username;
	private JLabel lab_Password;
	private JList classes_possible;
	private JTextField txt_classes;
	private JTextField txt_username;
	private JTextField txt_password;
	
	
	public JList getClasses_possible() {
		return classes_possible;
	}
	public void setClasses_possible(JList classes_possible) {
		this.classes_possible = classes_possible;
	}
	public JTextField getTxt_classes() {
		return txt_classes;
	}
	public void setTxt_classes(JTextField txt_classes) {
		this.txt_classes = txt_classes;
	}
	
	public JButton getBut_Register() {
		return but_Register;
	}
	public void setBut_Register(JButton but_Submit) {
		this.but_Register = but_Submit;
	}
	public JLabel getLab_Title() {
		return lab_Title;
	}
	public void setLab_Title(JLabel lab_Title) {
		this.lab_Title = lab_Title;
	}
	public JLabel getLab_Username() {
		return lab_Username;
	}
	public void setLab_Username(JLabel lab_Username) {
		this.lab_Username = lab_Username;
	}
	public JLabel getLab_Password() {
		return lab_Password;
	}
	public void setLab_Password(JLabel lab_Password) {
		this.lab_Password = lab_Password;
	}
	public JTextField getTxt_username() {
		return txt_username;
	}
	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}
	public JTextField getTxt_password() {
		return txt_password;
	}
	public void setTxt_password(JTextField txt_password) {
		this.txt_password = txt_password;
	}
	
}
