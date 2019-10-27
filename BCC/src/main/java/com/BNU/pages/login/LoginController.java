package com.BNU.pages.login;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.main.MainController;
import com.BNU.windowbuilder.WindowBuilder;

public class LoginController extends PageController{
	static LoginView view;
	static LoginModel model = new LoginModel();
	static JPanel panel;
	static dbWrapper db;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	public LoginController(){
		model = new LoginModel();
		panel = new JPanel();
		view = new LoginView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper dbW) throws SecurityException, IOException {
		if(db == null) {
			db = dbW;
		}
		FileHandler fileHandler = new FileHandler("BCC.log", true);
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.INFO);
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
		if(e.getActionCommand() == "login:createAccount"){
			LOGGER.info("login:createAccount Button Pressed");
			try {
				WindowBuilder.loadPage(new MainController());
			} catch (Exception e1) {
				LOGGER.severe("Failed to load login:createAccount");
			}
		}else if(e.getActionCommand() == "login:Authorize"){
			LOGGER.info("login:Authorize Button Pressed");
			try {
				WindowBuilder.loadPage(new MainController());
			} catch (Exception e1) {
				LOGGER.severe("Failed to load login:Authorize");
			}
		}
	}
}
