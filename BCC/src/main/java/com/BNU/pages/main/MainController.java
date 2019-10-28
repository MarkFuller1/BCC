package com.BNU.pages.main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.classesByTeacher.ClassByTeacherController;
import com.BNU.pages.login.LoginController;
import com.BNU.pages.message_board.MessageBoardController;
import com.BNU.pages.teachersByClass.TeachersByClassController;
import com.BNU.windowbuilder.WindowBuilder;

public class MainController extends PageController {

	static MainView view;
	static MainModel model = new MainModel();
	static JPanel panel;
	static dbWrapper db;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

	public MainController() {
		model = new MainModel();
		panel = new JPanel();
		view = new MainView();
		db = new DatabaseMock();
	}

	@Override
	public void dispatchBuilder(JFrame mainFrame, dbWrapper db) {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("BCC.log", true);
		} catch (SecurityException | IOException e) {
			System.out.println("Logger Failed");
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("Login page loaded correctly");

		
		MainView.BuildLoginView(mainFrame, this);
	}

	public static dbWrapper getDb() {
		return db;
	}

	public static void setDb(DatabaseMock db) {
		MainController.db = db;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		MainController.panel = panel;
	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		MainController.view = view;
	}

	public MainModel getModel() {
		return model;
	}

	public void setModel(MainModel model) {
		MainController.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "main:searchProfessor") {
			String selected = (String) this.getModel().getCb_SearchProfessor().getSelectedItem();
			LOGGER.info("main:searchProfessor Button Pressed + Selected:" + selected);
			WindowBuilder.loadPage(new ClassByTeacherController(selected));
		} else if (e.getActionCommand() == "main:searchClass") {
			String selected = (String) this.getModel().getCb_SearchClass().getSelectedItem();
			System.out.println("main:searchClass Button Pressed + Selected:" + selected);
			WindowBuilder.loadPage(new TeachersByClassController(selected));
		}else if (e.getActionCommand() == "main:message" ) {
			LOGGER.info("main:message");
			WindowBuilder.loadPage(new MessageBoardController());
		}

	}

}
