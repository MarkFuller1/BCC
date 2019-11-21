package BNU.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import BNU.data.MessageModel;
import BNU.logic.MessageBoardController;

public class MessageBoardView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(MessageBoardController.class.getName());

	@SuppressWarnings("unused")
	public static void BuildMessageBoardView(JFrame mainFrame, MessageBoardController controller) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true); 
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("User Review page loaded correctly");

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		//User name label
		controller.getModel().setUserName(new JLabel("MessageBoard"));
		controller.getPanel().add(controller.getModel().getUserName()).setBounds(427, 9, 515, 41);
		controller.getPanel().add(controller.getModel().getUserName()).setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		//back button
		controller.getModel().setBtnBack(new JButton("Back"));
		controller.getPanel().add(controller.getModel().getBtnBack()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getBtnBack()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnBack().setActionCommand("MessageBoard:back");
		controller.getModel().getBtnBack().addActionListener(controller);
		//log out button
		controller.getModel().setLog_out(new JButton("Log Out"));
		controller.getPanel().add(controller.getModel().getLog_out()).setBounds(825, 11, 150, 41);
		controller.getPanel().add(controller.getModel().getLog_out()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getLog_out().setActionCommand("MessageBoard:Logout");
		controller.getModel().getLog_out().addActionListener(controller);
		
		//message button
		controller.getModel().setBtnMessage(new JButton("Message User"));
		controller.getPanel().add(controller.getModel().getBtnMessage()).setBounds(85, 257+450+10, 804, 30);
		controller.getPanel().add(controller.getModel().getBtnMessage()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnMessage().setActionCommand("MessageBoard:message");
		controller.getModel().getBtnMessage().addActionListener(controller);
		
		
		//main scroll pane 
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//main scroll pane panel
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.RED));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel().setLayout(new BoxLayout(controller.getModel().getScrollPanePanel(), BoxLayout.Y_AXIS));
		//controller.getModel().getScrollPane().getVerticalScrollBar().setValue(controller.getModel().getScrollPane().getHeight());

		
		for(int i = 0; i < 10; i++) {
			MessageModel rm1 = new MessageModel();
			rm1.createMessageItem();
			if(rm1 == null) {
				LOGGER.info("Review Record not populated correclty.");
			}else {
				rm1.getPanel().setBounds(0,i*200,804,200);
				if(i == 9 || i == 7 || i == 6) {
					rm1.getUserId().setText("Ken Thompson");
					//rm1.setUserId(new JLabel("Reviewer1234"));
				}
				controller.getModel().getScrollPanePanel().add(rm1.getPanel());	
			}

		}

		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel(), null);
		controller.getPanel().add(controller.getModel().getScrollPane()).setBounds(85, 257, 804, 450);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}

