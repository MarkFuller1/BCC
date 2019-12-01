package BNU.logic;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BNU.data.ReviewModel2;
import BNU.data.UserReviewModel;
import BNU.data.dbWrapper;
import BNU.logic.MessageBoardController;
import BNU.logic.PageController;
import BNU.logic.WindowBuilder;
import BNU.presentation.ReviewView;
import BNU.presentation.UserReviewView;

public class ReviewController implements ActionListener {
	static ReviewView view;
	static ReviewModel2 model = new ReviewModel2();
	static JPanel panel;
	static dbWrapper db;
	static TeacherReviewController tc;
	
	public ReviewController() {
		model = new ReviewModel2();
		panel = new JPanel();
		view = new ReviewView();
	}

	public static TeacherReviewController getTc() {
		return tc;
	}
	public static void setTc(TeacherReviewController tc) {
		ReviewController.tc = tc;
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
		for(Integer i = 0; i < model.getCount(); i ++) {
			if(e.getActionCommand().contains("Review:message"+ i.toString())){
				System.out.println("Review:message" + i.toString() + " button pressed");
				this.getTc().message(i);
				
				
				
				//WindowBuilder.loadPage(new MessageBoardController());
			}
			else if(e.getActionCommand().contains("Review:downvote"+ i.toString())) {
				System.out.println("Review:downvote" + i.toString() + " button pressed");
				this.getTc().down(i);
				
				
				
				//if(db.isDownvoteValid()) {
					//db.downvote();
				
//						int total = this.getModel().getReviews().getVotes();
//						total --;
//						this.getModel().getReviews().setVotes(total);
//						this.getModel().getReviewScore().setText(this.getModel().getReviews().getVotes().toString());
//						this.getModel().getReviewScore().repaint();
				//}
				
				
			}
			else if(e.getActionCommand().contains("Review:upvote"+ i.toString())) {
				System.out.println("Review:upvote" + i.toString() + " button pressed");
				this.getTc().up(i);
				//if(db.isUpvoteValid()) {
					//db.upvote();
				
//						int total = this.getModel().getReviews().getVotes();
//						total ++;
//						this.getModel().getReviews().setVotes(total);
//						this.getModel().getReviewScore().setText(this.getModel().getReviews().getVotes().toString());
//						this.getModel().getReviewScore().repaint();
				//}
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
	
	
	
}
