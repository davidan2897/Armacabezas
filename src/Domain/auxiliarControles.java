/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class auxiliarControles {

    private int numeroImagenesFila;
    public void FormatoTextArea(TextArea textAreabout) {

        String texto = ("Esta aplicacion esta hecha con el proposito de \n"
                + "que el cliente pueda diseñar sus propias imagenes apartir de otras imagenes\n"
                + "Creador David Aguilera Navarro"
                + " \n Version 1.0");
        textAreabout.setText(texto);
        textAreabout.setFont(new Font("Comic Sans MS", 13));
        textAreabout.setStyle("-fx-highlight-fill: #66CCFF; -fx-highlight-text-fill: #000000; -fx-text-fill: #000033; -fx-background-color:#CC0000;");
        textAreabout.setWrapText(true);
        textAreabout.setMaxSize(250, 150);
        textAreabout.setEditable(false);
        textAreabout.setLayoutX(40);
        textAreabout.setLayoutY(100);

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
//
//    public Rectangle[][] enviaMatriz(int numeroImagenesColumna, int numeroImagenesFila) {
//
//        Rectangle[][] images = new Rectangle[numeroImagenesColumna][numeroImagenesFila];
//        for (int r = 0; r < numeroImagenesFila; r++) {
//            for (int c = 0; c < numeroImagenesColumna; c++) {
//                images[c][r] = new Rectangle(100, 100, Color.WHITE);
//                Rectangle imageTmp = images[c][r];
//                imageTmp.setStrokeType(StrokeType.OUTSIDE);
//                imageTmp.setStroke(Color.CADETBLUE);
//
//                return images;
//
//            }

        }     
    

