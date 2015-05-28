/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volunteers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrei
 */
public class JAXBVolunteer {
    public static void main(String[] args) {
        
        File myxmlfile = new File("jaxbVolunteer.xml");  
        Volunteer vol1 = new Volunteer(1, "Costin", "Ioana", "Dalslangdsgade", "2211", "Copenhagen", "22332211", "andreeaioana@ymail.com", "24/06/1993", "Cea mai fumoasa fata");
        
        //jaxbm + tab
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Volunteer.class);
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            marshaller.marshal(vol1, System.out);
            marshaller.marshal(vol1, myxmlfile);
            
            
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        
        //jaxbu +tab 
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Volunteer.class);
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            vol1 = (Volunteer) unmarshaller.unmarshal(new java.io.File("jaxbVolunteer.xml")); //NOI18N
             
            System.out.println(vol1.toString());
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        
    }
        
}
