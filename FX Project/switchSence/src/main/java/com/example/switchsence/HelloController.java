package com.example.switchsence;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button manu;

    @FXML
    private Button manuback;
    @FXML
    private AnchorPane slider;
    @FXML
    private ImageView exit;
    @FXML
    private FlowPane contant;
    @FXML
    ScrollPane scroll;
    @FXML
    private TabPane tabPane;
    @FXML
    private Circle addIcon;
    @FXML
    Pane base;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {


            //base.getChildren().add( FXMLLoader.load(getClass().getResource("mulitpagePane.fxml")));
        }catch (Exception e){}
        slider.setTranslateX(-190);
      //addIcon.setFill(new ImagePattern(new Image("C:\\Users\\Google Tceh\\Downloads\\icons8-add-64.png")));
      slider.setVisible(false);
      slider.setPrefWidth(0);
      tabPane.setPrefWidth(560);
        contant.setPrefWidth(550);
      tabPane.setTranslateX(-150);

      exit.setOnMouseClicked(MouseEvent->{
          System.exit(0);
      });
        manuback.setVisible(false);
        manu.setVisible(true);
        manu.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide1=new TranslateTransition();
            slide1.setDuration(Duration.seconds(0.4));
            slide1.setNode(tabPane);
            slide1.setToX(0);

           // tabPane.setTranslateX(0);
            slider.setPrefWidth(186);
            tabPane.setPrefWidth(460);
            contant.setPrefWidth(450);
            slider.setVisible(true);
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();
            slide1.play();
            slider.setTranslateX(-176);
            slide.setOnFinished((ActionEvent e)->
                    {
                        manuback.setVisible(true);
                        manu.setVisible(false);
                    }
                    );
        });

        manuback.setOnMouseClicked(mouseEvent -> {
            tabPane.setTranslateX(-140);
            tabPane.setPrefWidth(570);
            contant.setPrefWidth(550);
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(-190);
            slide.play();
            slider.setTranslateX(0);
            scroll.setFitToHeight(true);
            scroll.setFitToWidth(true);
            slide.setOnFinished((ActionEvent e)->
                    {
                        manuback.setVisible(false);
                        manu.setVisible(true);
                    }
            );
            slider.setVisible(false);
            slider.setPrefWidth(0);
        });
        contant.setVgap(10);
        contant.setHgap(10);
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\PHPCookbookCookbooksOReilly.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece1.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece2.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece3.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece4.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece7.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece12.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece35.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece45.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece51.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece59.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece60.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece61.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece62.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece85.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece91.jpg")));
//        contant.getChildren().add(new JFlipCard(new Image("D:\\Media\\OnePiece97.jpg")));
    }
    @FXML
    public void enter(MouseEvent e){
        ((Pane) e.getSource()).setStyle("-fx-background-color:#ffffff;" +
                "-fx-background-radius:25" );
    }
    @FXML
    public void out(MouseEvent e){
        ((Pane) e.getSource()).setStyle("-fx-background-color:#00000015;" +
                "-fx-background-radius:25" );
    }
}