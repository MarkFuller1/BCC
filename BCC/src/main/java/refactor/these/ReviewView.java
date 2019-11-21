package refactor.these;

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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import BNU.logic.UserReviewController;

public class ReviewView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(ReviewController.class.getName());

	@SuppressWarnings("unused")
	public static void BuildReviewView(ReviewController controller) {
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
		LOGGER.info("Review obj loaded correctly");
		
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
		controller.getModel().getBtnUp().setActionCommand("Review:upvote");
		

		
		// down button
		controller.getModel().setBtnDown(new JButton("-"));
		controller.getModel().getBtnDown().setForeground(Color.RED);
		controller.getModel().getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 3;
		controller.getPanel().add(controller.getModel().getBtnDown(), g);
		controller.getModel().getBtnDown().addActionListener(controller);
		controller.getModel().getBtnDown().setActionCommand("Review:downvote");
		

		// review score label
		//String scr = getScoreForAReview(controller.getModel().get)
		controller.getModel().setReviewScore(new JLabel("4"));
		
		
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
		controller.getModel().setTextPane(new JTextPane());
		controller.getModel().getTextPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		controller.getModel().getTextPane().setEditable(false);
		
		
		controller.getModel().getTextPane().setText("Perpetual motion, the action of a device that, once set in motion,\n"
				+ " would continue in motion forever, with no additional energy required to maintain it.\n"
				+ " Such devices are impossible on grounds stated by the first and second laws of thermodynamics.\n" + 
				"Perpetual motion, although impossible to produce, has fascinated both inventors and the general\n"
				+ " public for hundreds of years. The enormous appeal of perpetual motion resides in the promise of a\n"
				+ " virtually free and limitless source of power. The fact that perpetual-motion machines cannot work\n"
				+ " because they violate the laws of thermodynamics has not discouraged inventors and hucksters from\n"
				+ " attempting to break, circumvent, or ignore those laws.");
		
		controller.getModel().getReviewScrollPane().setViewportView(controller.getModel().getTextPane());
		
		// reviewer label
		controller.getModel().setReviewerID(new JLabel("Steven Jobs"));
		controller.getModel().getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		controller.getPanel().add(controller.getModel().getReviewerID(), g);
		
		// message button
		controller.getModel().setBtnMessageReviewer(new JButton("Message Reviewer"));
		controller.getModel().getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 2;
		g.fill = g.HORIZONTAL;
		controller.getPanel().add(controller.getModel().getBtnMessageReviewer(), g);
		controller.getModel().getBtnMessageReviewer().addActionListener(controller);
		controller.getModel().getBtnMessageReviewer().setActionCommand("Review:message");
		
	}
	
	public static void BuildReviewView(ReviewController controller, String content, String score, String reviewerID) {
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
		LOGGER.info("Review obj loaded correctly");
		
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
		controller.getModel().getBtnUp().setActionCommand("Review:upvote");
		

		
		// down button
		controller.getModel().setBtnDown(new JButton("-"));
		controller.getModel().getBtnDown().setForeground(Color.RED);
		controller.getModel().getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		g.gridx = 0;
		g.gridy = 3;
		controller.getPanel().add(controller.getModel().getBtnDown(), g);
		controller.getModel().getBtnDown().addActionListener(controller);
		controller.getModel().getBtnDown().setActionCommand("Review:downvote");
		

		// review score label
		controller.getModel().setReviewScore(new JLabel(score));
		
		
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
		controller.getModel().setTextPane(new JTextPane());
		controller.getModel().getTextPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		controller.getModel().getTextPane().setEditable(false);
		
		
		controller.getModel().getTextPane().setText(content);
		
		controller.getModel().getReviewScrollPane().setViewportView(controller.getModel().getTextPane());
		
		// reviewer label
		controller.getModel().setReviewerID(new JLabel(reviewerID));
		controller.getModel().getReviewerID().setFont(new Font("Segoe UI", Font.BOLD, 14));
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		g.gridheight = 1;
		controller.getPanel().add(controller.getModel().getReviewerID(), g);
		
		// message button
		controller.getModel().setBtnMessageReviewer(new JButton("Message Reviewer"));
		controller.getModel().getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		g.gridx = 2;
		g.gridy = 0;
		g.gridwidth = 2;
		g.fill = g.HORIZONTAL;
		controller.getPanel().add(controller.getModel().getBtnMessageReviewer(), g);
		controller.getModel().getBtnMessageReviewer().addActionListener(controller);
		controller.getModel().getBtnMessageReviewer().setActionCommand("Review:message");
		
	}
	
}
