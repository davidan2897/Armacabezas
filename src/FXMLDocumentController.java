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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import sun.plugin.javascript.navig.Anchor;
import  javafx.scene.shape.Rectangle;
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

    public void handleButtonaApply(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "si");
        int numeroImagenesFila = 4;
        int numeroImagenesColumna = 4;
        
        Rectangle rectangle = new Rectangle (100,100,Color.CADETBLUE);
        Rectangle[][] images = new Rectangle[numeroImagenesFila][numeroImagenesColumna];
//        for(int r=0;r<numeroImagenesFila;r++)
//            for(int c=0;c<numeroImagenesColumna;c++)
//                gridCountainer.add(rectangle, r, c);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
