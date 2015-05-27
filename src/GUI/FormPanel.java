package GUI;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import GUI.NewGUI;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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



public class FormPanel extends JPanel{

	// define the elements
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
//	private FormListener formListener;
	private JList ageList;
	private JComboBox empCombo;
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;

	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
        private String filename;

	public FormPanel(GUI.NewGUI userInterface) throws SAXException, IOException, ParserConfigurationException {
		// configure the form panel dimension
               
		Dimension dim = getPreferredSize();
		dim.width = 250;
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
		okBtn = new JButton("OK");
		okBtn.setActionCommand("ok");
                
                
                
                
                
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if("ok".equals(e.getActionCommand())){
                                String filename = nameField.getText();
                                System.out.println("ok button works");
                               
                                try {
                                    userInterface.XMLtoOBJ("resources/" + filename +".xml");
                                } catch (SAXException ex) {
                                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ParserConfigurationException ex) {
                                    Logger.getLogger(FormPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            
                            }
                                 
			}       
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add XML");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();
	}

	public void layoutComponents() {

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
		add(okBtn, gc);
                
                
        }
        
        
} 
