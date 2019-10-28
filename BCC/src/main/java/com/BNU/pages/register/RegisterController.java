package com.BNU.pages.register;

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
import com.BNU.pages.login.LoginView;
import com.BNU.pages.register.RegisterModel;
import com.BNU.windowbuilder.WindowBuilder;

public class RegisterController extends PageController {
	
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

	static RegisterView view;
	static RegisterModel model = new RegisterModel();
	static JPanel panel;
	static dbWrapper db;
	
	
	public RegisterController(){
		model = new RegisterModel();
		panel = new JPanel();
		view = new RegisterView();
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
			RegisterView.BuildRegisterView(mainFrame, this);
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
	public static RegisterView getView() {
		return view;
	}
	public static void setView(RegisterView view) {
		RegisterController.view = view;
	}
	public static RegisterModel getModel() {
		return model;
	}
	public static void setModel(RegisterModel model) {
		RegisterController.model = model;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		RegisterController.panel = panel;
	}
	public static dbWrapper getDb() {
		return db;
	}
	public static void setDb(dbWrapper db) {
		RegisterController.db = db;
	}

}
