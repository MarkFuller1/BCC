package BNU.logic;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.SetReviewModel;
import BNU.presentation.SetReviewView;

public class SetReviewController extends PageController{
	static SetReviewView view;
	static SetReviewModel model = new SetReviewModel();
	static JPanel panel;
	
	public SetReviewController(){
		model = new SetReviewModel();
		panel = new JPanel();
		view = new SetReviewView();
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		try {
			SetReviewView.BuildSetReviewView(mainFrame, this);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "SetReview:Submit"){
			System.out.println("SetReview:Submit button pressed");
			// update the data
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
