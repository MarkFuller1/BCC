package refactor.these;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.UserReviewModel;
import BNU.data.dbWrapper;
import BNU.logic.MessageBoardController;
import BNU.logic.PageController;
import BNU.logic.WindowBuilder;
import BNU.presentation.UserReviewView;

public class ReviewController implements ActionListener {
	static ReviewView view;
	static ReviewModel2 model = new ReviewModel2();
	static JPanel panel;
	static dbWrapper db;
	
	public ReviewController() {
		model = new ReviewModel2();
		panel = new JPanel();
		view = new ReviewView();
	}


	public static ReviewView getView() {
		return view;
	}

	public static void setView(ReviewView view) {
		ReviewController.view = view;
	}

	public static ReviewModel2 getModel() {
		return model;
	}

	public static void setModel(ReviewModel2 model) {
		ReviewController.model = model;
	}

	public static JPanel getPanel() {
		return panel;
	}


	public static void setPanel(JPanel panel) {
		ReviewController.panel = panel;
	}


	public static dbWrapper getDb() {
		return db;
	}

	public static void setDb(dbWrapper db) {
		ReviewController.db = db;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Review:message"){
			System.out.println("Review:message button pressed");
			WindowBuilder.loadPage(new MessageBoardController());
		}
		else if(e.getActionCommand() == "Review:downvote") {
			//up the vote in the database
		}
		else if(e.getActionCommand() == "Review:upvote") {
			//up the vote in the database
		}
	}

	public void dispatchBuilder() {
		try {
			ReviewView.BuildReviewView(this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
