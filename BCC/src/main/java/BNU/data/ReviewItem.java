package BNU.data;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import refactor.these.ReviewModel2;

public class ReviewItem {
		
	public ReviewItem() {  //Should take a database object as a parameter and populate this info using a record.
		ReviewModel2 rm = new ReviewModel2();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(804,200);
		
		// up button
		rm.setBtnUp(new JButton("U"));
		rm.getBtnUp().setForeground(Color.BLUE);
		rm.getBtnUp().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		rm.getBtnUp().setBounds(0, 45, 55, 38);
		panel.add(rm.getBtnUp());


		// down button
		rm.setBtnDown(new JButton("D"));
		rm.getBtnDown().setForeground(Color.RED);
		rm.getBtnDown().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		rm.getBtnDown().setBounds(0, 83, 55, 38);		
		panel.add(rm.getBtnDown());

		// review score label
		rm.setReviewScore(new JLabel("4"));
		rm.getReviewScore().setHorizontalAlignment(SwingConstants.CENTER);
		rm.getReviewScore().setFont(new Font("Segoe UI", Font.PLAIN, 30));
		rm.getReviewScore().setBounds(52, 55, 61, 48);
		panel.add(rm.getReviewScore());

		// scroll pane
		rm.setReviewScrollPane(new JScrollPane());
		rm.getReviewScrollPane().setBounds(111, 30, 675, 129);
		panel.add(rm.getReviewScrollPane());
		
		// text pane
		rm.setTextPane(new JTextPane());
		rm.getTextPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rm.getTextPane().setEditable(false);
		rm.getTextPane().setText("plug data\nplug data\nplug data\nplug data\nplug data\nplug data\nplug data\nplug data\nplug data\n");
		rm.getReviewScrollPane().setViewportView(rm.getTextPane());
		
		// reviewer label
		rm.setReviewerID(new JLabel("GreatReviewer4444"));
		rm.getReviewerID().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rm.getReviewerID().setBounds(111, 11, 499, 14);
		panel.add(rm.getReviewerID());
		
		// down button
		rm.setBtnMessageReviewer(new JButton("Message Reviewer"));
		rm.getBtnMessageReviewer().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rm.getBtnMessageReviewer().setBounds(657, 7, 129, 23);		
		panel.add(rm.getBtnMessageReviewer());
		

		rm.setPanel(panel);
	
		
	}

}
