package BNU.logic;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.models.ReviewModel2;
import BNU.data.models.UserReviewModel;
import BNU.logic.MessageBoardController;
import BNU.logic.PageController;
import BNU.logic.WindowBuilder;
import BNU.presentation.ReviewView;
import BNU.presentation.UserReviewView;

public class ReviewController extends PageController implements ActionListener {
	static ReviewView view;
	static ReviewModel2 model = new ReviewModel2();
	static JPanel panel;
	//static dbWrapper db;
	
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


	public static AbstractDB getDb() {
		return db;
	}

//	public static void setDb(dbWrapper db) {
//		ReviewController.db = db;
//	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Review:message"){
			System.out.println("Review:message button pressed");
			WindowBuilder.loadPage(new MessageBoardController());
		}
		else if(e.getActionCommand() == "Review:downvote") {
			System.out.println("Review:downvote button pressed");
			//if(db.isDownvoteValid()) {
				//db.downvote();
				int total = this.getModel().getReviews().getVotes();
				total --;
				this.getModel().getReviews().setVotes(total);
				this.getModel().getReviewScore().setText(getModel().getReviews().getVotes().toString());
				this.getModel().getReviewScore().repaint();
			//}
			
			
		}
		else if(e.getActionCommand() == "Review:upvote") {
			System.out.println("Review:upvote button pressed");
			if(db.isUpvoteValid()) {
				//db.upvote();
			int total = getModel().getReviews().getVotes();
			total ++;
			getModel().getReviews().setVotes(total);
			getModel().getReviewScore().setText(getModel().getReviews().getVotes().toString());
			getModel().getReviewScore().repaint();
			}
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
	
	public void dispatchBuilder(String content, String score, String reviewerID, String reviewID) {
		try {
			//ReviewView.BuildReviewView(this);
			ReviewView.BuildReviewView(this, content, score, reviewerID, reviewID);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
