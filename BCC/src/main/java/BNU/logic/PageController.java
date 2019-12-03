package BNU.logic;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.AbstractDB;

public abstract class PageController implements ActionListener{
	public static AbstractDB db;
	public abstract void dispatchBuilder(JFrame mainFrame);
	
}
