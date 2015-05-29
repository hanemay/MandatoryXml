package gui;
import gui.ManinPanel;
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
                                ///GUI.ManinPanel();
                                ManinPanel newGUI = new gui.ManinPanel();
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
