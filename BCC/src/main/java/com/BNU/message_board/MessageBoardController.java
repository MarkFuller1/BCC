package com.BNU.message_board;



import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.windowbuilder.WindowBuilder;

public class MessageBoardController extends PageController{
	static MessageBoardView view;
	static MessageBoardModel model = new MessageBoardModel();
	static JPanel panel;
	static dbWrapper db;
	static private InputMessage im;
	
	public MessageBoardController(){
		model = new MessageBoardModel();
		panel = new JPanel();
		view = new MessageBoardView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		if(db == null) {
			this.db = db;
		}
		try {
			MessageBoardView.BuildMessageBoardView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		MessageBoardController.panel = panel;
	}
	
	public MessageBoardView getView() {
		return view;
	}

	public void setView(MessageBoardView view) {
		MessageBoardController.view = view;
	}

	public MessageBoardModel getModel() {
		return model;
	}

	public void setModel(MessageBoardModel model) {
		MessageBoardController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "MessageBoard:back"){
			System.out.println("MessageBoard:back button pressed");
			WindowBuilder.loadPage(new LoginController());
		
		}else if(e.getActionCommand() == "MessageBoard:message") {
			im = new InputMessage("plug");
		}
	}

}
