package BNU.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import BNU.data.Review;
import BNU.logic.ReviewController;
import BNU.logic.UserReviewController;

public class ReviewView {
	 JButton butNavigation;
	 JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(ReviewController.class.getName());

	
	
	public static void BuildReviewView(ReviewController controller, String content, String score, String reviewerID) {
		controller.getModel().setScores(Integer.parseInt(score));
		
		FileHandler fileHandler = null; 
		try {
			fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.FINEST);
			LOGGER.info("Review obj loaded correctly");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		// sets the panel
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(new GridBagLayout());
		controller.getPanel().setSize(804,200);
		controller.getPanel().setVisible(true);
		
		// setup for the gridbaglayout
		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(5,5,5,5);
		
		// up button
		controller.getModel().setBtnUp(new JButton("+"));
		controller.getModel().getBtnUp().setForeground(Color.GREEN);
		controller.getModel().getBtnUp().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 1;
		controller.getPanel().add(controller.getModel().getBtnUp(), g);
		controller.getModel().getBtnUp().addActionListener(controller);
		controller.getModel().getBtnUp().setActionCommand("u"+controller.getModel().getCount().toString());
		
		// down button
		controller.getModel().setBtnDown(new JButton("-"));
		controller.getModel().getBtnDown().setForeground(Color.RED);
		controller.getModel().getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 3;
		controller.getPanel().add(controller.getModel().getBtnDown(), g);
		controller.getModel().getBtnDown().addActionListener(controller);
		controller.getModel().getBtnDown().setActionCommand("d"+controller.getModel().getCount().toString());
		
		// score
		controller.getModel().setReviewScore(new JLabel(controller.getModel().getScores().toString()));
		controller.getModel().getReviewScore().setHorizontalAlignment(SwingConstants.CENTER);
		controller.getModel().getReviewScore().setFont(new Font("Segoe UI", Font.PLAIN, 30));
		g.gridx = 0;
		g.gridy = 2;
		controller.getPanel().add(controller.getModel().getReviewScore(), g);

		// scroll pane
		controller.getModel().setReviewScrollPane(new JScrollPane());
		controller.getModel().getReviewScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		g.gridx = 1;
		g.gridy = 1;
		g.gridwidth = 3;
		g.gridheight = 3;
		controller.getPanel().add(controller.getModel().getReviewScrollPane(), g);
		
		// text pane
		controller.getModel().setTextArea(new JTextArea());
		controller.getModel().getTextArea().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		controller.getModel().getTextArea().setColumns(65);
		controller.getModel().getTextArea().setEditable(false);
		controller.getModel().getTextArea().setLineWrap(true);
		controller.getModel().getTextArea().setWrapStyleWord(true);
		controller.getModel().getTextArea().setText(content);
		
		controller.getModel().getReviewScrollPane().setViewportView(controller.getModel().getTextArea());
		
		// reviewer label
		controller.getModel().setReviewerID(new JLabel(reviewerID));
		controller.getModel().getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		controller.getPanel().add(controller.getModel().getReviewerID(), g);
		
		// flag button 
		controller.getModel().setFlag(new JButton("Flag Comment"));
		controller.getModel().getFlag().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		g.gridx = 1;
		g.gridy = 0;
		g.gridwidth = 1;
		g.fill = g.HORIZONTAL;
		controller.getPanel().add(controller.getModel().getFlag(), g);
		controller.getModel().getFlag().addActionListener(controller);
		controller.getModel().getFlag().setActionCommand("f"+controller.getModel().getCount().toString());
		
		
		// message button
		controller.getModel().setBtnMessageReviewer(new JButton("Message Reviewer"));
		controller.getModel().getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 2;
		g.fill = g.HORIZONTAL;
		controller.getPanel().add(controller.getModel().getBtnMessageReviewer(), g);
		controller.getModel().getBtnMessageReviewer().addActionListener(controller);
		controller.getModel().getBtnMessageReviewer().setActionCommand("m"+controller.getModel().getCount().toString());
		
	}
	
}
