package com.example.switchsence;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class exmineFieldControll implements Initializable {

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane5;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;
    @FXML
    private Pane side;
    @FXML
    private Circle circle;
    @FXML
    private Pane side1;
    @FXML
    private Circle backarrow1;
    @FXML
    private Circle backarrow2;
    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // new mythread().start();
        try {


            Image image = new Image(new FileInputStream("D:\\Media\\loupe_2120967.png"));

// Create an ImageView object for the icon image.
            ImageView imageView = new ImageView(image);

// Set the graphic of the TextField to the ImageView.
        }
        catch (Exception exception){}
        System.out.println("start");


    class mythread extends Thread{
        int [][] Xposition={
                {-146,-146,-146,-146,-146}
                ,{442,-2*146,-2*146,-2*146,-2*146}
                ,{292,292,-3*146,-3*146,-3*146}
                ,{146,146,146,-4*146,-4*146}
                ,{0,0,0,0,-5*146}
                ,{-146,-146,-146,-146,-146}
        };
        @Override
        public void run() {
            try {


                sleep(0);

            } catch (Exception exp) {
            }
            System.out.println("hello");
            TranslateTransition[]translateTransitions=new TranslateTransition[5];

            //while (true){
            int j=0;
            while (true){
                for (int i = 0; i < 5; i++) {
                    translateTransitions[i] = new TranslateTransition();
                    translateTransitions[i].setDuration(Duration.millis(250));
                    translateTransitions[i].setToX(Xposition[j][i]);
                }

                translateTransitions[0].setNode(pane1);
                translateTransitions[1].setNode(pane2);
                translateTransitions[2].setNode(pane3);
                translateTransitions[3].setNode(pane4);
                translateTransitions[4].setNode(pane5);


                for (int i = 0; i < 5; i++) {

                    translateTransitions[i].play();

                }
                try {
                    sleep(2500);
                }catch (Exception exp){}
                switch (j){
                    case 0: pane1.setVisible(false);pane1.setTranslateX(588);pane1.setVisible(true);break;
                    case 1:pane2.setVisible(false);pane2.setTranslateX(Xposition[j][0]+146);pane2.setVisible(true);break;
                    case 2:pane3.setVisible(false);pane3.setTranslateX(Xposition[j][0]+146);pane3.setVisible(true);break;
                    case 3:pane4.setVisible(false);pane4.setTranslateX(Xposition[j][0]+146);pane4.setVisible(true);break;
                    case 4:pane5.setVisible(false);pane5.setTranslateX(146);pane5.setVisible(true);break;
                    default:

                }
                try {


                    sleep(2500);
                    //pane1.setTranslateX(618);
                } catch (Exception exp) {
                }
                j=(j+1)%5;

            }

           // System.out.println("finished");
            //}
        }
    }}}

