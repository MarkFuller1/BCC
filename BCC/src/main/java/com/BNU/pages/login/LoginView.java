package com.BNU.pages.login;

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
		
		
		controller.setPanel(new JPanel());
		controller.getPanel().setBackground(new Color(244, 123, 50));
		
		butNavigation = new JButton("goto -> main");
		controller.getModel().setButNavigation(butNavigation);
		controller.getModel().getButNavigation().setBounds(10, 10, 100, 100);
		controller.getModel().getButNavigation().setActionCommand("login:butNavigation");
		controller.getModel().getButNavigation().addActionListener(controller);
		
		labTitle = new JLabel("Login Page");
		controller.getModel().setLabTitle(labTitle);
		controller.getModel().getLabTitle().setBounds(50, 50, 100, 100);
		
		
		controller.getPanel().add(controller.getModel().getButNavigation());
		controller.getPanel().add(controller.getModel().getLabTitle());

		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
