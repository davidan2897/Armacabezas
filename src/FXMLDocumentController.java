import Domain.auxiliarControles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import  javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.FileChooser;
/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {
  auxiliarControles auxControles = new auxiliarControles();
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
    

    //Accion Buttonapply
    public void handleButtonaApply(ActionEvent event) {
      anchorCountainerMap.getChildren().clear();
      gridCountainer.getChildren().clear();
      
      
              
      if(numRow.getText().isEmpty()==false && numColum.getText().isEmpty()==false){
      if(auxControles.isEntero(numRow, numColum)==true){
       
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
    
  
     //Accion menuItemExit
    public void ItemExit(ActionEvent event) {
        
        System.exit(0);
    }
    //Accion menuItemAbout
    public void ItemAbout(ActionEvent event) {
       
        TextArea textAreabout = new TextArea();
        auxControles.FormatoTextArea(textAreabout);

        anchorCountainerMap.getChildren().clear();
        anchorCountainerMap.getChildren().addAll(textAreabout);
    }

    public void movientoLabelWelcome() {
       auxControles.animacionLabelWelcome(labelWelcome);
    }//fin movimiento wellcome

           
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movientoLabelWelcome();
        final FileChooser fileChooser = new FileChooser();

    }

}