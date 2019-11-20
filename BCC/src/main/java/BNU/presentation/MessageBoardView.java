package BNU.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BNU.data.Message;
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
		
		// set message panel
		controller.getModel().setBig(new JPanel());
		controller.getModel().getBig().setBounds(5, 60, 970, 700);
		controller.getModel().getBig().setBorder(new LineBorder(Color.BLACK));
		controller.getPanel().add(controller.getModel().getBig());
		controller.getModel().getBig().setLayout(new GridBagLayout());
		// setup for the gridbaglayout
		GridBagConstraints g = new GridBagConstraints();
		

		//user 
		controller.getModel().setUserList(new JScrollPane());
		controller.getModel().getUserList().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//user scroll pane panel
		controller.getModel().getUserList().setViewportBorder(new LineBorder(Color.RED));
		controller.getModel().setUser(new JPanel());
		controller.getModel().getUser().setLayout(new BoxLayout(controller.getModel().getUser(), BoxLayout.Y_AXIS));
		
		controller.getModel().getUserList().setPreferredSize(new Dimension(250, 675));
		
		
		controller.getModel().setReceiver(controller.getDb().getReceiver());
		controller.getModel().setUsers(controller.getDb().getAllUserMessagers(controller.getModel().getReceiver()));
		controller.getModel().setSender(controller.getModel().getUsers()[0]);
		
		for(int i = 0; i < controller.getModel().getUsers().length; i++) {
			JButton j = new JButton(controller.getModel().getUsers()[i]);
			j.setActionCommand("MessageBoard:getMessage");
			j.addActionListener(controller);
			j.setHorizontalAlignment(SwingConstants.CENTER);
			j.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			JPanel temp = new JPanel();
			temp.setLayout(new FlowLayout());
			temp.setSize(130,180);
			temp.setBorder(new LineBorder(Color.BLACK));
			temp.add(j);
			controller.getModel().getUser().add(temp);
		}
		
		controller.getModel().getUserList().getViewport().add(controller.getModel().getUser(), null);
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 6;
		controller.getModel().getBig().add(controller.getModel().getUserList(), g);
		
		//main scroll pane 
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//main scroll pane panel
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.RED));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel().setLayout(new GridBagLayout());
		GridBagConstraints g1 = new GridBagConstraints();
		g1.insets = new Insets(1,1,1,1);
		
		
		
		//make the left for the sender
		controller.getModel().setLeft(new JPanel());
		controller.getModel().getLeft().setLayout(new BoxLayout(controller.getModel().getLeft(), BoxLayout.Y_AXIS));
		controller.getModel().getLeft().setPreferredSize(new Dimension(335, 560));
		g1.gridx = 0;
		g1.gridy = 0;
		controller.getModel().getScrollPanePanel().add(controller.getModel().getLeft(), g1);
		
		//make right for the receiver
		controller.getModel().setRight(new JPanel());
		controller.getModel().getRight().setLayout(new BoxLayout(controller.getModel().getRight(), BoxLayout.Y_AXIS));
		controller.getModel().getRight().setPreferredSize(new Dimension(335, 560));
		g1.gridx = 1;
		g1.gridy = 0;
		controller.getModel().getScrollPanePanel().add(controller.getModel().getRight(), g1);
		
		
		controller.getModel().setMessages(controller.getDb().getAllMessages(controller.getModel().getSender(), controller.getModel().getReceiver()));
	
		
		
		
		
		for(int i = 0; i < controller.getModel().getMessages().size(); i++) {
			Message m = controller.getModel().getMessages().get(i);
			JPanel pan = new JPanel(), fake = new JPanel();
			fake.setSize(330,150);
			pan.setSize(330,150);
			pan.setLayout(new FlowLayout());
			JTextPane j = new JTextPane();
			j.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			j.setText(m.getText());
			JLabel l = new JLabel(m.getSender());
			pan.add(l);
			pan.add(j);
			
			if(m.getSender() == controller.getModel().getSender()) {
					controller.getModel().getRight().add(fake);
					controller.getModel().getLeft().add(pan);
			}
			else {
				controller.getModel().getRight().add(pan);
				controller.getModel().getLeft().add(fake);
			}

		}

		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel(), null);
		controller.getModel().getScrollPane().setPreferredSize(new Dimension(710, 580));
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 4;
		g.gridheight = 5;
		controller.getModel().getBig().add(controller.getModel().getScrollPane(), g);
		
		// implement message bar
		controller.getModel().setSearch(new JPanel());
		controller.getModel().getSearch().setPreferredSize(new Dimension(700, 90));
		controller.getModel().getSearch().setBorder(new LineBorder(Color.BLACK));
		controller.getModel().getSearch().setLayout(new GridBagLayout());
		// setup for the gridbaglayout
		GridBagConstraints g2 = new GridBagConstraints();
		
		
		
		controller.getModel().setBtnMessage(new JButton("Send"));
		controller.getPanel().add(controller.getModel().getBtnMessage()).setPreferredSize(new Dimension(100, 111));
		controller.getPanel().add(controller.getModel().getBtnMessage()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnMessage().setActionCommand("MessageBoard:send");
		controller.getModel().getBtnMessage().addActionListener(controller);
		g2.gridx = 0;
		g2.gridy = 0;
		g2.gridwidth = 1;
		g2.gridheight = 4;
		controller.getModel().getSearch().add(controller.getModel().getBtnMessage(), g2);
		
		controller.getModel().setBar(new JTextArea());
		controller.getModel().getBar().setBounds(200, 300, 600, 190);
		controller.getModel().getBar().setLineWrap(true);
		controller.getModel().getBar().setRows(5);
		g2.gridx = 1;
		g2.gridy = 0;
		g2.gridwidth = 6;
		g2.gridheight = 4;
		controller.getModel().getSearch().add(controller.getModel().getBar(), g2);
		
		
		g.gridx = 1;
		g.gridy = 5;
		g.gridwidth = 4;
		g.gridheight = 1;
		controller.getModel().getBig().add(controller.getModel().getSearch(), g);
		
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}


