package Domain;


import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
    ArrayList<Imagenes> imagenesArrayList = new ArrayList<>();
    public void ReadXml() throws Exception  {
    
 
        try {
            File fXmlFile = new File("src/ImagesXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(fXmlFile);

            document.getDocumentElement().normalize();
            NodeList nodosImagenesList = document.getElementsByTagName("image");
 
       for (int temp = 0; temp < nodosImagenesList.getLength(); temp++) {
 
     Node nNode = nodosImagenesList.item(temp);
     if (nNode.getNodeType() == Node.ELEMENT_NODE) {
       
       
        Element unElemento = (Element) nNode;
        String url =  getTagValue("URL", unElemento);
        String nombre =  getTagValue("nombre", unElemento);
        Imagenes imagenes = new Imagenes(url, nombre);
        imagenesArrayList.add(imagenes);
       
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
  
  public VBox printImages() throws Exception{
      ReadXml();
       Imagenes tempImagenes = null;
       String url;
       VBox vbox = new VBox();
      for(int i=0;i<imagenesArrayList.size();i++){
     tempImagenes = imagenesArrayList.get(i);
     url = tempImagenes.getURL();
     Image image = new Image(url);
     ImageView imageView = new ImageView(image);
     imageView.setFitHeight(100);
     imageView.setFitWidth(100);
  
     vbox.getChildren().addAll(imageView);
      
      }
        return vbox;
      
  }
  
  
  
  
}