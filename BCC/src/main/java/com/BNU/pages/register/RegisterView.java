package com.BNU.pages.register;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.BNU.pages.register.RegisterModel;

import com.BNU.pages.main.MainController;

public class RegisterView {
	static JButton butNavigation;
	static JLabel labTitle;
	
	public static void BuildLoginView(JFrame mainFrame, RegisterController controller) {
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(new );
		
		//create account button
		controller.getModel().setBut_Create(new JButton("Create an account!"));
		
	}
}
