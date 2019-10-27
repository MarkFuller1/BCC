package com.BNU.windowbuilder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.BNU.database.DatabaseMock;
import com.BNU.database.dbWrapper;
import com.BNU.pages.PageController;
import com.BNU.pages.login.LoginController;

public class WindowBuilder {

	private static JFrame mainFrame;
	private static dbWrapper db;
	private final static Logger LOGGER = Logger.getLogger(WindowBuilder.class.getName());

	public WindowBuilder() throws Exception {
		FileHandler fileHandler = new FileHandler("BCC.log", true);
		LOGGER.addHandler(fileHandler);

		LOGGER.info("Building database");
		db = new DatabaseMock();

		LOGGER.info("Building JFrame");
		// build the JFrame
		mainFrame = new JFrame("BCC");
		// TODO: change this to SaveDatabase() on close
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null); // all components determine position absolutely
		mainFrame.setSize(1100, 700);
		mainFrame.setResizable(false);
		try {
			addFavicon();
		} catch (IOException e) {
			// TODO: replace with logger
			LOGGER.info("Favicon Failed To Load");
		}
		mainFrame.setVisible(true);

		// now that the frame has been built, show the first pane.
		loadPage(new LoginController());
	}

	private void addFavicon() throws IOException {
		LOGGER.finest("Loading favicon");
		BufferedImage image = ImageIO.read(new File("resources" + File.separator + "favicon1.png"));
		mainFrame.setIconImage(image);
	}

	public static void loadPage(PageController pageName) throws Exception {
		pageName.dispatchBuilder(mainFrame, db);
	}
}
