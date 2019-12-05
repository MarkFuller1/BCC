package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.models.LoginModel;
import BNU.logic.service.LoginService;
import BNU.presentation.LoginView;
import BNU.singleton.SingletonSession;

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
			if(ls.checkCredentials(model.getTxt_username().getText(),model.getTxt_password().getText())) {
			    boolean isAdmin = ls.isUserAdmin(model.getTxt_username().getText());
			    SingletonSession session = SingletonSession.getInstance(model.getTxt_username().getText(), isAdmin);
			    
			    System.out.println(SingletonSession.getInstance().getUserName());
			    
			    //SingletonSession.getInstance().isAdmin()
			    isAdmin = false;
			    if(isAdmin) {
			    	System.out.println("is admin: true");
			    	WindowBuilder.loadPage(new AdminController());
			    }else {
			    	System.out.println("is admin: false");
			    	WindowBuilder.loadPage(new MainController()); 
			    }
				
			}else {
				model.getTxt_username().setText("Enter Username");
				model.getTxt_password().setText("Enter Password");
			}
			

			//WindowBuilder.loadPage(new MainController());
		} else if(e.getActionCommand() == "login:AuthorizeAdmin") {
			//WindowBuilder.loadPage(new AdminController());
			System.out.println("admin logic is not in the submit button");
		}
		

	}

}
