package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.database.DatabaseMock;
import BNU.data.models.RegisterModel;
import BNU.logic.service.LoginService;
import BNU.logic.service.RegisterService;
import BNU.presentation.RegisterView;

public class RegisterController extends PageController {

	private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

	RegisterView view;
	RegisterModel model = new RegisterModel();
	JPanel panel;
	static RegisterService rs;
	//dbWrapper db;

	public RegisterController() {
		model = new RegisterModel();
		panel = new JPanel();
		view = new RegisterView();
		rs = new RegisterService();
		//db = new DatabaseMock();

		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.FINEST);
		} catch (SecurityException | IOException e1) { 
			System.out.println("Logger failed to load in " + RegisterController.class.getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "register:createAccount") {
			LOGGER.info("Account Registered");
			
			//WindowBuilder.loadPage(new LoginController());
			
			//Commented out to make easier access to application. Code is good.
			if(!(rs.checkCredentials(model.getTxt_username().getText(),model.getTxt_password().getText()))) {
				if(rs.insertCredentials(model.getTxt_username().getText(),model.getTxt_password().getText())) {
					LOGGER.info("Added " + model.getTxt_username().getText() + " to the system.");
					WindowBuilder.loadPage(new LoginController());
				}else { 
					//potentially throw bad database error exception
					LOGGER.severe("Cannot insert credentials into database to register user");
					model.getTxt_username().setText("Enter Username Again");
					model.getTxt_password().setText("Enter Password Again");
				}
			    
			}else {
				model.getTxt_username().setText("Enter Username Again");
				model.getTxt_password().setText("Enter Password Again");
			}
		}
		else if(e.getActionCommand().equals("Register:back")){
			LOGGER.info("Register back button selected");
			WindowBuilder.loadPage(new LoginController());
		}
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame) {
//		if (db == null) {
//			this.db = db;
//		}

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

	public AbstractDB getDb() {
		return db;
	}

//	public void setDb(dbWrapper db) {
//		this.db = db;
//	}
}
