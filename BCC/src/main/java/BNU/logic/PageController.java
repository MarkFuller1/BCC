package BNU.logic;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;

/**
 * 
 * @author Kevin
 * 
 * BRIDGE GoF Design Pattern
 * Structural
 * 
 * This class follows the bridge design pattern because it separates
 * the abstraction from the implementation of the abstract methods.
 * This class implements the ActionListener interface and provides the 
 * abstraction for classes with refined abstraction and implementers to
 * use. With this abstraction, implementors will know how specific
 * concrete implementors must be structured.
 */

public abstract class PageController implements ActionListener{
	public static AbstractDB db;
	public abstract void dispatchBuilder(JFrame mainFrame);
	
}
