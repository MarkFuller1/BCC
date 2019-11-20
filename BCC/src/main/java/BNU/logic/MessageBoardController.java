package BNU.logic;



import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.MessageBoardModel;
import BNU.data.dbWrapper;
import BNU.presentation.MessageBoardView;

public class MessageBoardController extends PageController{
	static MessageBoardView view;
	static MessageBoardModel model = new MessageBoardModel();
	static JPanel panel;
	//static dbWrapper db;
	//static private InputMessage im;
	
	public MessageBoardController(){
		model = new MessageBoardModel();
		panel = new JPanel();
		view = new MessageBoardView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
//		if(db == null) {
//			this.db = db;
//		}
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
			WindowBuilder.loadPage(new UserReviewController());
		
		}else if(e.getActionCommand() == "MessageBoard:Logout") {
			System.out.println("MessageBoard:logout button pressed");
			WindowBuilder.clip.stop();
			WindowBuilder.loadPage(new LoginController());
		}else if(e.getActionCommand() == "MessageBoard:send") {
			System.out.println("MessageBoard:send button pressed");
			//update message and db
		}
	}

}
