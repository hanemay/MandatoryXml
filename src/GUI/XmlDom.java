/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

/**
 *
 * @author hanemay
 */
public class XmlDom {
    
    public XmlDom(){
       
    }
    public String XMLValidate(String xmlFile, String xsdFile){            
            File myxmlfile = new File(xmlFile);
            File myschemafile = new File(xsdFile);
            Schema schema = null;
            try {
                String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
                SchemaFactory factory = SchemaFactory.newInstance(language);
                schema = factory.newSchema(myschemafile);
                // Parse the XML document to DOM Document, and then validate it
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document doc = builder.parse(myxmlfile);
                DOMSource source = new DOMSource(doc);
                Validator validator = schema.newValidator();
                validator.validate(source);
            } catch (Exception e) {
                e.printStackTrace();
                return "Ups.... Something went wrong :-(";          
            }
            return "SUCCES";
    }
}
