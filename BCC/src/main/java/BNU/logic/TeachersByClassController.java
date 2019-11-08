package BNU.logic;

import java.awt.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.DatabaseMock;
import BNU.data.TeachersByClassModel;
import BNU.data.dbWrapper;
import BNU.presentation.TeachersByClassView;


public class TeachersByClassController extends PageController {

	static TeachersByClassView view;
	static TeachersByClassModel model = new TeachersByClassModel();
	static JPanel panel;
	static dbWrapper db;
	private static final Logger LOGGER = Logger.getLogger(TeachersByClassController.class.getName());

	public String className;

	public TeachersByClassController(String selectedClass) {
		/* make database request to get the professors who teach that class */

		model = new TeachersByClassModel();
		panel = new JPanel();
		view = new TeachersByClassView();
		db = new DatabaseMock();
		this.className = selectedClass;

		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException | IOException e) {
			System.out.println("Logger Failed to init");
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);

	}

	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		TeachersByClassView.BuildTeachsersByClassView(mainFrame, this);
	}

	public TeachersByClassView getView() {
		return view;
	}

	public void setView(TeachersByClassView view) {
		TeachersByClassController.view = view;
	}

	public TeachersByClassModel getModel() {
		return model;
	}

	public void setModel(TeachersByClassModel model) {
		TeachersByClassController.model = model;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		TeachersByClassController.panel = panel;
	}

	public dbWrapper getDb() {
		return db;
	}

	public void setDb(dbWrapper db) {
		TeachersByClassController.db = db;
	}

	public String getClassName() {
		return className;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().contains("teacherList:")) {
			LOGGER.info("main:searchProfessor Button Pressed");
			String teacherSelected = e.getActionCommand();
			teacherSelected = teacherSelected.substring(12);
			LOGGER.info("The teacher selected was: " + teacherSelected);
			WindowBuilder.loadPage(new TeacherReviewController(teacherSelected, this.className));
		}
	}
}
