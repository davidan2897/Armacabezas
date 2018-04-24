package Domain;


import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


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
    ArrayList<Imagenes> nombreArrayList = new ArrayList<Imagenes>();
    public void BuildTheFile() throws Exception  {
    
 
        try {
            File fXmlFile = new File("ImagesXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(fXmlFile);

            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("image");
 
       for (int temp = 0; temp < nList.getLength(); temp++) {
 
     Node nNode = nList.item(temp);
     if (nNode.getNodeType() == Node.ELEMENT_NODE) {
       
       
        Element eElement = (Element) nNode;
        String url =  getTagValue("URL", eElement);
        String nombre =  getTagValue("nombre", eElement);
        Imagenes imagenes = new Imagenes(url, nombre);
        nombreArrayList.add(imagenes);
 
     }
  }
   } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
   }
  }
 
  private static String getTagValue(String sTag, Element eElement) {
 NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
 
        Node nValue = (Node) nlList.item(0);
 
 return nValue.getNodeValue();
  }
}