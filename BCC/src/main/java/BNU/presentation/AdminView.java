package BNU.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
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
import BNU.logic.AdminController;
import BNU.logic.ReviewController;
import BNU.logic.service.AdminService;
import BNU.logic.service.UserReviewService;


public class AdminView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(AdminController.class.getName());
	static AdminService as;

	@SuppressWarnings("unused")
	public static void BuildAdminView(JFrame mainFrame, AdminController controller) {
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
		LOGGER.info(" Review page loaded correctly");

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		//Admin label
		controller.getModel().setUser(new JLabel("Admin Page"));
		controller.getPanel().add(controller.getModel().getUser()).setBounds(430, 13, 330, 41);
		controller.getPanel().add(controller.getModel().getUser()).setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		//User name label
		controller.getModel().setReviewH(new JLabel("Flagged Comments to Review"));
		controller.getPanel().add(controller.getModel().getReviewH()).setBounds(330, 120, 515, 41);
		controller.getPanel().add(controller.getModel().getReviewH()).setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		//message button
		controller.getModel().setBtnMessage(new JButton("Home Page"));
		controller.getPanel().add(controller.getModel().getBtnMessage()).setBounds(825, 11, 150, 41);
		controller.getPanel().add(controller.getModel().getBtnMessage()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnMessage().setActionCommand("Admin:main");
		controller.getModel().getBtnMessage().addActionListener(controller);
		
		////back button
		controller.getModel().setLog_out(new JButton("Log Out"));
		controller.getPanel().add(controller.getModel().getLog_out()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getLog_out()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getLog_out().setActionCommand("Admin:logout");
		controller.getModel().getLog_out().addActionListener(controller);
		
		//main scroll pane 
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//main scroll pane panel
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.RED));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel().setLayout(new BoxLayout(controller.getModel().getScrollPanePanel(), BoxLayout.Y_AXIS));
		
		String[][] reviews = new AdminService().getAllFlagged();
		controller.getModel().setCounter(reviews.length);
		controller.getModel().setReviews( new ArrayList<ReviewModel2>());
		
		for(int i = 0; i < reviews.length; i++) {
			ReviewModel2 rm1 = new ReviewModel2();
			rm1.setCount(i);
			rm1.setRID(reviews[i][0]);
			// data might not match up
			rm1.createAdminItem(reviews[i][2],reviews[i][3],reviews[i][4], controller);
			if(rm1 == null) {
				LOGGER.info("Review Record not populated correctly.");
			}else {
				rm1.getPanel().setBounds(0,i*200,804,250);
				controller.getModel().getScrollPanePanel().add(rm1.getPanel());	
				controller.getModel().getScrollPanePanel().add(Box.createRigidArea(new Dimension(0,15)));
				controller.getModel().getReviews().add(rm1);
			}

		}
		
		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel(), null);
		controller.getPanel().add(controller.getModel().getScrollPane()).setBounds(40, 180, 900, 550);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
