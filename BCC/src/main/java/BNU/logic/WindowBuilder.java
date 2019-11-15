package BNU.logic;

import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import BNU.data.DatabaseApi;
import BNU.data.DatabaseMock;
import BNU.data.dbWrapper;

public class WindowBuilder {
	
	public static JFrame mainFrame;
	private static dbWrapper db;
	public static Clip clip; 
	public static File deck; 
	
	public WindowBuilder() {
		db = new DatabaseApi();
		//build the JFrame 
		mainFrame = new JFrame("BCC");
		//TODO: change this to SaveDatabase() on close 
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null); //all components determine position absolutely
		mainFrame.setSize(1000, 800);
		mainFrame.setResizable(false);
		try {
			addFavicon();
		} catch (IOException e) {
			//TODO: replace with logger
			System.out.println("Favicon failed to load");
		}
		mainFrame.setVisible(true);
		
		//now that the frame has been built, show the first pane.
		this.loadPage(new LoginController());
	}
	
	private void addFavicon() throws IOException {
		 BufferedImage image = ImageIO.read(new File("resources" + File.separator + "favicon1.png"));
         mainFrame.setIconImage(image);
	}

	public static void loadPage(PageController pageName) {
		pageName.dispatchBuilder(mainFrame, db);
	}
}
