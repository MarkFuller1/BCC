package com.BNU.pages;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginController extends PageController{
	static LoginView view;
	static LoginModel model = new LoginModel();
	static JPanel panel;
	
	public LoginController(){
		model = new LoginModel();
		panel = new JPanel();
		view = new LoginView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		
		LoginView.BuildLoginView(mainFrame, this);
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		LoginController.panel = panel;
	}
	
	public static LoginView getView() {
		return view;
	}

	public static void setView(LoginView view) {
		LoginController.view = view;
	}

	public static LoginModel getModel() {
		return model;
	}

	public static void setModel(LoginModel model) {
		LoginController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contentEquals("login:butNavigation")){
			System.out.println("Login Button Pressed");
		}else {
			System.out.println("Something else happened");
		}
		
	}

}
