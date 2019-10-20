package com.BNU.pages.login;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.pages.PageController;
import com.BNU.pages.main.MainController;
import com.BNU.windowbuilder.WindowBuilder;

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
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		LoginController.panel = panel;
	}
	
	public LoginView getView() {
		return view;
	}

	public void setView(LoginView view) {
		LoginController.view = view;
	}

	public LoginModel getModel() {
		return model;
	}

	public void setModel(LoginModel model) {
		LoginController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "login:butNavigation"){
			System.out.println("login Button Pressed");
			WindowBuilder.loadPage(new MainController());
		}else {
			System.out.println("Something else happened");
		}
		
	}

}
