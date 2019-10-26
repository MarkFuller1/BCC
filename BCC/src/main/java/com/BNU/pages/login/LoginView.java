package com.BNU.pages.login;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class LoginView {
	static JButton butNavigation;
	static JLabel labTitle;

	public static void BuildLoginView(JFrame mainFrame, LoginController controller) {
		
		/*
		controller.setPanel(new JPanel());
		
		butNavigation = new JButton("goto -> main");
		controller.getPanel().setLayout(null);
		controller.getModel().setButNavigation(butNavigation);
		controller.getModel().getButNavigation().setBounds(10, 10, 100, 100);
		controller.getModel().getButNavigation().setActionCommand("login:butNavigation");
		controller.getModel().getButNavigation().addActionListener(controller);
		
		labTitle = new JLabel("Login Page");
		controller.getModel().setLabTitle(labTitle);
		controller.getModel().getLabTitle().setBounds(50, 50, 100, 100);
		
		
		controller.getPanel().add(controller.getModel().getButNavigation());
		controller.getPanel().add(controller.getModel().getLabTitle());
		*/
		
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(new MigLayout("", "[][][][][][][][][][][][][][-18.00][237.00][][][331.00,grow]", "[][][][70.00][][][][][][][][]"));
		
		///create account button
		controller.getModel().setBut_Create(new JButton("Create an account!"));
		controller.getPanel().add(controller.getModel().getBut_Create(),"cell 14 11,growx");
		controller.getModel().getBut_Create().setActionCommand("login:createAccount");
		controller.getModel().getBut_Create().addActionListener(controller);
		
		//login button
		controller.getModel().setBut_Submit(new JButton("Login!"));
		controller.getPanel().add(controller.getModel().getBut_Submit(), "cell 14 9,alignx center");
		controller.getModel().getBut_Submit().setActionCommand("login:Authorize");
		controller.getModel().getBut_Submit().addActionListener(controller);
		
		//password label
		controller.getModel().setLab_Password(new JLabel("Password:"));
		controller.getPanel().add(controller.getModel().getLab_Password(),  "cell 11 7");
		
		//title label
		controller.getModel().setLab_Title(new JLabel("Welcome to Baylor Class Connect"));
		controller.getPanel().add(controller.getModel().getLab_Title(),"cell 14 3,alignx center,aligny center");
		
		//username label
		controller.getModel().setLab_Username(new JLabel("Username:"));
		controller.getPanel().add(controller.getModel().getLab_Username(), "cell 11 5");
		
		//text fields
		controller.getModel().setTxt_password(new JTextField());
		controller.getPanel().add(controller.getModel().getTxt_password(), "cell 14 7,growx");
		
		controller.getModel().setTxt_username(new JTextField());
		controller.getPanel().add(controller.getModel().getTxt_username(), "cell 14 5,growx");
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
