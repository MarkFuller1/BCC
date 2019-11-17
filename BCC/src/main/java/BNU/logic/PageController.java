package BNU.logic;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.dbWrapper;

public abstract class PageController implements ActionListener{
	public static dbWrapper db;
	public abstract void dispatchBuilder(JFrame mainFrame);
	
}
