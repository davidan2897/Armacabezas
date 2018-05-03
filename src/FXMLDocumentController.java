import Domain.Files;
import Domain.Imagenes;
import Domain.auxiliarControles;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javax.swing.JOptionPane;
import  javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {
    
    auxiliarControles auxControles = new auxiliarControles();
    Files files = new Files();
    Rectangle rectangles;
    Image imageAux;
   
 
  @FXML
  private GridPane gridCountainer;
    @FXML
    private Label labelWelcome;
    @FXML
    private ScrollPane scrollPaneImages;
    @FXML
    private AnchorPane anchorCountainerMap;
     @FXML
    private AnchorPane anchorImages;
    @FXML
    private Button apply;
     @FXML
    private MenuItem menuItemExit;
      @FXML
    private MenuItem menuItemAbout;
    @FXML
    private TextField numRow;  
    @FXML
    private TextField numColum; 
     @FXML
    private Menu menuExport;

    //Accion Buttonapply
     //si los valores que entran como textfield son enteros habilita el scrollPane que tiene el anchor de imagenes
     //se habilita el tablero 
    public void handleButtonaApply(ActionEvent event) {
        anchorCountainerMap.getChildren().clear();
        gridCountainer.getChildren().clear();

        if (numRow.getText().isEmpty() == false && numColum.getText().isEmpty() == false) {
            if (auxControles.isEntero(numRow, numColum) == true) {
                scrollPaneImages.setDisable(false);
                menuExport.setDisable(false);

                int numeroImagenesFila = Integer.parseInt(numRow.getText());
                int numeroImagenesColumna = Integer.parseInt(numColum.getText());

                ImageView [][] rectangulosMatriz = new ImageView[numeroImagenesColumna][numeroImagenesFila];
                for (int r = 0; r < numeroImagenesFila; r++) {
                    for (int c = 0; c < numeroImagenesColumna; c++) {
                        ImageView iv =  new ImageView("Imagenes/Cuadrado.jpg");
                        iv.setFitHeight(100);
                         iv.setFitWidth(100);
                           rectangulosMatriz[c][r] = iv;
                              gridCountainer.add(rectangulosMatriz[c][r], c, r);
//                        rectangles = new Rectangle(100, 100, Color.WHITE);
                        iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent mouseEvent) {
                               
                                int posicionC = GridPane.getColumnIndex(iv);
                                int posicionR = GridPane.getRowIndex(iv);
                                System.out.print(posicionC + " " + posicionR + "\n");
                                iv.setImage(imageAux);
                                gridCountainer.getChildren().remove(iv);
                                gridCountainer.add(iv, posicionC, posicionR);
//                                rectangles.setFill(new ImagePattern(imageAux, 0, 0, 100, 100, false));

                            }

                        });

                      
//                        rectangles.setStrokeType(StrokeType.OUTSIDE);
//                        rectangles.setStroke(Color.CADETBLUE);
                     
                    }
                    
         
              
                }
                gridCountainer.setPrefSize(numeroImagenesColumna * 100, numeroImagenesFila * 100);
                anchorCountainerMap.getChildren().addAll(gridCountainer);
               
               
            }//fin if isEntero
            else {
                JOptionPane.showMessageDialog(null, "Character no valid");
            }//fin caracter no valido
        }//fin if isEntero
        else {
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
    //animacion de labelWelcome

    public void movientoLabelWelcome() {
       auxControles.animacionLabelWelcome(labelWelcome);
    }//fin movimiento wellcome

    //carga las imagenes a la interfaz
    public void cargarImagenes() throws Exception{
        
     anchorImages.getChildren().addAll(printImages());
        
        
    }   
      public VBox printImages() throws Exception {

        Imagenes tempImagenes = null;
        String url;
        VBox vbox = new VBox();
        for (int i = 0; i < files.ReadXml().size(); i++) {
            tempImagenes = files.ReadXml().get(i);
            url = tempImagenes.getURL();
           Image image = new Image(url);
           
           ImageView imageView = new ImageView(image);
            imageView.setCursor(Cursor.OPEN_HAND);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                         gridCountainer.setDisable(false);
                   imageAux=imageView.getImage();
                  
                              
                       

                    }
                }

            });

            imageView.setFitHeight(100);
            imageView.setFitWidth(100);

            vbox.getChildren().addAll(imageView);

        }
        return vbox;

    }

    //exporta la imagen final en archivo jpg Item export jpg
    public void exportImagejpg() {
 
  auxControles.takeSnapshotjpg(gridCountainer);
}    
    
     //exporta la imagen final en archivo jpg Item export png
        public void exportImagepng() {
 
  auxControles.takeSnapshotpng(gridCountainer);
}    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            movientoLabelWelcome();
            cargarImagenes();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}