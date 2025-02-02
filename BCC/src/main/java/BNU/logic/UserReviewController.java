package BNU.logic;


import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.models.UserReviewModel;
import BNU.logic.service.UserReviewService;
import BNU.presentation.UserReviewView;
import BNU.singleton.SingletonSession;

public class UserReviewController extends PageController{
	static UserReviewView view;
	static UserReviewModel model = new UserReviewModel(); 
	static JPanel panel;
	static UserReviewService urs;
	JFrame mainF;
	
	public UserReviewController(){
		model = new UserReviewModel();
		panel = new JPanel();
		view = new UserReviewView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		this.mainF = mainFrame;
		try {
			UserReviewView.BuildUserReviewView(this.mainF, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static UserReviewService getUrs() {
		return urs;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		UserReviewController.panel = panel;
	}
	
	public UserReviewView getView() {
		return view;
	}

	public void setView(UserReviewView view) {
		UserReviewController.view = view;
	}

	public UserReviewModel getModel() {
		return model;
	}

	public void setModel(UserReviewModel model) {
		UserReviewController.model = model;
	}
	
	public static AbstractDB getDb() {
		return db;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "UserReview:messages"){
			System.out.println("UserReview:messages button pressed");
			WindowBuilder.loadPage(new MessageBoardController());
		}
		else if(e.getActionCommand() == "UserReview:back"){
			System.out.println("UserReview:back button pressed");
			WindowBuilder.loadPage(new MainController());
		}
		else if(e.getActionCommand() == "UserReview:logout"){
			System.out.println("UserReview:logout button pressed");
			WindowBuilder.clip.stop();
			WindowBuilder.loadPage(new LoginController());
		}
		else if(e.getActionCommand() == "UserReview:da"){
			System.out.println("UserReview:deleteAccount button pressed");
			new UserReviewService().deleteAccount(SingletonSession.getInstance().getUserName());
			JDialog d = new JDialog(this.mainF, "Deletion Confirmation");
            JLabel l = new JLabel("              Your account has been successfully deleted!"); 
            d.add(l); 
            d.setBounds(290, 290, 400, 200);
            d.setVisible(true); 
			WindowBuilder.clip.stop();
			WindowBuilder.loadPage(new LoginController());
		}
		else if(e.getActionCommand().contains("ed")) {
			System.out.println("UserReview:edit button pressed");
			for(Integer i = 0; i < getModel().getCounter(); i ++) {
				if(e.getActionCommand().contentEquals("ed"+i.toString())){
					System.out.println("Review number " + i.toString());
					
					new UserReviewService().changeReview(getModel().getReviews().get(i).getRID(), getModel().getReviews().get(i).getTextArea().getText());
				}
			}
		}
	}

}
