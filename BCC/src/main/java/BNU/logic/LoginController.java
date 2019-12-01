package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.LoginModel;
import BNU.data.AbstractDB;
import BNU.logic.service.LoginService;
import BNU.presentation.LoginView;

public class LoginController extends PageController {
	static LoginView view;
	static LoginModel model = new LoginModel();
	static JPanel panel;
	static LoginService ls;
	//static dbWrapper db;

	public LoginController() {
		model = new LoginModel();
		panel = new JPanel();
		view = new LoginView();
		ls = new LoginService();
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame) {
//		if (db == null) {
//			this.db = db;
//		}

		LoginView.BuildLoginView(mainFrame, this);

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		LoginController.panel = panel;
	}

	public LoginView getView() {
		return view;
	}

	public void setView(LoginView view) {
		LoginController.view = view;
	}

	public LoginModel getModel() {
		return model;
	}

	public void setModel(LoginModel model) {
		LoginController.model = model;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "login:createAccount") {
			System.out.println("login:createAccount Button Pressed");
			//Sound
			WindowBuilder.clip.stop();
			

			WindowBuilder.loadPage(new RegisterController());
		} else if (e.getActionCommand() == "login:Authorize") {
			System.out.println("login:Authorize Button Pressed");

			//Commented out to make easier access to application. Code is good.
			//if(ls.checkCredentials(model.getTxt_username().getText(),model.getTxt_password().getText())) {
				WindowBuilder.loadPage(new MainController()); 
//			}else {
//				model.getTxt_username().setText("Enter Username");
//				model.getTxt_password().setText("Enter Password");
//			}
			

			
		} else if(e.getActionCommand() == "login:AuthorizeAdmin") {
			WindowBuilder.loadPage(new AdminController());

		}
		

	}

}
