package BNU.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import BNU.data.models.ReviewModel2;
import BNU.logic.UserReviewController;
import BNU.logic.service.UserReviewService;
import BNU.singleton.SingletonSession;


public class UserReviewView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(UserReviewController.class.getName());
	static UserReviewService urs;

	@SuppressWarnings("unused")
	public static void BuildUserReviewView(JFrame mainFrame, UserReviewController controller) {
		urs = new UserReviewService();
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true); 
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.FINEST);
			LOGGER.info("User Review page loaded correctly");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Couldn't get lock for BCC.log");
		}
		

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		//User label
		controller.getModel().setUser(new JLabel("User:"));
		controller.getPanel().add(controller.getModel().getUser()).setBounds(390, 13, 130, 41);
		controller.getPanel().add(controller.getModel().getUser()).setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		//User name label
		controller.getModel().setUserName(new JLabel(SingletonSession.getInstance().getUserName().toString()));
		controller.getPanel().add(controller.getModel().getUserName()).setBounds(470, 13, 515, 41);
		controller.getPanel().add(controller.getModel().getUserName()).setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		//User name label
		controller.getModel().setReviewH(new JLabel("Review History"));
		controller.getPanel().add(controller.getModel().getReviewH()).setBounds(430, 120, 515, 41);
		controller.getPanel().add(controller.getModel().getReviewH()).setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		//back button
		controller.getModel().setBtnBack(new JButton("Back"));
		controller.getPanel().add(controller.getModel().getBtnBack()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getBtnBack()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnBack().setActionCommand("UserReview:back");
		controller.getModel().getBtnBack().addActionListener(controller);
		
		//back button
		controller.getModel().setDelete(new JButton("Delete Account"));
		controller.getPanel().add(controller.getModel().getDelete()).setBounds(125, 11, 190, 41);
		controller.getPanel().add(controller.getModel().getDelete()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getDelete().setActionCommand("UserReview:da");
		controller.getModel().getDelete().addActionListener(controller);
		
		//message button
		controller.getModel().setBtnMessage(new JButton("Messages"));
		controller.getPanel().add(controller.getModel().getBtnMessage()).setBounds(825, 11, 150, 41);
		controller.getPanel().add(controller.getModel().getBtnMessage()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnMessage().setActionCommand("UserReview:messages");
		controller.getModel().getBtnMessage().addActionListener(controller);
		
		////back button
		controller.getModel().setLog_out(new JButton("Log Out"));
		controller.getPanel().add(controller.getModel().getLog_out()).setBounds(670, 11, 150, 41);
		controller.getPanel().add(controller.getModel().getLog_out()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getLog_out().setActionCommand("UserReview:logout");
		controller.getModel().getLog_out().addActionListener(controller);
		
		
		
		//main scroll pane 
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//main scroll pane panel
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.BLUE));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel().setLayout(new BoxLayout(controller.getModel().getScrollPanePanel(), BoxLayout.Y_AXIS));
		
		//gets reviews
		String[][] reviews = urs.getReviewsForUser(SingletonSession.getInstance().getUserName()); // TODO: this needs to change
		controller.getModel().setCounter(reviews.length);
		for(int i = 0; i < reviews.length; i++) {
			ReviewModel2 rm2 = new ReviewModel2();
			rm2.setCount(i);
			
			if(rm2 == null) {
				LOGGER.info("Review Record not populated correctly.");
			}else {
				rm2.createUserItem(reviews[i][0],reviews[i][1],reviews[i][2], reviews[i][3], controller);
				rm2.getPanel().setBounds(0,i*200,804,250);
				controller.getModel().getScrollPanePanel().add(rm2.getPanel());	
				controller.getModel().getScrollPanePanel().add(Box.createRigidArea(new Dimension(0,15)));
			}

		}

		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel(), null);
		controller.getPanel().add(controller.getModel().getScrollPane()).setBounds(40, 180, 900, 550);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
