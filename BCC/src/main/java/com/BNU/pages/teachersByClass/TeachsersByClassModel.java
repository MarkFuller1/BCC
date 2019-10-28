package com.BNU.pages.teachersByClass;

import java.util.ArrayList;

import javax.swing.JLabel;

public class TeachsersByClassModel {
	
	//title
	private JLabel txt_Title;
	
	//
	private JLabel txt_TeacherTitle;
	private JLabel txt_RatingTitle;
	private JLabel txt_ReviewsTitle;
	private ArrayList<TeacherListEntry> entries;
	private ArrayList<String> professors;
	
	public ArrayList<String> getProfessors() {
		return professors;
	}
	public void setProfessors(ArrayList<String> professors) {
		this.professors = professors;
	}
	public JLabel getTxt_Title() {
		return txt_Title;
	}
	public void setTxt_Title(JLabel txt_Title) {
		this.txt_Title = txt_Title;
	}
	public JLabel getTxt_TeacherTitle() {
		return txt_TeacherTitle;
	}
	public void setTxt_TeacherTitle(JLabel txt_TeacherTitle) {
		this.txt_TeacherTitle = txt_TeacherTitle;
	}
	public JLabel getTxt_RatingTitle() {
		return txt_RatingTitle;
	}
	public void setTxt_RatingTitle(JLabel txt_RatingTitle) {
		this.txt_RatingTitle = txt_RatingTitle;
	}
	public JLabel getTxt_ReviewsTitle() {
		return txt_ReviewsTitle;
	}
	public void setTxt_ReviewsTitle(JLabel txt_ReviewsTitle) {
		this.txt_ReviewsTitle = txt_ReviewsTitle;
	}	
	public ArrayList<TeacherListEntry> getEntries() {
		return entries;
	}
	public void setEntries(ArrayList<TeacherListEntry> entries) {
		this.entries = entries;
	}
	public void addEntry(TeacherListEntry entry) {
		entries.add(entry);
	}
}
