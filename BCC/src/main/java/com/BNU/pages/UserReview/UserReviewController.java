package com.BNU.pages.UserReview;


import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.pages.main.MainController;
import com.BNU.pages.message_board.MessageBoardController;
import com.BNU.windowbuilder.WindowBuilder;

public class UserReviewController extends PageController{
	static UserReviewView view;
	static UserReviewModel model = new UserReviewModel();
	static JPanel panel;
	static dbWrapper db;
	
	public UserReviewController(){
		model = new UserReviewModel();
		panel = new JPanel();
		view = new UserReviewView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		if(db == null) {
			this.db = db;
		}
		try {
			UserReviewView.BuildUserReviewView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		UserReviewController.panel = panel;
	}
	
	public UserReviewView getView() {
		return view;
	}

	public void setView(UserReviewView view) {
		UserReviewController.view = view;
	}

	public UserReviewModel getModel() {
		return model;
	}

	public void setModel(UserReviewModel model) {
		UserReviewController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "UserReview:messages"){
			System.out.println("UserReview:messages button pressed");
			WindowBuilder.loadPage(new MessageBoardController());
	}
	else if(e.getActionCommand() == "UserReview:back"){
		System.out.println("UserReview:back button pressed");
		WindowBuilder.loadPage(new MainController());
	}
	else if(e.getActionCommand() == "UserReview:logout"){
		System.out.println("UserReview:logout button pressed");
		WindowBuilder.loadPage(new LoginController());
	}
}

}
