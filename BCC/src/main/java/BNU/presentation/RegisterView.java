package BNU.presentation;

import java.awt.Font;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import BNU.logic.RegisterController;

public class RegisterView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

	static {
		try {
			FileHandler fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e) {
			System.out.println("Logger failed to load in " + RegisterView.class.getName()); 
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void BuildRegisterView(JFrame mainFrame, RegisterController controller) {

		controller.setPanel(new JPanel());
		controller.getPanel().setLayout(null);

		// title label
		controller.getModel().setLab_Title(new JLabel("Make an Account"));
		controller.getPanel().add(controller.getModel().getLab_Title()).setBounds(398, 28, 349, 38);
		controller.getPanel().add(controller.getModel().getLab_Title()).setFont(new Font("Segoe UI", Font.PLAIN, 30));
		
		//back button
		controller.getModel().setBtnBack(new JButton("Back"));
		controller.getPanel().add(controller.getModel().getBtnBack()).setBounds(10, 11, 106, 41);
		controller.getPanel().add(controller.getModel().getBtnBack()).setFont(new Font("Segoe UI", Font.BOLD, 18));
		controller.getModel().getBtnBack().setActionCommand("Register:back");
		controller.getModel().getBtnBack().addActionListener(controller);

		// username label
		controller.getModel().setLab_Username(new JLabel("Username:"));
		controller.getPanel().add(controller.getModel().getLab_Username()).setBounds(25, 300, 146, 48);
		controller.getPanel().add(controller.getModel().getLab_Username())
				.setFont(new Font("Segoe UI", Font.PLAIN, 26));

		// password label
		controller.getModel().setLab_Password(new JLabel("Password:"));
		controller.getPanel().add(controller.getModel().getLab_Password()).setBounds(25, 405, 135, 40);
		controller.getPanel().add(controller.getModel().getLab_Password())
				.setFont(new Font("Segoe UI", Font.PLAIN, 26));

		// newinfo label
		controller.getModel().setNew_info(new JLabel("User Information"));
		controller.getPanel().add(controller.getModel().getNew_info()).setBounds(200, 252, 214, 35);
		controller.getPanel().add(controller.getModel().getNew_info()).setFont(new Font("Segoe UI", Font.PLAIN, 26));

		// Possible classes taken label
		controller.getModel().setClasses_possible(new JLabel("Add Classes Taken"));
		controller.getPanel().add(controller.getModel().getClasses_possible()).setBounds(620, 252, 274, 35);
		controller.getPanel().add(controller.getModel().getClasses_possible())
				.setFont(new Font("Segoe UI", Font.PLAIN, 26));

		// classes taken list
		controller.getModel().setClasses_taken(new JList<String>(controller.getDb().getAllClasses()));
		controller.getModel().getClasses_taken().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		controller.getModel().setMenuScrollPane(controller.getModel().getClasses_taken());
		controller.getPanel().add(controller.getModel().getMenuScrollPane()).setBounds(555, 302, 380, 250);

		// text fields
		controller.getModel().setTxt_username(new JTextField());
		controller.getPanel().add(controller.getModel().getTxt_username()).setBounds(170, 305, 282, 48);
		controller.getModel().getTxt_username().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		controller.getModel().getTxt_username().setColumns(10);

		controller.getModel().setTxt_password(new JPasswordField());
		controller.getPanel().add(controller.getModel().getTxt_password()).setBounds(170, 409, 282, 40);
		controller.getModel().getTxt_password().setFont(new Font("Segoe UI", Font.PLAIN, 20));
		controller.getModel().getTxt_password().setColumns(10);

		// create account button
		controller.getModel().setBut_Register(new JButton("Register!"));
		controller.getPanel().add(controller.getModel().getBut_Register()).setBounds(450, 600, 116, 40);
		controller.getPanel().add(controller.getModel().getBut_Register())
				.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		controller.getModel().getBut_Register().setActionCommand("register:createAccount");
		controller.getModel().getBut_Register().addActionListener(controller);

		LOGGER.info("Register page built correctly");

		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);

	}
}
