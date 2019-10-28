package com.BNU.pages.main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MainModel {
	private JLabel txt_Title;
	private JLabel txt_Slogan;
	private JLabel txt_SearchClass;
	private JLabel txt_SearchProfessor;
	@SuppressWarnings("rawtypes")
	private JComboBox cb_SearchProfessor;
	@SuppressWarnings("rawtypes")
	private JComboBox cb_SearchClass;
	private JLabel txt_Image; 
	private JButton btn_Messages;
	
	public JLabel getTxt_Title() {
		return txt_Title;
	}
	public void setTxt_Title(JLabel txt_Title) {
		this.txt_Title = txt_Title;
	}
	public JLabel getTxt_Slogan() {
		return txt_Slogan;
	}
	public void setTxt_Slogan(JLabel txt_Slogan) {
		this.txt_Slogan = txt_Slogan;
	}
	public JLabel getTxt_SearchClass() {
		return txt_SearchClass;
	}
	public void setTxt_SearchClass(JLabel txt_SearchClass) {
		this.txt_SearchClass = txt_SearchClass;
	}
	public JLabel getTxt_SearchProfessor() {
		return txt_SearchProfessor;
	}
	public void setTxt_SearchProfessor(JLabel txt_SearchProfessor) {
		this.txt_SearchProfessor = txt_SearchProfessor;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCb_SearchProfessor() {
		return cb_SearchProfessor;
	}
	@SuppressWarnings("rawtypes")
	public void setCb_SearchProfessor(JComboBox cb_SearchProfessor) {
		this.cb_SearchProfessor = cb_SearchProfessor;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCb_SearchClass() {
		return cb_SearchClass;
	}
	@SuppressWarnings("rawtypes")
	public void setCb_SearchClass(JComboBox cb_SearchClass) {
		this.cb_SearchClass = cb_SearchClass;
	}
	public JLabel getTxt_Image() {
		return txt_Image;
	}
	public void setTxt_Image(JLabel txt_Image) {
		this.txt_Image = txt_Image;
	}
	public JButton getBtn_Messages() {
		return btn_Messages;
	}
	public void setBtn_Messages(JButton btn_Messages) {
		this.btn_Messages = btn_Messages;
	}
	
	
	
}
