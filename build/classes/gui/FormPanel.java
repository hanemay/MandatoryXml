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
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class FormPanel  extends JPanel implements ActionListener{
        private final gui.ManinPanel userInterface;
	// define the elements
	private final JLabel nameLabel;
	private final JLabel occupationLabel;
	private final JTextField nameField;
	private final JTextField occupationField;
        private String XSDLocation;
        private String XMLLocation;
	private final JButton okBtn;
        private final JButton btnGetXML;
        private final JButton btnDomValidate;
//	private FormListener formListener;
	private final JList ageList;
	private final JComboBox empCombo;
	private final JCheckBox citizenCheck;
	private final JTextField taxField;
	private final JLabel taxLabel;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
        private String filename;
        private final JButton btnSearch;
        private final JLabel lblSearch;
        private final JTextField searchString;

	public FormPanel(gui.ManinPanel userInterface) throws SAXException, IOException, ParserConfigurationException {
            // configure the form panel dimension
            this.userInterface = userInterface;
            Dimension dim = getPreferredSize();
            dim.width = 300;
            setPreferredSize(dim);
            setMinimumSize(dim);

            // initiate the variables
            nameLabel = new JLabel("File Name: ");
            lblSearch = new JLabel("Search");
            occupationLabel = new JLabel("Occupation: ");
            nameField = new JTextField(15);
            occupationField = new JTextField(5);
            ageList = new JList();
            empCombo = new JComboBox();
            citizenCheck = new JCheckBox();
            taxField = new JTextField(5);
            taxLabel = new JLabel("Tax ID: ");
            btnGetXML = new JButton("Choose File");
            btnDomValidate = new JButton("Validate XML");
            okBtn = new JButton("OK");
            okBtn.setActionCommand("ok");
            btnSearch = new JButton("Search");
            searchString = new JTextField(20);
            Border innerBorder = BorderFactory.createTitledBorder("Add XML");
            Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
            layoutComponents();
	}
   
	private void layoutComponents() {
            setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();
           
            
//            // ////////////First row ///////////////////
//            gc.gridy = 0;
//
//            gc.weightx = 1;
//            gc.weighty = 0.1;
//
//            gc.gridx = 0;
//            gc.fill = GridBagConstraints.NONE;
//            gc.anchor = GridBagConstraints.LINE_END;
//            gc.insets = new Insets(0, 0, 0, 5);
//            add(new JLabel("Validate XML: "), gc);
//
//            gc.gridx = 1;
//            gc.gridy = 0;
//            gc.anchor = GridBagConstraints.LINE_START;
//            gc.insets = new Insets(0, 0, 0, 0);
//              
//            add(btnDomValidate, gc); 
//            
//            // ///////////Second row ///////////////////
//            gc.gridy++;
//
//            gc.weightx = 1;
//            gc.weighty = 0.1;
//
//            gc.gridx = 0;
//            gc.insets = new Insets(0, 0, 0, 5);
//            gc.anchor = GridBagConstraints.LINE_END;
//            add(new JLabel("XML to OBJ: "), gc);
//
//            gc.gridx = 1;
//            gc.insets = new Insets(0, 0, 0, 0);
//            gc.anchor = GridBagConstraints.LINE_START;
//            add(btnXMLtoOBJ, gc);
//
//            // ///////////Next row ///////////////////
//            gc.gridy++;
//
//            gc.weightx = 1;
//            gc.weighty = 0.1;
//
//            gc.gridx = 0;
//            gc.insets = new Insets(0, 0, 0, 5);
//            gc.anchor = GridBagConstraints.FIRST_LINE_END;
//            add(new JLabel("Get XML names by ID: "), gc);
//
//            gc.gridx = 1;
//            gc.anchor = GridBagConstraints.FIRST_LINE_START;
//            gc.insets = new Insets(0, 0, 0, 0);
//            add(btnNameById, gc);
//            
//            // ///////////Next row ///////////////////
//            gc.gridy++;
//
//            gc.weightx = 1;
//            gc.weighty = 0.1;
//
//            gc.gridx = 0;
//            gc.insets = new Insets(0, 0, 0, 5);
//            gc.anchor = GridBagConstraints.FIRST_LINE_END;
//            add(new JLabel("Get XML names: "), gc);
//
//            gc.gridx = 1;
//            gc.anchor = GridBagConstraints.FIRST_LINE_START;
//            gc.insets = new Insets(0, 0, 0, 0);
//            add(btnNames, gc);
//            
//            // ///////////Next row ///////////////////
//            gc.gridy++;
//
//            gc.weightx = 1;
//            gc.weighty = 0.1;
//
//            gc.gridx = 0;
//            gc.insets = new Insets(0, 0, 0, 5);
//            gc.anchor = GridBagConstraints.FIRST_LINE_END;
//            add(new JLabel("Get XML emails: "), gc);
//
//            gc.gridx = 1;
//            gc.anchor = GridBagConstraints.FIRST_LINE_START;
//            gc.insets = new Insets(0, 0, 0, 0);
//            add(btnEmails, gc);
//            
//            
            
            //i changed the layout here because im not familiar with gridbagview.
            setLayout(new FlowLayout());
//            add(okBtn);    
//            okBtn.addActionListener(this);
            gc.insets = new Insets(0, 0, 0, 15);
            add(btnGetXML); 
            gc.insets = new Insets(0, 0, 25, 25);
            btnGetXML.addActionListener(this);
            add(btnDomValidate); 
            btnDomValidate.addActionListener(this);
            add(lblSearch);
            add(searchString);
            add(btnSearch);
            btnSearch.addActionListener(this);
            
        }
        //@override actionperformed this is where our buttons gets called
        @Override
	public void actionPerformed(ActionEvent evt) {
            //instantiated object for easy object comparison
            Object src = evt.getSource();
            // increase the counter value
               // Display the counter value on the TextField tfCount
            System.out.println(evt.toString());
            //button for getting a xml file, location is stored in XMLLocation string and xsd is in XSDLocation
            if (src == btnGetXML) {
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                XSDLocation = fm.getXsdLocation();
            }
            //button for activating xsd xml validation
            if (src == btnDomValidate) {
                 XmlDom validate = new XmlDom();
                userInterface.setText(validate.XMLValidate(XMLLocation, XSDLocation));
                try {
                    userInterface.setText(validate.PrintDom(XMLLocation));
                } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //button for activating xml parsing
            if(src == okBtn){
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
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
