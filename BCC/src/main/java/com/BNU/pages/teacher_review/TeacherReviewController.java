package com.BNU.pages.teacher_review;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.pages.main.MainController;
import com.BNU.windowbuilder.WindowBuilder;

public class TeacherReviewController extends PageController{
	static TeacherReviewView view;
	static TeacherReviewModel model = new TeacherReviewModel();
	static JPanel panel;
	static dbWrapper db;
	String teacherName;
	String className;
	
	public TeacherReviewController(String teacherName, String className){
		model = new TeacherReviewModel();
		panel = new JPanel();
		view = new TeacherReviewView();
		this.teacherName = teacherName;
		this.className = className;
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
	
	public static dbWrapper getDb() {
		return db;
	}

	public static void setDb(dbWrapper db) {
		TeacherReviewController.db = db;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
			WindowBuilder.loadPage(new MainController());
		
	}
}

}
