package com.BNU.pages.main;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView {
	static JButton butNavigation;
	static JLabel labTitle;

	public static void BuildLoginView(JFrame mainFrame, MainController controller) {
		
		
		controller.setPanel(new JPanel());
		controller.getPanel().setBackground(new Color(50, 123, 50));
		
		butNavigation = new JButton("goto -> login");
		controller.getModel().setButNavigation(butNavigation);
		controller.getModel().getButNavigation().setBounds(10, 10, 100, 100);
		controller.getModel().getButNavigation().setActionCommand("main:butNavigation");
		controller.getModel().getButNavigation().addActionListener(controller);
		
		labTitle = new JLabel("Main Page");
		controller.getModel().setLabTitle(labTitle);
		controller.getModel().getLabTitle().setBounds(50, 50, 100, 100);
		
		
		controller.getPanel().add(controller.getModel().getButNavigation());
		controller.getPanel().add(controller.getModel().getLabTitle());

		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
