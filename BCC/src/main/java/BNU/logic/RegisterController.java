package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.DatabaseMock;
import BNU.data.RegisterModel;
import BNU.data.dbWrapper;
import BNU.presentation.RegisterView;

public class RegisterController extends PageController {

	private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

	RegisterView view;
	RegisterModel model = new RegisterModel();
	JPanel panel;
	dbWrapper db;

	public RegisterController() {
		model = new RegisterModel();
		panel = new JPanel();
		view = new RegisterView();
		db = new DatabaseMock();

		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException | IOException e1) {
			System.out.println("Logger failed to load in " + RegisterController.class.getName());
		}

		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "register:createAccount") {
			LOGGER.info("Account Registered");
			WindowBuilder.loadPage(new LoginController());
		}
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		if (db == null) {
			this.db = db;
		}

		LOGGER.info("Building View");
		RegisterView.BuildRegisterView(mainFrame, this);
	}

	public RegisterView getView() {
		return view;
	}

	public void setView(RegisterView view) {
		this.view = view;
	}

	public RegisterModel getModel() {
		return model;
	}

	public void setModel(RegisterModel model) {
		this.model = model;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public dbWrapper getDb() {
		return db;
	}

	public void setDb(dbWrapper db) {
		this.db = db;
	}
}
