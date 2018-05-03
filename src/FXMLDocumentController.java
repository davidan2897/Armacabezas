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
import javax.swing.JOptionPane;
/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {
    
    auxiliarControles auxControles = new auxiliarControles();
    Files files = new Files();
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
    private MenuItem menuItemInfo;
    @FXML
    private TextField numRow;  
    @FXML
    private TextField numColum; 
     @FXML
    private Menu menuExport;
       @FXML
    private VBox vboxImages;

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

                ImageView [][] ImagesMatriz = new ImageView[numeroImagenesColumna][numeroImagenesFila];
                for (int r = 0; r < numeroImagenesFila; r++) {
                    for (int c = 0; c < numeroImagenesColumna; c++) {
                        ImageView imageViewControladorImagenes =  new ImageView("Imagenes/Cuadrado.jpg");
                        imageViewControladorImagenes.setFitHeight(100);
                         imageViewControladorImagenes.setFitWidth(100);
                           ImagesMatriz[c][r] = imageViewControladorImagenes;
                              gridCountainer.add(ImagesMatriz[c][r], c, r);
                        imageViewControladorImagenes.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent mouseEvent) {
                               
                                int posicionC = GridPane.getColumnIndex(imageViewControladorImagenes);
                                int posicionR = GridPane.getRowIndex(imageViewControladorImagenes);
                                imageViewControladorImagenes.setImage(imageAux);
                                gridCountainer.getChildren().remove(imageViewControladorImagenes);
                                gridCountainer.add(imageViewControladorImagenes, posicionC, posicionR);
                            }

                        });
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
        auxControles.FormatoTextAreaAbout(textAreabout);

        anchorCountainerMap.getChildren().clear();
        anchorCountainerMap.getChildren().addAll(textAreabout);
    }
        
    
    //Accion menuItemInfo
    public void ItemInfo(ActionEvent event) {
       
        TextArea textAreaInfo= new TextArea();
        auxControles.FormatoTextAreaInfo(textAreaInfo);

        anchorCountainerMap.getChildren().clear();
        anchorCountainerMap.getChildren().addAll(textAreaInfo);
    }
    
    //animacion de labelWelcome

    public void movientoLabelWelcome() {
       auxControles.animacionLabelWelcome(labelWelcome);
    }//fin movimiento wellcome

    //carga las imagenes a la interfaz
    public void cargarImagenes() throws Exception{
    printImages();
    }  
    
      public void printImages() throws Exception {

        Imagenes tempImagenes = null;
        String url;
        VBox vbox = new VBox();
        
        for (int i = 0; i < files.ReadXml().size(); i++) {
            tempImagenes = files.ReadXml().get(i);
            url = tempImagenes.getURL();
           Image imageXML = new Image(url);
           
           ImageView imageViewXMLImages = new ImageView(imageXML);
            imageViewXMLImages.setCursor(Cursor.OPEN_HAND);
            imageViewXMLImages.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                         gridCountainer.setDisable(false);
                   imageAux=imageViewXMLImages.getImage();
                  
                              
                       

                    }
                }

            });

            imageViewXMLImages.setFitHeight(100);
            imageViewXMLImages.setFitWidth(100);

            vboxImages.getChildren().addAll(imageViewXMLImages);

        }
    

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