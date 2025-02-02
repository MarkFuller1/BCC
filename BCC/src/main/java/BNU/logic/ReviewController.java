package BNU.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.models.ReviewModel2;
import BNU.logic.PageController;
import BNU.presentation.ReviewView;

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
		for(Integer i = 0; i <= model.getCount(); i++) {
			if(e.getActionCommand().contentEquals("m"+i.toString())) {
				System.out.println("message button" + i.toString() + "pressed");
				this.getTc().message(i);
			}
			else if(e.getActionCommand().contentEquals("d"+i.toString())) {
				System.out.println("downvote button" + i.toString() + "pressed");
				try {
					this.getTc().down(i);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getActionCommand().contentEquals("u"+i.toString())) {
				System.out.println("upvote button" + i.toString() + "pressed");
				try {
					this.getTc().up(i);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
      else if(e.getActionCommand().contentEquals("f"+i.toString())) {
				System.out.println("flag button" + i.toString() + "pressed");
				this.getTc().flag(model.getRID());
			}
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
