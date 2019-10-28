package com.BNU.pages.user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testULayout extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testULayout frame = new testULayout();
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
	public testULayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 974, 739);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserid = new JLabel("USERID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblUserid.setBounds(411, 11, 128, 106);
		panel.add(lblUserid);
		
		JButton btnMessage = new JButton("Log Out");
		btnMessage.setBounds(857, 73, 89, 23);
		panel.add(btnMessage);
		
		JButton button = new JButton("Message");
		button.setBounds(857, 39, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Back");
		
		button_1.setBounds(25, 48, 89, 23);
		panel.add(button_1);
		
	}
}
