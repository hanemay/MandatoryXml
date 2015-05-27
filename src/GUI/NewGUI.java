/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Volunteers.Volunteer;
import Volunteers.XMLSAXVolunteerHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Andrei
 */
public class NewGUI extends JFrame{
    
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
        private FormPanel formPanel;
        private JTabbedPane tabPane;
        private JSplitPane splitPane;
        
        
    
        public NewGUI() throws SAXException, IOException, ParserConfigurationException{
            super("Hello World"); // the name of the panel
             setLayout(new BorderLayout());
            
            textPanel = new TextPanel();
            tabPane = new JTabbedPane();
            formPanel = new FormPanel(this);
            
            tabPane.add("Message", textPanel); 
            splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabPane);
            
            // add components to the GUI 
//            add(tabPane, BorderLayout.CENTER);
            add(splitPane, BorderLayout.CENTER);
            
//            String filename = "resources/Volunteer.xml";
//            XMLtoOBJ(filename);
           // OBJtoXML(filename, textPanel);
            
            // configure the GUI panel
            setMinimumSize(new Dimension(600, 500));
            setSize(600, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
        }
      

    public void XMLtoOBJ(String filename) throws SAXException, IOException, ParserConfigurationException {
        XMLSAXVolunteerHandler saxHandler = new XMLSAXVolunteerHandler();
        List<Volunteer> volList = saxHandler.readDataFromXML(filename);
        System.out.println("nr 0f volunteers:" + volList.size());     
        for(Volunteer vol : volList) {
                textPanel.appendText(vol.toString()+"\n");
        }
    }         

    
}
