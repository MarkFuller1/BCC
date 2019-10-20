package com.BNU.pages.main;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.pages.main.MainController;
import com.BNU.windowbuilder.WindowBuilder;

public class MainController extends PageController{
	static MainView view;
	static MainModel model = new MainModel();
	static JPanel panel;
	
	public MainController(){
		model = new MainModel();
		panel = new JPanel();
		view = new MainView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		MainView.BuildLoginView(mainFrame, this);
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		MainController.panel = panel;
	}
	
	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		MainController.view = view;
	}

	public MainModel getModel() {
		return model;
	}

	public void setModel(MainModel model) {
		MainController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "main:butNavigation"){
			System.out.println("main Button Pressed");
			WindowBuilder.loadPage(new LoginController());
		}else {
			System.out.println("Something else happened");
		}
		
	}

}
