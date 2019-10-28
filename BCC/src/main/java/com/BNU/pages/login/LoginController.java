package com.BNU.pages.login;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.message_board.MessageBoardController;
import com.BNU.pages.PageController;
import com.BNU.pages.main.MainController;
import com.BNU.pages.register.RegisterController;
import com.BNU.windowbuilder.WindowBuilder;

public class LoginController extends PageController{
	static LoginView view;
	static LoginModel model = new LoginModel();
	static JPanel panel;
	static dbWrapper db;
	
	public LoginController(){
		model = new LoginModel();
		panel = new JPanel();
		view = new LoginView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		if(db == null) {
			this.db = db;
		}
		try {
			LoginView.BuildLoginView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		if(e.getActionCommand() == "login:createAccount"){
			System.out.println("login:createAccount Button Pressed");
			WindowBuilder.loadPage(new RegisterController());
		}else if(e.getActionCommand() == "login:Authorize"){
			System.out.println("login:Authorize Button Pressed");
			//WindowBuilder.loadPage(new MainController());
			WindowBuilder.loadPage(new MessageBoardController());
		}
		
	}

}
