package BNU.logic;

import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.database.AbstractDB;
import BNU.data.models.TeacherReviewModel;
import BNU.presentation.TeacherReviewView;
import BNU.singleton.SingletonSession;

public class TeacherReviewController extends PageController{
	static TeacherReviewView view;
	static TeacherReviewModel model = new TeacherReviewModel();
	static JPanel panel;
	String teacherName;
	String className;
	
	public TeacherReviewController(String teacherName, String className){ 
		model = new TeacherReviewModel();
		panel = new JPanel();
		view = new TeacherReviewView();
		this.teacherName = teacherName;
		this.className = className;
	}
	
	@Override
	public void dispatchBuilder(JFrame mainFrame) {
		try {
			TeacherReviewView.BuildTeacherReviewView(mainFrame, this);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static AbstractDB getDb() {
		return db;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		TeacherReviewController.panel = panel;
	}
	
	public TeacherReviewView getView() {
		return view;
	}

	public void setView(TeacherReviewView view) {
		TeacherReviewController.view = view;
	}

	public TeacherReviewModel getModel() {
		return model;
	}

	public void setModel(TeacherReviewModel model) {
		TeacherReviewController.model = model;
	}
	
	public void up(int n) throws SQLException {
		if(db.isUpvoteValid(this.getModel().getRC().get(n).getModel().getRID(),  SingletonSession.getInstance().getUserName())){
			db.upvote(this.getModel().getRC().get(n).getModel().getRID(), SingletonSession.getInstance().getUserName());
			int total = this.getModel().getRC().get(n).getModel().getScores();
			total ++;
			this.getModel().getRC().get(n).getModel().setScores(total);
			this.getModel().getRC().get(n).getModel().getReviewScore().setText(this.getModel().getRC().get(n).getModel().getScores().toString());
			this.getModel().getRC().get(n).getPanel().repaint();
		}
	}
	public void down(int n) throws SQLException {
		if(db.isUpvoteValid(this.getModel().getRC().get(n).getModel().getRID(), SingletonSession.getInstance().getUserName())){
			db.downvote(this.getModel().getRC().get(n).getModel().getRID(), SingletonSession.getInstance().getUserName());
			int total = this.getModel().getRC().get(n).getModel().getScores();
			total --;
			this.getModel().getRC().get(n).getModel().setScores(total);
			this.getModel().getRC().get(n).getModel().getReviewScore().setText(this.getModel().getRC().get(n).getModel().getScores().toString());
			this.getModel().getRC().get(n).getPanel().repaint();
		}
	}
	public void message(int n) {
		Long l = System.currentTimeMillis();
		BigInteger i = new BigInteger(l.toString());
		db.sendMessage("", SingletonSession.getInstance().getUserName(), this.getModel().getRC().get(n).getModel().getRID(),i);
		WindowBuilder.loadPage(new MessageBoardController());
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "teacher_review:back"){
			System.out.println("teacher_review:back button pressed");
			WindowBuilder.loadPage(new MainController());
		}else if(e.getActionCommand() == "teacher_review:add"){
			System.out.println("teacher_review:add Review button pressed");
			WindowBuilder.loadPage(new SetReviewController(this.teacherName, this.className));
		}
}

}
