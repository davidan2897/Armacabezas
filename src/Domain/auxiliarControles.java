/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.File;
import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author David
 */
public class auxiliarControles {

  
    public void FormatoTextArea(TextArea textAreabout) {

        String texto = ("This application is made for the purpose of \n"
                + "that the client can design their own images from other images\n"
                + "\nProgramers : \nDavid Aguilera Navarro\nKevin Picado Quesada"
                + " \n\n Version 1.0");
        textAreabout.setText(texto);
        textAreabout.setFont(new Font("Comic Sans MS", 13));
        textAreabout.setStyle("-fx-highlight-fill: #66CCFF; -fx-highlight-text-fill: #000000; -fx-text-fill: #000033; -fx-background-color:#CC0000;");
        textAreabout.setWrapText(true);
        textAreabout.setMaxSize(300, 200);
        textAreabout.setEditable(false);
        textAreabout.setLayoutX(40);
        textAreabout.setLayoutY(80);

    }
    public void animacionLabelWelcome(Label labelWelcome){
    
        
        
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
}//fin animacionWellcome
 
     //Validar si se ingresan numero en el tamño de matriz
        //comprobar si los strings que entran por textField son numerosEnteros
    public boolean isEntero(TextField numRow, TextField numColum) {
        int enteroRow;
        int enteroColum;
        boolean esEntero = true;
        try {
            enteroRow = (Integer.parseInt(numRow.getText()));
            enteroColum = (Integer.parseInt(numColum.getText()));
        } catch (Exception e) {
            esEntero = false;
            numRow.setText("");
            numColum.setText("");
        }
        return esEntero;
    }//fin isEntero

     public void takeSnapshotjpg(GridPane gridCountainer) {
        JFileChooser fileChooser = new JFileChooser(new File("c:\\"));
        fileChooser.setDialogTitle("Save Image");

        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Imagen(*.jpg)", "jpg");//filtra archivos de tipo jpg
        fileChooser.setFileFilter(filtroExtension);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile() + ".jpg");//crea el archivo file con la extencion jpg

            try {
                WritableImage writableImage
                        = new WritableImage((int) gridCountainer.getWidth(), (int) gridCountainer.getHeight());
                gridCountainer.snapshot(null, writableImage);

                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                    JOptionPane.showMessageDialog(null, "Picture save successfully  "+file.getAbsolutePath(),"Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.print("problemas");
                }

            } catch (Exception E) {

            }
        }
    }
public void takeSnapshotpng(GridPane gridCountainer) {
        JFileChooser fileChooser = new JFileChooser(new File("c:\\"));
        fileChooser.setDialogTitle("Save Image");

        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Imagen(*.png)", "png");//filtra archivos de tipo jpg
        fileChooser.setFileFilter(filtroExtension);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile() + ".png");//crea el archivo file con la extencion jpg

            try {
                WritableImage writableImage
                        = new WritableImage((int) gridCountainer.getWidth(), (int) gridCountainer.getHeight());
                gridCountainer.snapshot(null, writableImage);

                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                    JOptionPane.showMessageDialog(null, "Picture save successfully  "+file.getAbsolutePath(),"Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.print("problemas");
                }

            } catch (Exception E) {

            }
        }
    }

        }     
    

