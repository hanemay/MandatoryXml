package gui;


import services.FileManager;
import services.XmlDom;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class FormPanel  extends JPanel implements ActionListener{
        private final gui.ManinPanel userInterface;
	// define the elements 
        private String XSDLocation;
        private String XMLLocation;
	private final JButton btnXMLtoObj;
        private final JButton btnGetXML;
        private final JButton btnDomValidate;    
        private final JButton btnSearch; 
        private final JTextField searchString;

	public FormPanel(gui.ManinPanel userInterface) throws SAXException, IOException, ParserConfigurationException {
            // configure the form panel dimension
            this.userInterface = userInterface;
            Dimension dim = getPreferredSize();
            dim.width = 500;
            setPreferredSize(dim);
            setMinimumSize(dim);

            // initiate the variables  
            btnGetXML = new JButton("Choose File");
            btnDomValidate = new JButton("Choose file");
            btnXMLtoObj = new JButton("Choose File"); 
            btnSearch = new JButton("Search");
            searchString = new JTextField(20);
            
            Border innerBorder = BorderFactory.createTitledBorder("Add XML");
            Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder)); 
            
            btnSearch.addActionListener(this);
            btnDomValidate.addActionListener(this);
            btnGetXML.addActionListener(this);
            btnXMLtoObj.addActionListener(this); 
            
            layoutComponents(); 
	}
   
	private void layoutComponents() {
            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints(); 
            // ////////////First row ///////////////////
            gc.gridy = 0;

            gc.weightx = 1;
            gc.weighty = 0.1;

            gc.gridx = 0;
            gc.fill = GridBagConstraints.NONE;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.insets = new Insets(0, 0, 0, 5);
            add(new JLabel("Validate XML: "), gc);

            gc.gridx = 1;
            gc.gridy = 0;
            gc.anchor = GridBagConstraints.LINE_START;
            gc.insets = new Insets(0, 0, 0, 0);
              
            add(btnDomValidate, gc); 
            
            // ///////////Next row ///////////////////
            gc.gridy++;

            gc.weightx = 1;
            gc.weighty = 0.1;

            gc.gridx = 0;
            gc.insets = new Insets(0, 0, 0, 5);
            gc.anchor = GridBagConstraints.FIRST_LINE_END;
            add(new JLabel("XML to Obj: "), gc);

            gc.gridx = 1;
            gc.anchor = GridBagConstraints.FIRST_LINE_START;
            gc.insets = new Insets(0, 0, 0, 0);
            add(btnXMLtoObj, gc);  
            
            // ///////////Second row ///////////////////
            gc.gridy++;

            gc.weightx = 1;
            gc.weighty = 0.1;

            gc.gridx = 0;
            gc.insets = new Insets(0, 0, 0, 5);
            gc.anchor = GridBagConstraints.LINE_END;
            add(new JLabel("Xpath: "), gc);

            gc.gridx = 1;
            gc.insets = new Insets(0, 0, 0, 0);
            gc.anchor = GridBagConstraints.LINE_START;
            add(searchString, gc);

            // ///////////Next row ///////////////////
            gc.gridy++;

            gc.weightx = 1;
            gc.weighty = 0.1;

            gc.gridx = 0;
            gc.insets = new Insets(0, 0, 0, 5);
            gc.anchor = GridBagConstraints.FIRST_LINE_END;
            add(new JLabel("  "), gc);

            gc.gridx = 1;
            gc.anchor = GridBagConstraints.FIRST_LINE_START;
            gc.insets = new Insets(0, 0, 0, 0);
            add(btnSearch, gc);
            
            
            
        }
        //@override actionperformed this is where our buttons gets called
        @Override
	public void actionPerformed(ActionEvent evt) {
            //instantiated object for easy object comparison
            Object src = evt.getSource();
            // increase the counter value
            // Display the counter value on the TextField tfCount
            System.out.println(evt.toString()); 
            
            //button for activating xsd xml validation
            if (src == btnDomValidate) {
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                XSDLocation = fm.getXsdLocation();
                 XmlDom validate = new XmlDom();
                userInterface.setText(validate.XMLValidate(XMLLocation, XSDLocation));
                try {
                    userInterface.setText(validate.PrintDom(XMLLocation));
                } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //button for activating xml parsing
            if(src == btnXMLtoObj){
               FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                //fileNameLabel.setText(XMLLocation);
                userInterface.setText("");
                try {
                    userInterface.XMLtoOBJ(XMLLocation);
                } catch (SAXException | IOException | ParserConfigurationException ex) {
                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(src == btnSearch){
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                XmlDom validate = new XmlDom();
                try {
                    userInterface.setText(validate.SearchDomFile(XMLLocation, searchString.getText()));
                } catch (SAXException | IOException | ParserConfigurationException | TransformerException | XPathExpressionException ex) {
                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }         
} 
