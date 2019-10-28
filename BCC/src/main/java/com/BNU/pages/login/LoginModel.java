package com.BNU.pages.login;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginModel {
	private JButton but_Submit;
	private JLabel lab_Title;
	private JLabel lab_Username;
	private JLabel lab_Password;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JButton but_Create;
	
	public JButton getBut_Submit() {
		return but_Submit;
	}
	public void setBut_Submit(JButton but_Submit) {
		this.but_Submit = but_Submit;
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
	public JPasswordField getTxt_password() {
		return txt_password;
	}
	public void setTxt_password(JPasswordField txt_password) {
		this.txt_password = txt_password;
	}
	public JButton getBut_Create() {
		return but_Create;
	}
	public void setBut_Create(JButton but_Create) {
		this.but_Create = but_Create;
	}
	
}
