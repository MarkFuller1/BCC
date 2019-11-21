package BNU.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import BNU.logic.MainController;
import BNU.logic.service.MainService;

public class MainView {
	static JButton butNavigation;
	static JLabel labTitle;
	static MainService ms;

	@SuppressWarnings("unchecked")
	public static void BuildMainView(JFrame mainFrame, MainController controller) {
		ms = new MainService();

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(new BorderLayout(10, 10));
		
		//build message button
		controller.getModel().setNorth_east_Panel(new JPanel(null));
		controller.getModel().getNorth_east_Panel().setPreferredSize(new Dimension(120, 100));
		controller.getModel().setBtn_Message(new JButton("Profile"));
		controller.getModel().getBtn_Message().setActionCommand("main:profile");
		controller.getModel().getBtn_Message().addActionListener(controller);
		controller.getModel().getBtn_Message().setFont(new Font("Segoe UI", Font.BOLD, 18));;
		controller.getModel().getBtn_Message().setBounds(10, 11, 106, 41); 
		controller.getModel().getNorth_east_Panel().add(controller.getModel().getBtn_Message());
		
		// build log out button
		controller.getModel().setLog_out(new JButton("Log Out"));
		controller.getPanel().add(controller.getModel().getLog_out()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getLog_out()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getLog_out().setActionCommand("main:logout");
		controller.getModel().getLog_out().addActionListener(controller);
		
		//build North panel
		controller.getModel().setNorth_Panel(new JPanel(new BorderLayout()));
		controller.getModel().getNorth_Panel().setPreferredSize(new Dimension(150, 150));
		controller.getModel().setTxt_Title(new JLabel("Baylor Class Connect"));
		controller.getModel().getTxt_Title().setFont(new Font("Segoe UI", Font.PLAIN, 35));
		controller.getModel().getTxt_Title().setHorizontalAlignment(SwingConstants.CENTER);
		controller.getModel().setNorth_center_Panel(new JPanel(null));
		controller.getModel().getTxt_Title().setBounds(250,  50,  500,  100);
		controller.getModel().getNorth_center_Panel().add(controller.getModel().getTxt_Title());
		controller.getModel().getNorth_Panel().add(controller.getModel().getNorth_center_Panel(), BorderLayout.CENTER);
		controller.getPanel().add(controller.getModel().getNorth_Panel(), BorderLayout.NORTH);
		controller.getModel().getNorth_Panel().add(controller.getModel().getNorth_east_Panel(), BorderLayout.EAST);
		
		//build west panel
		controller.getModel().setWest_Panel(new JPanel(null));
		controller.getModel().getWest_Panel().setPreferredSize(new Dimension(300, 400));
		
		controller.getModel().setTxt_SearchClass(new JLabel("Search By Class"));
		controller.getModel().getTxt_SearchClass().setHorizontalAlignment(SwingConstants.CENTER);
		controller.getModel().getTxt_SearchClass().setBounds(41, 164, 205, 43);
		controller.getModel().getWest_Panel().add(controller.getModel().getTxt_SearchClass());
		
		//controller.getModel().setCb_SearchClass(new JComboBox(controller.getDb().getAllClasses()));
		controller.getModel().setCb_SearchClass(new JComboBox<String>(ms.getAllClassesOffered()));
		controller.getModel().getCb_SearchClass().setActionCommand("main:searchClass");
		controller.getModel().getCb_SearchClass().addActionListener(controller);
		controller.getModel().getCb_SearchClass().setBounds(41, 218, 205, 43);
		controller.getModel().getWest_Panel().add(controller.getModel().getCb_SearchClass());
		
		controller.getPanel().add(controller.getModel().getWest_Panel(), BorderLayout.WEST);
		
		//build east panel
		controller.getModel().setEast_Panel(new JPanel(null));
		controller.getModel().getEast_Panel().setPreferredSize(new Dimension(300, 400));
		
		controller.getModel().setTxt_SearchProfessor(new JLabel("Search By Professor"));
		controller.getModel().getTxt_SearchProfessor().setHorizontalAlignment(SwingConstants.CENTER);
		controller.getModel().getTxt_SearchProfessor().setBounds(41, 164, 205, 43);
		controller.getModel().getEast_Panel().add(controller.getModel().getTxt_SearchProfessor());
		
		//controller.getModel().setCb_SearchProfessor(new JComboBox<String>(controller.getDb().getAllProfessors()));
		controller.getModel().setCb_SearchProfessor(new JComboBox<String>(ms.getAllProfs()));
		controller.getModel().getCb_SearchProfessor().setActionCommand("main:searchProfessor");
		controller.getModel().getCb_SearchProfessor().addActionListener(controller);
		controller.getModel().getCb_SearchProfessor().setBounds(41, 218, 205, 43);
		controller.getModel().getEast_Panel().add(controller.getModel().getCb_SearchProfessor());
		
		controller.getPanel().add(controller.getModel().getEast_Panel(), BorderLayout.EAST);
		
		//build center panel
		

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
				.setTxt_Image(new JLabel(new ImageIcon(getScaledImage(new ImageIcon(image).getImage(), 300, 300))));
		controller.getModel().setCenter_Panel(new JPanel());
		controller.getModel().getCenter_Panel().add(controller.getModel().getTxt_Image(), BorderLayout.CENTER);
		controller.getPanel().add(controller.getModel().getCenter_Panel(), BorderLayout.CENTER);
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
