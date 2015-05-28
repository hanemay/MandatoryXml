/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author hanemay
 */
public class XmlDom {
    String returnText;
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
            return "The Files " + xmlFile + " " + xsdFile + " ran through succesfully";
    }
    public String PrintDom(String xmlFile) throws SAXException, IOException, ParserConfigurationException, TransformerException{
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder Parser = builderFactory.newDocumentBuilder();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Document doc = Parser.parse(new InputSource(xmlFile));
        Source source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result); 
        return writer.toString();
    }
    public String SearchDomFile(String xmlFile, String searchString)throws SAXException, IOException, ParserConfigurationException, TransformerException, XPathExpressionException{
        String results = "";
        if(checkForSlash(searchString) == false){
           // String tempSearchString = searchString;
            searchString = "/"+searchString;
        }
        System.out.println(searchString);
        FileInputStream file = new FileInputStream(new File(xmlFile));                 
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();             
        DocumentBuilder builder =  builderFactory.newDocumentBuilder();             
        Document xmlDocument = builder.parse(file); 
        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = searchString;
        System.out.println(expression);
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            results = nodeList.item(i).getFirstChild().getNodeValue(); 
        }
        return results;
    }
    public boolean checkForSlash(String searchString){
        if(searchString.substring(0, 0).equals("/")){
            return true;
        }else{
            return false;
        }       
    }
}
