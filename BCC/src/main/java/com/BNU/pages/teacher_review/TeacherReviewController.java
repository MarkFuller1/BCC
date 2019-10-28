package com.BNU.pages.teacher_review;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.windowbuilder.WindowBuilder;

public class TeacherReviewController extends PageController{
	static TeacherReviewView view;
	static TeacherReviewModel model = new TeacherReviewModel();
	static JPanel panel;
	static dbWrapper db;
	
	public TeacherReviewController(){
		model = new TeacherReviewModel();
		panel = new JPanel();
		view = new TeacherReviewView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		if(db == null) {
			this.db = db;
		}
		try {
			TeacherReviewView.BuildTeacherReviewView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		TeacherReviewController.panel = panel;
	}
	
	public TeacherReviewView getView() {
		return view;
	}

	public void setView(TeacherReviewView view) {
		TeacherReviewController.view = view;
	}

	public TeacherReviewModel getModel() {
		return model;
	}

	public void setModel(TeacherReviewModel model) {
		TeacherReviewController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "teacher_review:back"){
			System.out.println("teacher_review:back button pressed");
			WindowBuilder.loadPage(new LoginController());
		
	}
}

}
