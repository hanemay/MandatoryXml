package gui;
import gui.NewGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
                            try {
                                ///GUI.NewGUI();
                                NewGUI newGUI = new gui.NewGUI();
                            } catch (SAXException ex) {
                                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ParserConfigurationException ex) {
                                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                            } 
			}
		}); 
	}

}
