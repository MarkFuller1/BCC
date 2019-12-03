package BNU.presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BNU.data.Course;
import BNU.data.ProfessorCourse;
import BNU.data.database.AbstractDB;
import BNU.data.database.DatabaseMock;
import BNU.logic.ClassByTeacherController;
import BNU.logic.LoginController;
import BNU.logic.service.ClassByTeacherService;
import net.miginfocom.swing.MigLayout;

public class ClassByTeacherView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	static ClassByTeacherService cbts = new ClassByTeacherService();

	public static void BuildTeachsersByClassView(JFrame mainFrame, ClassByTeacherController controller) {
		
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException | IOException e) {
			LOGGER.severe("Logger failed to load");
		}

		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);

		//build panel
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);

		//build test title
		controller.getModel().setTeacherP(new JPanel());
		controller.getModel().getTeacherP().setPreferredSize(new Dimension(1000, 100));
		controller.getModel().getTeacherP().setBounds(0,0,1000, 100);
		controller.getModel().getTeacherP().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		controller.getModel().setTxt_Title(new JLabel(controller.getProfessorName()));
		controller.getModel().getTxt_Title().setFont(new Font("Segoe UI", Font.BOLD, 33));
		controller.getModel().getTeacherP().add(controller.getModel().getTxt_Title());
		controller.getPanel().add(controller.getModel().getTeacherP());

		//build teachers label
		controller.getModel().setLab_Teachers(new JLabel("Teachers"));
		controller.getModel().getLab_Teachers().setFont(new Font("Segoe UI", Font.PLAIN, 19));
		controller.getModel().getLab_Teachers().setBounds(350, 265, 143, 33);
		controller.getPanel().add(controller.getModel().getLab_Teachers());

		//build ratings table
		controller.getModel().setLab_Ratings(new JLabel("Ratings"));
		controller.getModel().getLab_Ratings().setFont(new Font("Segoe UI", Font.PLAIN, 19));
		controller.getModel().getLab_Ratings().setBounds(600, 265, 143, 33);
		controller.getPanel().add(controller.getModel().getLab_Ratings());
		
		//build number of reviews
		controller.getModel().setLab_NumOfReviews(new JLabel("Number Of Reviews"));
		controller.getModel().getLab_NumOfReviews().setFont(new Font("Segoe UI", Font.PLAIN, 19));
		controller.getModel().getLab_NumOfReviews().setBounds(750, 265, 185, 33);
		controller.getPanel().add(controller.getModel().getLab_NumOfReviews());
		
		//build scroll-able class selector
		controller.getModel().setClasses(buildTeacherPanels(controller));
		
		controller.getModel().setScrollPane(new JScrollPane());
		controller.getModel().getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		controller.getModel().getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		controller.getModel().getScrollPane().setViewportBorder(new LineBorder(Color.BLACK));
		controller.getModel().setScrollPanePanel(new JPanel());
		controller.getModel().getScrollPanePanel().setLayout(new BoxLayout(controller.getModel().getScrollPanePanel(), BoxLayout.Y_AXIS));
		
		for (JComponent panel : controller.getModel().getClasses()) {
			controller.getModel().getScrollPanePanel().add(panel);
		}
		
		controller.getModel().getScrollPane().getViewport().add(controller.getModel().getScrollPanePanel());
		controller.getModel().getScrollPane().setBounds(10, 321, 964, 429);
		controller.getPanel().add(controller.getModel().getScrollPane());

		LOGGER.info("Professor Selection page loaded correctly");

		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
	}

	private static List<JComponent> buildTeacherPanels(ClassByTeacherController controller) {
		List<JComponent> panels = new ArrayList<>();
		
		Course[] courses = cbts.getAllCoursesByTeacherService(controller.professorName);
		for(Course course: courses) {
			System.out.println(course);
 			ProfessorCourse obj = new ProfessorCourse(course);
 			obj.getSelect().setActionCommand("class:" + course);
 			obj.getSelect().addActionListener(controller);
			panels.add(obj);
		}
		
		//dbWrapper db = new DatabaseMock();
		/*
		for(String course: courseNames) {
			System.out.println(course);
 			ProfessorCourse obj = new ProfessorCourse(controller.db.getCourse(course));
 			obj.getSelect().setActionCommand("class:" + course);
 			obj.getSelect().addActionListener(controller);
			panels.add(obj);
		}
		*/

		return panels;
	}
}
