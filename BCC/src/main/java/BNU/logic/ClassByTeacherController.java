package BNU.logic;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BNU.data.ClassByTeacherModel;
import BNU.data.DatabaseMock;
import BNU.data.dbWrapper;
import BNU.presentation.ClassByTeacherView;

public class ClassByTeacherController extends PageController{

	static ClassByTeacherView view;
	static ClassByTeacherModel model = new ClassByTeacherModel();
	static JPanel panel;
	private static final Logger LOGGER = Logger.getLogger(ClassByTeacherController.class.getName());
	
	public String professorName;
	public String selectedClass;
	
	public ClassByTeacherController(String professor) {
		/*make database request to get the professors who teach that class */
		
		model = new ClassByTeacherModel();
		panel = new JPanel();
		view = new ClassByTeacherView();
		//db = new DatabaseMock();
		this.professorName = professor;
		
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
	public void dispatchBuilder(JFrame mainFrame) {
		ClassByTeacherView.BuildTeachsersByClassView(mainFrame, this);
	}
	
	public ClassByTeacherView getView() {
		return view;
	}

	public void setView(ClassByTeacherView view) {
		ClassByTeacherController.view = view;
	}

	public ClassByTeacherModel getModel() {
		return model;
	}

	public void setModel(ClassByTeacherModel model) {
		ClassByTeacherController.model = model;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		ClassByTeacherController.panel = panel;
	}

	public dbWrapper getDb() {
		return db;
	}

//	public void setDb(dbWrapper db) {
//		ClassByTeacherController.db = db;
//	}
	public String getProfessorName() {
		return professorName;
	}

	public String getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contains("class:")){
			String classSelected = e.getActionCommand();
			classSelected = classSelected.substring(12);
			LOGGER.info("The class selected was: " + classSelected);
			WindowBuilder.loadPage(new TeacherReviewController(this.getProfessorName(), classSelected));
		}
	}
}
