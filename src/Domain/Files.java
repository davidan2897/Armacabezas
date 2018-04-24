package Domain;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Files {
    public void BuildTheFile() throws Exception  {
    
// 
//        try {
//            File fXmlFile = new File("c:\\file.xml");
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document document = (Document) dBuilder.newDocument();
//            Element elemento = (Element) document.createElement("Developer");
//            document.appendChild(document);
//            
//            Attr atribute = document.createAttribute("ID");
//            atribute.setValue("1");
//            elemento.setAttributeNode(atribute);
//            TransformerFactory  transformerFactory = TransformerFactory.newInstance();
//            Transformer  transformer= transformerFactory.newInstance();
//            DOMSource domSource = new DOMSource();
//            StreamResult streamResult = new StreamResult(new File("C:\\XML\\file.xml"));
//            transformer.transform(domSource, streamResult);
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
}