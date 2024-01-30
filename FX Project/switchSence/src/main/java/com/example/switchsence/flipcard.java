package com.example.switchsence;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
        import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class flipcard extends Application implements Initializable {
@FXML
FlowPane Grid;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("flipcard.fxml"));
//        JFlipCard flipCard=new JFlipCard();
//        JFlipCard flipCard1=new JFlipCard();
//        JFlipCard flipCard2=new JFlipCard();
//        flipCard.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(getClass().getResource("flipcard.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Grid.setHgap(50);
        Grid.setVgap(50);
//        Grid.getChildren().add(new JFlipCard());
//        Grid.getChildren().add(new JFlipCard());
//        Grid.getChildren().add(new JFlipCard());
//        Grid.getChildren().add(new JFlipCard());
        System.out.println("pizza");
    }
}
