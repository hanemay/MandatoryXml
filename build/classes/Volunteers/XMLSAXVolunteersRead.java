/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Volunteers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Andrei
 */
public class XMLSAXVolunteersRead {
    public static void main (String [] args) throws SAXException, IOException, ParserConfigurationException{
        
            String filename = "resources/Volunteer.xml";
            
            XMLSAXVolunteerHandler saxHandler = new XMLSAXVolunteerHandler();
            List<Volunteer> volList = saxHandler.readDataFromXML(filename);
                        
            System.out.println("nr pf volunteers:" + volList.size());
            
            
            for (Volunteer vol : volList) {
                System.out.println(vol);
            
        }
            
    }
}
