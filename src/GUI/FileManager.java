/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextField;

/**
 *
 * @author hanemay
 */
public class FileManager {
    public String FileName;
    private String XSDLocation;
    private String XMLLocation;
    public FileManager(){
        Frame awtPanel = new Frame();
        FileDialog xmlFile = new FileDialog(awtPanel, "Choose xml file", FileDialog.LOAD);
        String currentDir = xmlFile.getDirectory();
        xmlFile.setDirectory(currentDir);
        xmlFile.setVisible(true);
        FileName = xmlFile.getFile();
        currentDir = xmlFile.getDirectory();
        XMLLocation = currentDir + FileName;
        System.out.println(FileName);   
        String xsdName = RemoveFileExtension(FileName);
        XSDLocation = currentDir + xsdName + "xsd"; 
    }
    public String getXsdLocation(){
        return XSDLocation;
    }
    public String RemoveFileExtension(String str) {
        str = str.substring(0, str.length() - 3);
        return str;
    }
    public String getXmlLocation(){
        return XMLLocation;         
    }
}
