package BNU.presentation;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BNU.logic.LoginController;
import BNU.logic.WindowBuilder;

public class LoginView {
	static JButton butNavigation;
	static JLabel labTitle;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

	public static void BuildLoginView(JFrame mainFrame, LoginController controller) {// } throws SecurityException,
																						// IOException {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);
		} catch (SecurityException | IOException e1) {
			System.out.println("Logger Failed in" + LoginView.class.getName());
		}

		LOGGER.setLevel(Level.FINEST);

		controller.setPanel(new JPanel());

		controller.getPanel().setLayout(null);

		// title label
		controller.getModel().setLab_Title(new JLabel("Welcome to Baylor Class Connect"));
		controller.getPanel().add(controller.getModel().getLab_Title()).setBounds(344, 184, 300, 80);
		controller.getPanel().add(controller.getModel().getLab_Title()).setFont(new Font("Segoe UI", Font.PLAIN, 18));

		// username label
		controller.getModel().setLab_Username(new JLabel("Username:"));
		controller.getPanel().add(controller.getModel().getLab_Username()).setBounds(342, 257, 112, 41);
		controller.getPanel().add(controller.getModel().getLab_Username())
				.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		// password label
		controller.getModel().setLab_Password(new JLabel("Password:"));
		controller.getPanel().add(controller.getModel().getLab_Password()).setBounds(342, 309, 112, 41);
		controller.getPanel().add(controller.getModel().getLab_Password())
				.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		// text fields
		controller.getModel().setTxt_username(new JTextField());
		controller.getPanel().add(controller.getModel().getTxt_username()).setBounds(443, 260, 187, 40);
		controller.getModel().getTxt_username().setColumns(10);

		controller.getModel().setTxt_password(new JPasswordField());
		controller.getPanel().add(controller.getModel().getTxt_password()).setBounds(443, 312, 186, 40);
		controller.getModel().getTxt_password().setColumns(10);

		// login button
		controller.getModel().setBut_Submit(new JButton("LOGIN"));
		controller.getPanel().add(controller.getModel().getBut_Submit()).setBounds(342, 383, 297, 23);
		controller.getPanel().add(controller.getModel().getBut_Submit()).setFont(new Font("Segoe UI", Font.PLAIN, 14));
		controller.getModel().getBut_Submit().setActionCommand("login:Authorize");
		controller.getModel().getBut_Submit().addActionListener(controller);

		/// create account button
		controller.getModel().setBut_Create(new JButton("CREATE ACCOUNT"));
		controller.getPanel().add(controller.getModel().getBut_Create()).setBounds(342, 439, 297, 23);
		controller.getPanel().add(controller.getModel().getBut_Create()).setFont(new Font("Segoe UI", Font.PLAIN, 14));
		controller.getModel().getBut_Create().setActionCommand("login:createAccount");
		controller.getModel().getBut_Create().addActionListener(controller);

		// String songFile = "resources" + File.separator + "DeckTheHalls_wav
		// (2019_01_14 02_55_16 UTC).AU";
		WindowBuilder.deck = new File("DeckTheHalls_wav (2019_01_14 02_55_16 UTC).AU");

		try {
			WindowBuilder.clip = AudioSystem.getClip();
			WindowBuilder.clip.open(AudioSystem.getAudioInputStream(WindowBuilder.deck));
			WindowBuilder.clip.start();

		} catch (Exception e) {
			LOGGER.warning("Failed to load audio in " + LoginView.class.getName());
		}

		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(controller.getPanel());
		mainFrame.setVisible(true);

		LOGGER.info("Login page loaded correctly");

	}
}
