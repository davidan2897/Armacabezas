/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import sun.plugin.javascript.navig.Anchor;
import  javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {

  @FXML
  private GridPane gridCountainer;
          
    @FXML
    private Label labelEnterSizeColumAndRows;
    @FXML
    private ScrollPane scrollPaneMapa;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private ImageView Image1;
    @FXML
    private Button apply;
     @FXML
     private Button btnReset;
     @FXML
    private MenuItem menuItemExit;
      @FXML
    private MenuItem menuItemAbout;
    @FXML
    private TextField numRow;  
    @FXML
    private TextField numColum;  
    
    //Validar si se ingresan numero en el tamño de matriz
    public boolean isEntero() {
        int enteroRow;
        int enteroColum;
        boolean esEntero = true;
        try {
       enteroRow = (Integer.parseInt(numRow.getText()));
       enteroColum= (Integer.parseInt(numColum.getText()));
        } catch (Exception e) {
            esEntero = false;
            numRow.setText("");
            numColum.setText("");
        }
        return esEntero;
    }//fin isEntero

    //Accion Buttonapply
    public void handleButtonaApply(ActionEvent event) {
      anchorCountainerMap.getChildren().clear();
      if(numRow.getText().isEmpty()==false && numColum.getText().isEmpty()==false){
      if(isEntero()==true){
       
        int numeroImagenesFila = Integer.parseInt(numRow.getText());
        int numeroImagenesColumna = Integer.parseInt(numColum.getText());

       
        Rectangle[][] images = new Rectangle[numeroImagenesColumna][numeroImagenesFila];
        for (int r = 0; r < numeroImagenesFila; r++) {
            for (int c = 0; c < numeroImagenesColumna; c++) {
                images[c][r] = new Rectangle(80, 80, Color.WHITE);
                Rectangle imageTmp = images[c][r];
                imageTmp.setStrokeType(StrokeType.OUTSIDE);
                imageTmp.setStroke(Color.CADETBLUE);

                gridCountainer.add(images[c][r], c, r);

            }
        }
        gridCountainer.setPrefSize(numeroImagenesColumna * 80, numeroImagenesFila * 80);
        anchorCountainerMap.getChildren().addAll(gridCountainer);
      }//fin if isEntero
      else{
          JOptionPane.showMessageDialog(null, "Character no valid");
      }//fin caracter no valido
       }//fin if isEntero
      else{
          JOptionPane.showMessageDialog(null, "There is not characters entered");
      }//fin isEmpty
    }// buttonApply
    
    
     public void handleButtonReset(ActionEvent event) {
 
     }
     //Accion menuItemExit
    public void ItemExit(ActionEvent event) {
        
        System.exit(0);
    }
    //Accion menuItemAbout
    public void ItemAbout(ActionEvent event) {
        TextArea textAreabout = new TextArea("Esta aplicacion esta hecha con el proposito de \n"
                + "que el cliente pueda diseñar sus propias imagenes apartir de otras imagenes\n"
                + " \n Version 1.0");
        anchorCountainerMap.getChildren().clear();
        anchorCountainerMap.getChildren().addAll(textAreabout);
        textAreabout.setFont(new Font("Comic Sans MS", 13));
        textAreabout.setStyle("-fx-highlight-fill: #66CCFF; -fx-highlight-text-fill: #000000; -fx-text-fill: #000033; -fx-background-color:#CC0000;");
        textAreabout.setWrapText(true);
        textAreabout.setMaxSize(250, 150);
        textAreabout.setEditable(false);
     textAreabout.setLayoutX(40);
     textAreabout.setLayoutY(100);
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
