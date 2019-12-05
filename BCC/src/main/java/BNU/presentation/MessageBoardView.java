package BNU.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
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
import BNU.data.models.MessageModel;
import BNU.logic.MessageBoardController;
import BNU.singleton.SingletonSession;

public class MessageBoardView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(MessageBoardController.class.getName());

	@SuppressWarnings("unused")
	public static void BuildMessageBoardView(JFrame mainFrame, MessageBoardController controller) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("User Review page loaded correctly");

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);

		// back button
		controller.getModel().setBtnBack(new JButton("Back"));
		controller.getPanel().add(controller.getModel().getBtnBack()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getBtnBack()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnBack().setActionCommand("MessageBoard:back");
		controller.getModel().getBtnBack().addActionListener(controller);

		// log out button
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

		// User name label
		controller.getModel().setUserName(new JLabel(controller.getModel().getSender()));
		controller.getPanel().add(controller.getModel().getUserName()).setBounds(472, 9, 515, 41);
		controller.getPanel().add(controller.getModel().getUserName()).setFont(new Font("Segoe UI", Font.PLAIN, 25));

		// user
		controller.getModel().setUserList(new JScrollPane());
		controller.getModel().getUserList().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// user scroll pane panel
		controller.getModel().getUserList().setViewportBorder(new LineBorder(Color.BLACK));
		controller.getModel().setUser(new JPanel());
		controller.getModel().getUser().setLayout(new BoxLayout(controller.getModel().getUser(), BoxLayout.Y_AXIS));

		controller.getModel().getUserList().setPreferredSize(new Dimension(250, 675));

		controller.getModel().setReceiver(controller.mbs.getReceiver());
		String[] usres = controller.mbs.getAllMessagersToUser(controller.getModel().getReceiver());
		for(String s: usres) {
			System.out.println(s);
		}
		controller.getModel().setUsers(usres);
		if (controller.getModel().getSender() == null) {
			controller.getModel().setSender(controller.getModel().getUsers()[0]);
			System.out.println("it was null!");
		}

		for (int i = 0; i < controller.getModel().getUsers().length; i++) {
			JButton j = new JButton(controller.getModel().getUsers()[i]);
			j.setActionCommand("MessageBoard:getMessage");
			j.addActionListener(controller);
			j.setHorizontalAlignment(SwingConstants.CENTER);
			j.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			JPanel temp = new JPanel();
			temp.setLayout(new FlowLayout());
			temp.setSize(130, 180);
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

		// main scroll pane
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		controller.getModel().getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// main scroll pane panel
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.BLACK));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel()
				.setLayout(new BoxLayout(controller.getModel().getScrollPanePanel(), BoxLayout.Y_AXIS));
		controller.getModel().getScrollPane().setPreferredSize(new Dimension(710, 580));
		GridBagConstraints g1 = new GridBagConstraints();
		g1.insets = new Insets(1, 1, 1, 1);

		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel(), null);
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 4;
		g.gridheight = 5;
		controller.getModel().getBig().add(controller.getModel().getScrollPane(), g);

		updateMessages(controller, controller.getModel().getSender());

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

	public static void updateMessages(MessageBoardController controller, String receiver) {

		controller.getModel().setMessages(
				controller.mbs.getAllMessagesFromTo(SingletonSession.getInstance().getUserName(), receiver));

		for (int i = 0; i < controller.getModel().getMessages().size(); i++) {
			Message m = controller.getModel().getMessages().get(i);
			JPanel itemPanel = new JPanel();
			itemPanel.setLayout(new BorderLayout());
			itemPanel.setSize(200, 100);

			JTextArea jt = new JTextArea();
			jt.setPreferredSize(new Dimension(10, m.getText().length() / 100 * 38));
			jt.setColumns(m.getText().length() < 30 ? m.getText().length() : 30);
			jt.setRows(1);
			jt.setEditable(false);
			jt.setLineWrap(true);
			jt.setWrapStyleWord(true);
			jt.setText(m.getText());
			jt.setForeground(new Color(41, 66, 94));
			jt.setBackground(controller.getPanel().getBackground());
			jt.setBorder(new RoundBorder(20));
			jt.setBackground(new Color(126, 185, 252));

			if (!m.getSender().equals(SingletonSession.getInstance().getUserName())) {
				itemPanel.add(jt, BorderLayout.WEST);
				controller.getModel().getScrollPanePanel().add(itemPanel);
			} else {
				itemPanel.add(jt, BorderLayout.EAST);
				controller.getModel().getScrollPanePanel().add(itemPanel);
			}
		}

	}

}
