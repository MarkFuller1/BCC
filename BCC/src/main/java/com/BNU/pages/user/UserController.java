package com.BNU.pages.user;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.pages.register.RegisterController;
import com.BNU.pages.register.RegisterModel;
import com.BNU.pages.register.RegisterView;
import com.BNU.windowbuilder.WindowBuilder;


public class UserController extends PageController {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		// TODO Auto-generated method stub
		
	}
	/*
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

	static UserView view;
	static UserModel model = new UserModel();
	static JPanel panel;
	static dbWrapper db;
	
	
	public UserController(){
		model = new UserModel();
		panel = new JPanel();
		view = new UserView();
		db = new DatabaseMock();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		if(e.getActionCommand() == "register:createAccount"){
			LOGGER.setLevel(Level.FINEST);
			LOGGER.info("Account Registered");
			WindowBuilder.loadPage(new LoginController());
		}
	}
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		if(db == null) {
			this.db = db;
		}
		try {
			//UserView.BuildUserView(mainFrame, this);
			LOGGER.setLevel(Level.FINEST);
			LOGGER.info("Building View");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static UserView getView() {
		return view;
	}
	public static void setView(UserView view) {
		UserController.view = view;
	}
	public static UserModel getModel() {
		return model;
	}
	public static void setModel(UserModel model) {
		UserController.model = model;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		UserController.panel = panel;
	}
	public static dbWrapper getDb() {
		return db;
	}
	public static void setDb(dbWrapper db) {
		UserController.db = db;
	}
	
	*/
}
