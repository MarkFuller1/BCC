package com.BNU.pages.teachersByClass;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TeachsersByClassModel {
	
	//title
	private JLabel txt_Title;
	
	//Sub titles
	private JLabel lab_TaughtTitle;
	private JLabel lab_RatingTitle;
	private JLabel lab_NumOfReviews;
	
	//Scroll panel window
	private JScrollPane scrollPane;
	private List<JPanel> classes;
	
	//top pane extras
	private JButton back;
	private JTextField txt_Email;
}
