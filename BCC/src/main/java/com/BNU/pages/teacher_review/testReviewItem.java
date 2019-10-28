package com.BNU.pages.teacher_review;

	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
	
public class testReviewItem extends JFrame{

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						testTeacherReview frame = new testTeacherReview();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public testReviewItem() {
			setForeground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(100, 100, 1000, 800);
			setSize(804,200);
			getContentPane().setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 788, 161);
			getContentPane().add(scrollPane);
			
			JPanel panel = new JPanel();
			scrollPane.setViewportView(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JTextPane textPane = new JTextPane();
			panel.add(textPane, BorderLayout.CENTER);
			
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(100, 100));
			panel.add(panel_1, BorderLayout.WEST);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(68, 61, 48, 14);
			panel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(-15, 61, 48, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(23, 86, 48, 14);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblUsername = new JLabel("UserName");
			panel.add(lblUsername, BorderLayout.NORTH);
			
			JPanel panel_2 = new JPanel();
			panel.add(panel_2, BorderLayout.EAST);
			panel_2.setPreferredSize(new Dimension(100, 100));
			panel_2.setLayout(null);
			
			JButton btnMessage = new JButton("Message");
			btnMessage.setBounds(10, 53, 89, 23);
			btnMessage.setPreferredSize(new Dimension(89, 23));
			panel_2.add(btnMessage);
			
			
		}
}
