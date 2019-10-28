package com.BNU.pages.teacher_review;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
	import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
	
public class testTeacherReview extends JFrame{

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
		public testTeacherReview() {
			setForeground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(100, 100, 1000, 800);
			setSize(1000,800);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Professor:");
			lblNewLabel.setBounds(234, 9, 118, 41);
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			getContentPane().add(lblNewLabel);
			
			JLabel lblUsername = new JLabel("Score");
			lblUsername.setBounds(146, 121, 56, 41);
			lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
			getContentPane().add(lblUsername);
			
			JLabel lblPassword = new JLabel("Helpfulness");
			lblPassword.setBounds(327, 121, 112, 41);
			lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			getContentPane().add(lblPassword);
			
			JButton btnNewButton_1 = new JButton("Back");
			btnNewButton_1.setBounds(10, 11, 106, 41);
			btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			getContentPane().add(btnNewButton_1);
			
			JLabel lblTeachingAbility = new JLabel("Teaching Ability");
			lblTeachingAbility.setBounds(527, 121, 160, 41);
			lblTeachingAbility.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			getContentPane().add(lblTeachingAbility);
			
			JLabel lblWorkload = new JLabel("Workload");
			lblWorkload.setBounds(729, 121, 112, 41);
			lblWorkload.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			getContentPane().add(lblWorkload);
			
			JLabel label = new JLabel("83");
			label.setBounds(146, 173, 56, 41);
			label.setLabelFor(lblUsername);
			label.setBackground(Color.YELLOW);
			label.setForeground(Color.DARK_GRAY);
			label.setFont(new Font("Segoe UI", Font.BOLD, 18));
			getContentPane().add(label);
			
			JLabel label_1 = new JLabel("50");
			label_1.setBounds(327, 173, 56, 41);
			label_1.setForeground(Color.DARK_GRAY);
			label_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			label_1.setBackground(Color.YELLOW);
			getContentPane().add(label_1);
			
			JLabel label_2 = new JLabel("99");
			label_2.setBounds(527, 173, 56, 41);
			label_2.setForeground(Color.DARK_GRAY);
			label_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			label_2.setBackground(Color.YELLOW);
			getContentPane().add(label_2);
			
			JLabel label_3 = new JLabel("45");
			label_3.setBounds(729, 173, 56, 41);
			label_3.setForeground(Color.DARK_GRAY);
			label_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			label_3.setBackground(Color.YELLOW);
			getContentPane().add(label_3);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(85, 257, 804, 363);
			getContentPane().add(scrollPane);
			
			JPanel panel = new JPanel();
			scrollPane.setViewportView(panel);
			panel.setLayout(null);
			
			JButton btnUp = new JButton("U");
			btnUp.setForeground(Color.BLUE);
			btnUp.setBounds(0, 126, 50, 34);
			btnUp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			panel.add(btnUp);
			
			JButton btnDown = new JButton("D");
			btnDown.setForeground(Color.RED);
			btnDown.setBounds(0, 160, 50, 34);
			btnDown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			panel.add(btnDown);
			
			JLabel label_4 = new JLabel("4");
			label_4.setBounds(60, 137, 55, 41);
			label_4.setForeground(Color.DARK_GRAY);
			label_4.setFont(new Font("Segoe UI", Font.BOLD, 40));
			label_4.setBackground(Color.YELLOW);
			panel.add(label_4);
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(785, 0, 17, 361);
			panel.add(scrollBar);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(110, 103, 655, 129);
			panel.add(scrollPane_1);
			
			//JLabel lblNewLabel_1 = new JLabel("This is a student reviewy");
			JTextPane lblNewLabel_1 = new JTextPane();
			lblNewLabel_1.setEditable(false);
			DefaultStyledDocument doc = new DefaultStyledDocument();
			try {
				doc.insertString(0, "hi\nhi\nhi\nhi\nhi\nhi\nhi", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblNewLabel_1.setStyledDocument(doc);
			scrollPane_1.setViewportView(lblNewLabel_1);
			//lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			
			JLabel lblNewLabel_2 = new JLabel("GreatReviewer4444");
			lblNewLabel_2.setBounds(110, 80, 562, 17);
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
			panel.add(lblNewLabel_2);
			
			JButton btnNewButton = new JButton("Message Reviewer");
			btnNewButton.setBounds(629, 80, 136, 23);
			panel.add(btnNewButton);
			
			JLabel lblClass = new JLabel("Class:");
			lblClass.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			lblClass.setBounds(234, 57, 118, 41);
			getContentPane().add(lblClass);
			
			JLabel lblDrNikolaTesla = new JLabel("Dr. Nikola Tesla");
			lblDrNikolaTesla.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			lblDrNikolaTesla.setBounds(362, 9, 515, 41);
			getContentPane().add(lblDrNikolaTesla);
			
			JLabel lblAdvnacedPhysics = new JLabel("Advnaced Physics (PHS 4477)");
			lblAdvnacedPhysics.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			lblAdvnacedPhysics.setBounds(362, 57, 515, 41);
			getContentPane().add(lblAdvnacedPhysics);
		}
}
