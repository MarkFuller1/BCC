package com.BNU.pages.main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainView {
	static JButton butNavigation;
	static JLabel labTitle;

	public static void BuildLoginView(JFrame mainFrame, MainController controller) {

		controller.setPanel(new JPanel());
		controller.getPanel()
				.setLayout(new MigLayout("", "[][][][100.00,grow][][][][][][][][][14.00,grow][][][][]", "[][][][][]"));

		// title
		controller.getModel().setTxt_Title(new JLabel("BCC"));
		controller.getPanel().add(controller.getModel().getTxt_Title(), "cell 8 0");

		// professor label
		controller.getModel().setTxt_SearchProfessor(new JLabel("Search by Professor"));
		controller.getPanel().add(controller.getModel().getTxt_SearchProfessor(), "cell 13 3");

		// professor combobox
		controller.getModel().setCb_SearchProfessor(new JComboBox(controller.getDb().getAllProfessors()));
		controller.getPanel().add(controller.getModel().getCb_SearchProfessor(), "cell 13 4,growx");
		controller.getModel().getCb_SearchProfessor().setActionCommand("main:searchProfessor");
		controller.getModel().getCb_SearchProfessor().addActionListener(controller);

		// class label
		controller.getModel().setTxt_SearchClass(new JLabel("Search by Class"));
		controller.getPanel().add(controller.getModel().getTxt_SearchClass(), "cell 4 3");

		// class combobox
		controller.getModel().setCb_SearchClass(new JComboBox<String>(controller.getDb().getAllClasses()));
		controller.getPanel().add(controller.getModel().getCb_SearchClass(), "cell 4 4,growx");
		controller.getModel().getCb_SearchClass().setActionCommand("main:searchClass");
		controller.getModel().getCb_SearchClass().addActionListener(controller);

		// messages label
		controller.getModel().setTxt_Messages(new JLabel("Messages"));
		controller.getPanel().add(controller.getModel().getTxt_Messages(), "cell 16 0");

		addImage(mainFrame, controller);

		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}

	private static void addImage(JFrame mainFrame, MainController controller) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("resources" + File.separator + "mainImage.png"));
		} catch (IOException e) {
			System.out.println("image not loaded");
			e.printStackTrace();
		}
		controller.getModel()
				.setTxt_Image(new JLabel(new ImageIcon(getScaledImage(new ImageIcon(image).getImage(), 100, 100))));
		controller.getPanel().add(controller.getModel().getTxt_Image(), "cell 8 4");
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
