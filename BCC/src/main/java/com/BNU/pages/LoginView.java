package com.BNU.pages;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginView {
	static JButton butNavigation;
	static JLabel labTitle;

	public static void BuildLoginView(JFrame mainFrame, LoginController controller) {
		
		
		LoginController.setPanel(new JPanel());
		LoginController.getPanel().setBackground(new Color(244, 123, 50));
		
		butNavigation = new JButton("goto -> main");
		butNavigation.setActionCommand("login:butNavigation");
		LoginController.getModel().setButNavigation(butNavigation);
		LoginController.getModel().getButNavigation().setBounds(10, 10, 100, 100);
		
		labTitle = new JLabel("Login Page");
		LoginController.getModel().setLabTitle(labTitle);
		LoginController.getModel().getLabTitle().setBounds(50, 50, 100, 100);
		
		
		LoginController.getPanel().add(LoginController.getModel().getButNavigation());
		LoginController.getPanel().add(LoginController.getModel().getLabTitle());

		mainFrame.setContentPane(LoginController.getPanel());
		mainFrame.setVisible(true);
	}
}
