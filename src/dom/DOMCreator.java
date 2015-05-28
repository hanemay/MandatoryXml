/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import volunteers.Volunteer;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Andrei
 */
public class DOMCreator {
 
    Document doc;
    public DOMCreator(){
        
    }
    public Document createXMLDoc(List<Volunteer> volList) throws ParserConfigurationException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            
            Element root = doc.createElement("volunteers");
            doc.appendChild(root);
             
            for (Volunteer vol : volList) {
                Element volElement = addElement(root, "volunteer", "");
                String idAsString = Integer.toString(vol.getId());
                volElement.setAttribute("id", idAsString);
                
                addElement(volElement, Volunteer.FNAME, vol.getFirstName());
                addElement(volElement, Volunteer.LNAME, vol.getLastName());
                addElement(volElement, Volunteer.ADDRESS, vol.getAddress());
                addElement(volElement, Volunteer.ZIP, vol.getZip());
                addElement(volElement, Volunteer.CITY, vol.getCity());
                addElement(volElement, Volunteer.PHONE, vol.getPhone());
                addElement(volElement, Volunteer.BIRTHDAY, vol.getBirthday());
                
                Element about = addElement(volElement, Volunteer.ABOUT, "");
                CDATASection cdata = doc.createCDATASection(vol.getAbout());
                about.appendChild(cdata);
            }
        return doc; 
    }
    
    private Element addElement(Element parent, String elementName, String textValue){
        Element childElement = doc.createElement(elementName);
        childElement.setTextContent(textValue);
        parent.appendChild(childElement);
        return childElement;
    }
}
