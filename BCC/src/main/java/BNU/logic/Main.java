package BNU.logic;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * This is main, it will call the windowbuilder constructor that will build the JFrame
 */
public class Main 
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        System.out.println( "In Main.Java!" );
        //we need this but not THIS -> UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        WindowBuilder window = new WindowBuilder();
    }
}
