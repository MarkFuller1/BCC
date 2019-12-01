package BNU.logic;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.SetReviewModel;
import BNU.logic.service.SetReviewService;
import BNU.presentation.SetReviewView;
import BNU.singleton.SingletonSession;

public class SetReviewController extends PageController{
	static SetReviewView view;
	static SetReviewModel model = new SetReviewModel();
	static JPanel panel;
	static SetReviewService srs;
	String teacherName;
	String className;
	
	public SetReviewController(String teacherName, String className){
		//model = new SetReviewModel();
		panel = new JPanel();
		view = new SetReviewView();
		srs = new SetReviewService();
		this.teacherName = teacherName;
		this.className = className;
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		try {
			SetReviewView.BuildSetReviewView(mainFrame, this,this.teacherName, this.className);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "SetReview:Submit"){
			System.out.println("SetReview:Submit button pressed");
			// update the data
			String content = model.getDescriptionR().getText();
			String TA = model.getTeachingR().getText();
			String H = model.getHelpfulnessR().getText();
			String WL = model.getWorkloadR().getText();
			srs.createReview(SingletonSession.getInstance().getUserName(),this.teacherName,this.className,content,TA,H,WL);
			WindowBuilder.loadPage(new UserReviewController());
		}
		else if(e.getActionCommand() == "SetReview:Back") {
			System.out.println("SetReview:Back button pressed");
			WindowBuilder.loadPage(new MainController());
		}
	}

	public static SetReviewView getView() {
		return view;
	}

	public static void setView(SetReviewView view) {
		SetReviewController.view = view;
	}

	public static SetReviewModel getModel() {
		return model;
	}

	public static void setModel(SetReviewModel model) {
		SetReviewController.model = model;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		SetReviewController.panel = panel;
	}
	
}
