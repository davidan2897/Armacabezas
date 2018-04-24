/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import  javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
    private Label labelWelcome;
    @FXML
    private ScrollPane scrollPaneMapa;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private ImageView imageFacebook;

    
    @FXML
    private Button apply;
     @FXML
     private Button buttonReset;
     @FXML
    private MenuItem menuItemExit;
      @FXML
    private MenuItem menuItemAbout;
    @FXML
    private TextField numRow;  
    @FXML
    private TextField numColum; 
    
    //mouse clicked
    public void mouseClicked(ActionEvent event) {
      
        
        
        
        
    }
    
    
    
    
    
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
      gridCountainer.getChildren().clear();
      
      
              
      if(numRow.getText().isEmpty()==false && numColum.getText().isEmpty()==false){
      if(isEntero()==true){
       
        int numeroImagenesFila = Integer.parseInt(numRow.getText());
        int numeroImagenesColumna = Integer.parseInt(numColum.getText());

       
        Rectangle[][] images = new Rectangle[numeroImagenesColumna][numeroImagenesFila];
        for (int r = 0; r < numeroImagenesFila; r++) {
            for (int c = 0; c < numeroImagenesColumna; c++) {
                images[c][r] = new Rectangle(100, 100, Color.WHITE);
                Rectangle imageTmp = images[c][r];
                imageTmp.setStrokeType(StrokeType.OUTSIDE);
                imageTmp.setStroke(Color.CADETBLUE);

                gridCountainer.add(images[c][r], c, r);

            }
        }
        gridCountainer.setPrefSize(numeroImagenesColumna * 100, numeroImagenesFila * 100);
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
                +"Creador David Aguilera Navarro"
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

    public void movientoLabelWelcome() {
        Timeline timeline;
        AnimationTimer timer;
        //movimiento 
        TranslateTransition transitioneWelcome = new TranslateTransition();
        transitioneWelcome.setDuration(Duration.seconds(6));
        transitioneWelcome.setToX(70);
        transitioneWelcome.setToY(240);

        transitioneWelcome.setAutoReverse(true);
        transitioneWelcome.setNode(labelWelcome);
        transitioneWelcome.setCycleCount(Animation.INDEFINITE);
        transitioneWelcome.play();

        //cambio de tamaño labelwelcome
        KeyValue keyValueX = new KeyValue(labelWelcome.scaleXProperty(), 1);
        KeyValue keyValueY = new KeyValue(labelWelcome.scaleYProperty(), 2);
        Duration duration = Duration.millis(4000);

        KeyFrame keyFrame = new KeyFrame(duration, keyValueX, keyValueY);

        //ejecucion 
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

            }

        };
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
        timer.start();
    }//fin movimiento wellcome

           
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movientoLabelWelcome();
        final FileChooser fileChooser = new FileChooser();

    }

}
