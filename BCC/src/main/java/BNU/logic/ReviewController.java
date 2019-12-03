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
	 ReviewView view;
	 ReviewModel2 model = new ReviewModel2();
	 JPanel panel;
	 TeacherReviewController tc;
	
	public ReviewController() {
		model = new ReviewModel2(); 
		panel = new JPanel();
		view = new ReviewView();
	}

	public ReviewView getView() {
		return view;
	}


	public void setView(ReviewView view) {
		this.view = view;
	}
	public ReviewModel2 getModel() {
		return model;
	}

	public void setModel(ReviewModel2 model) {
		this.model = model;
	}


	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public TeacherReviewController getTc() {
		return tc;
	}

	public void setTc(TeacherReviewController tc) {
		this.tc = tc;
	}

	public void actionPerformed(ActionEvent e) {
		for(Integer i = 0; i < model.getCount(); i++) {
			if(e.getActionCommand().contentEquals("m"+i.toString())) {
				System.out.println("message button" + i.toString() + "pressed");
				this.getTc().message(i);
			}
			else if(e.getActionCommand().contentEquals("d"+i.toString())) {
				System.out.println("downvote button" + i.toString() + "pressed");
				this.getTc().down(i);
			}
			else if(e.getActionCommand().contentEquals("u"+i.toString())) {
				System.out.println("upvote button" + i.toString() + "pressed");
				this.getTc().up(i);
			}
			else if(e.getActionCommand().contentEquals("f"+i.toString())) {
				System.out.println("flag button" + i.toString() + "pressed");
				//flag function 
			}
		}
	}
	public void dispatchBuilder(String content, String score, String reviewerID) {
		try {
			ReviewView.BuildReviewView(this, content, score, reviewerID);
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
