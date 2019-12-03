package BNU.logic;



import java.awt.event.ActionEvent;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.Message;
import BNU.data.database.AbstractDB;
import BNU.data.database.DatabaseMock;
import BNU.data.models.MessageBoardModel;
import BNU.logic.service.MessageBoardService;
import BNU.presentation.MessageBoardView;

public class MessageBoardController extends PageController{
	static MessageBoardView view;
	static MessageBoardModel model = new MessageBoardModel();
	static JPanel panel;
	public JFrame mainF;
	public static MessageBoardService mbs;
	
	//static private InputMessage im;
	
	public MessageBoardController(){
		model = new MessageBoardModel();
		panel = new JPanel();
		view = new MessageBoardView();
		db = new DatabaseMock();
		mbs = new MessageBoardService();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		this.mainF = mainFrame;
		try {
			MessageBoardView.BuildMessageBoardView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AbstractDB getDb() {
		return db;
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
			Message mess = new Message(this.getModel().getBar().getText(), this.getModel().getTime(), this.getModel().getReceiver() ,this.getModel().getSender() );
			mbs.messageSend(mess);
			MessageBoardView.BuildMessageBoardView(this.mainF, this);
			System.out.println("Message sent and without mock this should create a live update!");
		}else if(e.getActionCommand() == "MessageBoard:getMessage") {
			System.out.println("MessageBoard:getMessage button pressed");
			JButton j = (JButton) e.getSource();
			this.getModel().setSender(j.getText());
			MessageBoardView.BuildMessageBoardView(this.mainF, this);
			
		}
		
	}

}
