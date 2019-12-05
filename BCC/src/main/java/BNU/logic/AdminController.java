package BNU.logic;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.models.AdminModel;
import BNU.logic.service.AdminService;
import BNU.logic.service.UserReviewService;
import BNU.presentation.AdminView;

public class AdminController extends PageController{
	static AdminView view;
	static AdminModel model = new AdminModel();
	static JPanel panel;
	static AdminService ac;
	
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
	
	
	
	public static AdminService getAc() {
		return ac;
	}

	public static void setAc(AdminService ac) {
		AdminController.ac = ac;
	}

	public static AbstractDB getDb() {
		return db;
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
			WindowBuilder.clip.stop();
			WindowBuilder.loadPage(new LoginController());
		}
		else if(e.getActionCommand().contains("delete")){
			for(Integer i = 0; i < getModel().getCounter(); i ++) {
				if(e.getActionCommand().contentEquals("delete"+i.toString())){
					System.out.println("delete button " + i.toString());
					new AdminService().deleteReview(getModel().getReviews().get(i).getRID());
				}
			}
		}
		else if(e.getActionCommand().contains("approve")){
			for(Integer i = 0; i < getModel().getCounter(); i ++) {
				if(e.getActionCommand().contentEquals("approve"+i.toString())){
					System.out.println("approve button " + i.toString());
					new AdminService().removeFlagOnReview(getModel().getReviews().get(i).getRID());
				}
			}
		}
		
	}
}