package com.BNU.pages.register;

import java.awt.Dimension;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RegisterModel {
	
	private JButton but_Register;
	private JLabel lab_Title;
	private JLabel lab_Username;
	private JLabel lab_Password;
	private JLabel new_info;
	private JLabel classes_possible;
	private JTextField txt_classes;
	private JTextField txt_username;
	private JTextField txt_password;
	private JList classes_taken;
	private JScrollPane menuScrollPane;
	
	public JLabel getNew_info() {
		return new_info;
	}
	public void setNew_info(JLabel new_info) {
		this.new_info = new_info;
	}

	public JScrollPane getMenuScrollPane() {
		return menuScrollPane;
	}
	public void setMenuScrollPane(JList list) {
		this.menuScrollPane = new JScrollPane(list);
		//this.menuScrollPane.menuScrollPane;
	}
	public JList getClasses_taken() {
		return classes_taken;
	}
	public void setClasses_taken(JList classes_taken) {
		this.classes_taken = classes_taken;
		this.classes_taken.setVisibleRowCount(4);
	}
	public JLabel getClasses_possible() {
		return classes_possible;
	}
	public void setClasses_possible(JLabel classes_possible) {
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
