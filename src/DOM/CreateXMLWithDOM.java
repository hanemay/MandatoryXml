/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOM;

import Volunteers.Volunteer;
import Volunteers.XMLSAXVolunteerHandler;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Andrei
 */
public class CreateXMLWithDOM {
    
    
    public static void main(String [] args) throws ParserConfigurationException, SAXException, IOException{
        
        String filename = "resources/Volunteer.xml";
            
        XMLSAXVolunteerHandler saxHandler = new XMLSAXVolunteerHandler();
        List<Volunteer> volList = saxHandler.readDataFromXML(filename);
        
        
        
        
        DOMCreator creator = new DOMCreator();
        Document doc = creator.createXMLDoc(volList);
        
        System.out.println(doc.toString());
        
        Node root = doc.getFirstChild();
        System.out.println(root.getNodeName());
        
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node child = nodes.item(i);
            System.out.println(child.getNodeName());
            System.out.println(child.getTextContent());
        }
    }
}
