/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Volunteers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.events.StartElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Andrei
 */
public class XMLSAXVolunteerHandler extends DefaultHandler{
    // One Volunteer
    private Volunteer vol;
      
    //List of Volunteer
    private List<Volunteer> volList;
    private String currentElement = "";
    private StringBuilder currentText;

    //getter method for volunteers list
    public List<Volunteer> readDataFromXML(String filename) throws SAXException, IOException, ParserConfigurationException  
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true); 
        SAXParser parser = factory.newSAXParser();
        
        parser.parse(new File(filename), this);
        
        return volList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
        volList = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
         System.out.println("End document");
    }
 
     
    @Override
    public void startElement(String uri, String localName, String nodeName, Attributes attributes) throws SAXException 
    {
        System.out.println("Start element:" + nodeName);
        currentElement = localName;
        
        switch(currentElement){
            case "Volunteers": 
                break;
            case "Volunteer":
                vol = new Volunteer();
                String id = attributes.getValue("id");
                System.out.println("este ceva aicssssssssssssssssi  " + id);
                vol.setId(Integer.parseInt(id)); 
                volList.add(vol);  
                break;
            default: 
                currentText = new StringBuilder();
                break;
                
        }
         
    }
     
     @Override
    public void endElement(String uri, String localName, String nodeName) throws SAXException 
    {
//        System.out.println("End element:" + nodeName);
        
        if (currentElement.equals("Volunteers")||currentElement.equals("Volunteer")) {
            return;
        }
        String content = currentText.toString();
        
        switch(currentElement){
            case Volunteer.FNAME:
                vol.setFirstName(content);
                break;
                
            case Volunteer.LNAME:
                vol.setLastName(content);
                break; 
            case Volunteer.ADDRESS:
                vol.setAddress(content);
                break;
            case Volunteer.ZIP:
                vol.setZip(content);
                break;
            case Volunteer.CITY:
                vol.setCity(content);
                break;
            case Volunteer.PHONE:
                vol.setPhone(content);
                break;
            case Volunteer.EMAIL:
                vol.setEmail(content);
                break;
            case Volunteer.BIRTHDAY:
                vol.setBirthday(content);
                break;   
                
            case Volunteer.ABOUT:
                vol.setAbout(content);
                break; 
            default:
                break;
        }
        currentElement = "";
         
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException 
    {
        if(currentText != null){
            currentText.append(ch, start, length);
        }
         
    }
    
}
