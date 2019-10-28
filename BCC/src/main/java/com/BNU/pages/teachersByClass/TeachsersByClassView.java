package com.BNU.pages.teachersByClass;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.BNU.pages.login.LoginController;

import net.miginfocom.swing.MigLayout;

public class TeachsersByClassView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());


	public static void BuildTeachsersByClassView(JFrame mainFrame, TeachersByClassController controller) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException | IOException e) {
			LOGGER.severe("Logger failed to load");
		}
		
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);
		
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		
		
		
		
		
		LOGGER.info("Professor Selection page loaded correctly");
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}
}
