package GUI;
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
import org.xml.sax.SAXException;



public class FormPanel  extends JPanel implements ActionListener{
        private final GUI.NewGUI userInterface;
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

	public FormPanel(GUI.NewGUI userInterface) throws SAXException, IOException, ParserConfigurationException {
            // configure the form panel dimension
            this.userInterface = userInterface;
            Dimension dim = getPreferredSize();
            dim.width = 300;
            setPreferredSize(dim);
            setMinimumSize(dim);

            // initiate the variables
            nameLabel = new JLabel("File Name: ");
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
            Border innerBorder = BorderFactory.createTitledBorder("Add XML");
            Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
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
            add(nameLabel, gc);
            gc.gridx = 1;
            gc.gridy = 0;
            gc.anchor = GridBagConstraints.LINE_START;
            gc.insets = new Insets(0, 0, 0, 0); 
            add(nameField, gc);  
            // ///////////Next row ///////////////////
            gc.gridy++;
            gc.weightx = 1;
            gc.weighty = 2.0;
            gc.gridx = 1;
            gc.anchor = GridBagConstraints.FIRST_LINE_START;
            gc.insets = new Insets(0, 0, 0, 5);
            //i changed the layout here because im not familiar with gridbagview.
            setLayout(new FlowLayout());
            add(okBtn);    
            okBtn.addActionListener(this);
            gc.insets = new Insets(0, 0, 0, 15);
            add(btnGetXML); 
            gc.insets = new Insets(0, 0, 25, 25);
            btnGetXML.addActionListener(this);
            add(btnDomValidate); 
            btnDomValidate.addActionListener(this);
        }
        //@override actionperformed this is where our buttons gets called
        @Override
	public void actionPerformed(ActionEvent evt) {
            Object src = evt.getSource();
            // increase the counter value
               // Display the counter value on the TextField tfCount
            System.out.println(evt.toString());
            if (src == btnGetXML) {
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                XSDLocation = fm.getXsdLocation();
            }
            if (src == btnDomValidate) {
                 XmlDom validate = new XmlDom();
                 System.out.println(validate.XMLValidate(XMLLocation, XSDLocation));
            }
            if(src == okBtn){
                FileManager fm = new FileManager();
                XMLLocation = fm.getXmlLocation();
                try {
                    userInterface.XMLtoOBJ(XMLLocation);
                } catch (SAXException | IOException | ParserConfigurationException ex) {
                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }         
} 
