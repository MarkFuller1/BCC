package com.BNU.pages;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.dbWrapper;

public abstract class PageController implements ActionListener{
	public abstract void dispatchBuilder(JFrame mainFrame, dbWrapper db);
	
}
