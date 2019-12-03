package BNU.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BNU.logic.SetReviewController;

public class SetReviewView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(SetReviewController.class.getName());

	@SuppressWarnings("unused")
	public static void BuildSetReviewView(JFrame mainFrame, SetReviewController controller,String teacherName, String className) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.warning("Couldn't get lock for BCC.log");
			
		}
		
		//build panel
		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);
		
		
		//build back
		controller.getModel().setBack(new JButton("Home"));
		controller.getPanel().add(controller.getModel().getBack()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getBack()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBack().setActionCommand("SetReview:Back");
		controller.getModel().getBack().addActionListener(controller);
		
		//build back
		//String teacher = "Cindy Fry";
		
		// request teacher here
		controller.getModel().setTeacher(new JLabel(teacherName));
		controller.getPanel().add(controller.getModel().getTeacher()).setBounds(340, 11, 200, 41);
		controller.getPanel().add(controller.getModel().getTeacher()).setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		// build back
		//String lass = "CSI 1430";
		// request teacher here
		controller.getModel().setClassL(new JLabel(className));
		controller.getPanel().add(controller.getModel().getClassL()).setBounds(540, 11, 200, 41);
		controller.getPanel().add(controller.getModel().getClassL()).setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		// teaching ability
		controller.getModel().setTeaching(new JLabel("Teaching Ability"));
		controller.getPanel().add(controller.getModel().getTeaching()).setBounds(243, 150, 150, 41);
		controller.getPanel().add(controller.getModel().getTeaching()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		//build teachingR
		controller.getModel().setTeachingR(new JTextField());
		controller.getPanel().add(controller.getModel().getTeachingR()).setBounds(287, 200, 40, 40);
		controller.getModel().getTeachingR().setHorizontalAlignment(JTextField.CENTER);
		controller.getModel().getTeachingR().setColumns(5);
		
		// workload
		controller.getModel().setWorkload(new JLabel("Workload"));
		controller.getPanel().add(controller.getModel().getWorkload()).setBounds(643, 150, 150, 41);
		controller.getPanel().add(controller.getModel().getWorkload()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		//build workloadR
		controller.getModel().setWorkloadR(new JTextField());
		controller.getPanel().add(controller.getModel().getWorkloadR()).setBounds(488, 200, 40, 40);
		controller.getModel().getWorkloadR().setColumns(5);
		controller.getModel().getWorkloadR().setHorizontalAlignment(JTextField.CENTER);
		
		// helpfulness
		controller.getModel().setHelpfulness(new JLabel("Helpfulness"));
		controller.getPanel().add(controller.getModel().getHelpfulness()).setBounds(460, 150, 150, 41);
		controller.getPanel().add(controller.getModel().getHelpfulness()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		//build HelpfulnessR
		controller.getModel().setHelpfulnessR(new JTextField());
		controller.getPanel().add(controller.getModel().getHelpfulnessR()).setBounds(665, 200, 40, 40);
		controller.getModel().getHelpfulnessR().setColumns(5);
		controller.getModel().getHelpfulnessR().setHorizontalAlignment(JTextField.CENTER);
		
		// description
		controller.getModel().setDescription(new JLabel("Add Description"));
		controller.getPanel().add(controller.getModel().getDescription()).setBounds(445, 262, 200, 40);
		controller.getPanel().add(controller.getModel().getDescription()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		//build descriptionR
		controller.getModel().setDescriptionR(new JTextArea());
		controller.getPanel().add(controller.getModel().getDescriptionR()).setBounds(200, 300, 600, 150);
		controller.getModel().getDescriptionR().setLineWrap(true);
		
		// submit
		controller.getModel().setSubmit(new JButton("Submit"));
		controller.getPanel().add(controller.getModel().getSubmit()).setBounds(458, 472, 106, 41);
		controller.getPanel().add(controller.getModel().getSubmit()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getSubmit().setActionCommand("SetReview:Submit");
		controller.getModel().getSubmit().addActionListener(controller);
		
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);
		
		
		
		LOGGER.info("AddReview page loaded correctly");
	}
}
