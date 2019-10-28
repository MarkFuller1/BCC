package com.BNU.pages.teachersByClass;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;
import com.BNU.windowbuilder.WindowBuilder;

public class TeachersByClassController extends PageController{

	static TeachsersByClassView view;
	static TeachsersByClassModel model = new TeachsersByClassModel();
	static JPanel panel;
	static dbWrapper db;
	private static final Logger LOGGER = Logger.getLogger(TeachersByClassController.class.getName());
	
	public TeachersByClassController(String selectedClass) {
		/*make database request to get the professors who teach that class */
		
		model = new TeachsersByClassModel();
		panel = new JPanel();
		view = new TeachsersByClassView();
		db = new DatabaseMock();
		
		model.setProfessors(new ArrayList<String>(Arrays.asList(db.getAllProfessorsForClass(selectedClass))));
		
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
		TeachsersByClassView.BuildTeachsersByClassView(mainFrame, this);
	}
	
	public TeachsersByClassView getView() {
		return view;
	}

	public void setView(TeachsersByClassView view) {
		TeachersByClassController.view = view;
	}

	public TeachsersByClassModel getModel() {
		return model;
	}

	public void setModel(TeachsersByClassModel model) {
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

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "teacherList:selectProfessor"){
			LOGGER.info("main:searchProfessor Button Pressed");
			WindowBuilder.loadPage(new LoginController());
		}else if(e.getActionCommand() == "teacherList:selectProfessor"){
			LOGGER.info("main:searchClass Button Pressed");
			WindowBuilder.loadPage(new LoginController());
		}
	}
}
