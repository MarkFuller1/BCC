package BNU.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import BNU.data.ReviewModel2;
import BNU.data.dbWrapper;
import BNU.presentation.ReviewView;

public class ReviewController implements ActionListener {
	 ReviewView view;
	 ReviewModel2 model;
	 JPanel panel;
	 dbWrapper db;
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




	public dbWrapper getDb() {
		return db;
	}




	public void setDb(dbWrapper db) {
		this.db = db;
	}




	public TeacherReviewController getTc() {
		return tc;
	}




	public void setTc(TeacherReviewController tc) {
		this.tc = tc;
	}




	public void actionPerformed(ActionEvent e) {
		for(Integer i = 0; i < model.getCount()+1; i ++) {
			if(e.getActionCommand().contentEquals("m"+i.toString())){
				System.out.println("Review:message" + i.toString() + " button pressed");
				this.getTc().message(i);
			}
			else if(e.getActionCommand().contentEquals("d"+i.toString())) {
				System.out.println("Review:downvote" + i.toString() + " button pressed");
				this.getTc().down(i);
			}
			else if(e.getActionCommand().contentEquals("u"+i.toString())) {
				System.out.println("Review:upvote" + i.toString() + " button pressed");
				this.getTc().up(i);
			}
		}
		
	}
	

	public void dispatchBuilder() {
		try {
			this.getView().BuildReviewView(this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
