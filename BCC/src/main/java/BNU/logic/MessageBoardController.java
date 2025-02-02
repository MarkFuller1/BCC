package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.Message;
import BNU.data.database.AbstractDB;
import BNU.data.models.MessageBoardModel;
import BNU.logic.service.MessageBoardService;
import BNU.presentation.MessageBoardView;
import BNU.singleton.SingletonSession;

/**
 * 
 * @author Kevin
 * 
 * LAZY LOADING GoF Design Pattern
 * 
 * This controller reveals how the message board follows the lazy
 * loading design pattern. Specifically, it follows the lazy 
 * initialization implementation because the program waits to load
 * messages between the user and another user until the user
 * selects who is the other party in the conversation. In contrast,
 * the program could load all the data at once and store it in case
 * the user wants to look at all threads of messages. By lazily 
 * initializing the message board model, however, we improve memory use
 * and processing speed.
 */
public class MessageBoardController extends PageController {
	static MessageBoardView view;
	static MessageBoardModel model = new MessageBoardModel();
	static JPanel panel;
	public JFrame mainF;
	public static MessageBoardService mbs;
	public static Thread checkDbForNewMessages;
	private static final Logger LOGGER = Logger.getLogger(MessageBoardController.class.getName());

	static {

		try {
			LOGGER.addHandler(new FileHandler("log.log"));
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// static private InputMessage im;

	public MessageBoardController() {
		model = new MessageBoardModel();
		panel = new JPanel();
		view = new MessageBoardView();
		mbs = new MessageBoardService();
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		this.mainF = mainFrame;
		try {
			checkDbForNewMessages = new Thread(new Runnable() {
				public void run() {
					try {
						mbs.observer(MessageBoardController.this, SingletonSession.getInstance().getUserName());
					} catch (InterruptedException e) {
						LOGGER.info("Thread Stopped");
					}
				}
			});

			checkDbForNewMessages.start();

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
			
		if (e.getActionCommand() == "MessageBoard:back") {
			MessageBoardController.checkDbForNewMessages.interrupt();
			System.out.println("MessageBoard:back button pressed");
			WindowBuilder.loadPage(new UserReviewController());

		} else if (e.getActionCommand() == "MessageBoard:Logout") {
			MessageBoardController.checkDbForNewMessages.interrupt();
			System.out.println("MessageBoard:logout button pressed");
			WindowBuilder.clip.stop();
			WindowBuilder.loadPage(new LoginController());
		} else if (e.getActionCommand() == "MessageBoard:send") {
			System.out.println("MessageBoard:send button pressed");
			Message mess = new Message(this.getModel().getBar().getText(),
					BigInteger.valueOf(System.currentTimeMillis()),this.getModel().getSender(), this.getModel().getReceiver());
			mbs.messageSend(mess.getText(), this.getModel().getReceiver(), this.getModel().getSender());
			MessageBoardView.BuildMessageBoardView(this.mainF, this);
			System.out.println("Message sent and without mock this should create a live update!");
		} else if (e.getActionCommand() == "MessageBoard:getMessage") {
			System.out.println("MessageBoard:getMessage button pressed");
			JButton j = (JButton) e.getSource();
			this.getModel().setSender(j.getText());
			MessageBoardView.BuildMessageBoardView(this.mainF, this);
			//MessageBoardView.updateMessages(this, this.getModel().getReceiver());
		}

	}

}
