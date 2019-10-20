package com.BNU.windowbuilder;

import javax.swing.JFrame;

import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;

public class WindowBuilder {
	
	private static JFrame mainFrame;
	
	public WindowBuilder() {
		//build the JFrame 
		mainFrame = new JFrame("BCC");
		//TODO: change this to SaveDatabase() on close 
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null); //all components determine position absolutely
		mainFrame.setSize(1200, 1000);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		//now that the frame has been built, show the first pane.
		this.loadPage(new LoginController());
	}
	
	public static void loadPage(PageController pageName) {
		pageName.dispatchBuilder(mainFrame);
	}
}
