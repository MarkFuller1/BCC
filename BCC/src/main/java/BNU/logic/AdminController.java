package BNU.logic;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.AdminModel;
import BNU.presentation.AdminView;

public class AdminController extends PageController{
	static AdminView view;
	static AdminModel model = new AdminModel();
	static JPanel panel;
	
	public AdminController(){
		model = new AdminModel();
		panel = new JPanel();
		view = new AdminView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		try {
			AdminView.BuildAdminView(mainFrame, this);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		AdminController.panel = panel;
	}
	
	public AdminView getView() {
		return view;
	}

	public void setView(AdminView view) {
		AdminController.view = view;
	}

	public AdminModel getModel() {
		return model;
	}

	public void setModel(AdminModel model) {
		AdminController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Admin:main"){
			System.out.println("Admin:main button pressed");
			WindowBuilder.loadPage(new MainController());
		}
		else if(e.getActionCommand() == "Admin:logout"){
			System.out.println("Admin:logout button pressed");
			WindowBuilder.loadPage(new LoginController());
		}
	}
}