/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

/**
 *
 * @author Andrei
 */
class TextPanel extends JPanel {
    public JTextArea textArea;
	
	public TextPanel(){
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String text){
		textArea.append(text);
                 
	}
        public void addText(String text){
            textArea.setText(text);
        }
}
