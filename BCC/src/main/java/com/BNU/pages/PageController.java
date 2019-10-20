package com.BNU.pages;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class PageController implements ActionListener{
	public enum PageType{
		Login,
		Main;

	}
	
	public abstract void dispatchBuilder(JFrame mainFrame);
	
}
