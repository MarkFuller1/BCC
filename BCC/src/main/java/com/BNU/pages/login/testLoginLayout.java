package com.BNU.pages.login;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class testLoginLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testLoginLayout frame = new testLoginLayout();
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
	public testLoginLayout() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][-18.00][237.00][][][331.00,grow]", "[][][][70.00][][][][][][][][]"));
		
		JLabel lblBaylorClassConnect = new JLabel("Welcome to Baylor Class Connect");
		contentPane.add(lblBaylorClassConnect, "cell 14 3,alignx center,aligny center");
		
		JLabel lblUsername = new JLabel("Username ");
		contentPane.add(lblUsername, "cell 11 5");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 14 5,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		contentPane.add(lblPassword, "cell 11 7");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 14 7,growx");
		textField_1.setColumns(10);
		
		JButton btnCreateAnAccount = new JButton("Login");
		contentPane.add(btnCreateAnAccount, "cell 14 9,alignx center");
		
		JButton btnCreateAnAccount_1 = new JButton("Create an account");
		contentPane.add(btnCreateAnAccount_1, "cell 14 11,growx");
	}

}
