package com.BNU.pages.main;

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

public class MainView {
	static JButton butNavigation;
	static JLabel labTitle;
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void BuildMainView(JFrame mainFrame, MainController controller) {
				
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("Main page loaded successfully");


		// title
		controller.getModel().setTxt_Title(new JLabel("BCC"));
		controller.getModel().getTxt_Title().setFont(new Font("Segoe UI", Font.PLAIN, 50));
		controller.getModel().getTxt_Title().setBounds(436, 11, 96, 50);

		// page label
		controller.getModel().setTxt_Slogan(new JLabel("Baylor Computer Science Reviews by Students"));
		controller.getModel().getTxt_Slogan().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		controller.getModel().getTxt_Slogan().setBounds(288, 117, 436, 50);
		
		// class label
		controller.getModel().setTxt_SearchClass(new JLabel("Search by Class"));
		controller.getModel().getTxt_SearchClass().setBounds(59, 244, 143, 50);
		controller.getModel().getTxt_SearchClass().setFont(new Font("Segoe UI", Font.PLAIN, 18));

		// class combobox
		controller.getModel().setCb_SearchClass(new JComboBox<String>(MainController.getDb().getAllClasses()));
		controller.getModel().getCb_SearchClass().setBounds(59, 298, 163, 22);
		controller.getModel().getCb_SearchClass().setActionCommand("main:searchClass");
		controller.getModel().getCb_SearchClass().addActionListener(controller);

		// professor label
		controller.getModel().setTxt_SearchProfessor(new JLabel("Search by Professor"));
		controller.getModel().getTxt_SearchProfessor().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		controller.getModel().getTxt_SearchProfessor().setBounds(762, 251, 185, 37);

		// professor combobox
		controller.getModel().setCb_SearchProfessor(new JComboBox(MainController.getDb().getAllProfessors()));
		controller.getModel().getCb_SearchProfessor().setBounds(762, 298, 163, 22);
		controller.getModel().getCb_SearchProfessor().setActionCommand("main:searchProfessor");
		controller.getModel().getCb_SearchProfessor().addActionListener(controller);

		// messages label
		controller.getModel().setBtn_Messages(new JButton("Messages"));
		controller.getModel().getBtn_Messages().setBounds(25, 23, 126, 38);
		controller.getModel().getBtn_Messages().setFont(new Font("Segoe UI", Font.PLAIN, 18));

		addImage(mainFrame, controller);
		//mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
		
	}

	private static void addImage(JFrame mainFrame, MainController controller) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("resources" + File.separator + "mainImage.png"));
		} catch (IOException e) {
			System.out.println("image not loaded");
			LOGGER.info("Image not loaded!");
			e.printStackTrace();
		}
		//controller.getPanel().setLayout(null);
		//controller.getModel().getTxt_Image().setIcon(new ImageIcon("resources" + File.separator + "mainImage.png"));

		controller.getModel()
				.setTxt_Image(new JLabel(new ImageIcon(getScaledImage(new ImageIcon(image).getImage(), 100, 100))));
		controller.getModel().getTxt_Image().setBounds(448, 266, 100, 100);
	}

	private static Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
}
