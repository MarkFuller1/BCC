package com.BNU.pages.register;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.register.RegisterModel;

public class RegisterController extends PageController{

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		//MainView.BuildLoginView(mainFrame, this);
		
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
