/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import services.Volunteer;
import services.SaxXML;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Andrei
 */
public class ManinPanel extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JTabbedPane tabPane;
    private JSplitPane splitPane; 
    
    public ManinPanel() throws SAXException, IOException, ParserConfigurationException{
        super("System Integration Mandatory"); // the name of the panel
        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        tabPane = new JTabbedPane();
        formPanel = new FormPanel(this);

        tabPane.add("Message", textPanel); 
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabPane);
        add(splitPane, BorderLayout.CENTER); 

        // configure the GUI panel
        setMinimumSize(new Dimension(600, 500));
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setText(String text){
        textPanel.addText(text);
    } 

   public void XMLtoOBJ(String filename) throws SAXException, IOException, ParserConfigurationException {
        SaxXML saxHandler = new SaxXML();
        List<Volunteer> volList = saxHandler.readDataFromXML(filename);      
        for(Volunteer vol : volList) {
                textPanel.appendText(vol.toString()+"\n");
        }
    }  

    
}
