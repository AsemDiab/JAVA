package com.example.switchsence;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class exmineField extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent= FXMLLoader.load(getClass().getResource("mulitpagePane.fxml"));
        Scene scene=new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("simpl.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[]args){
        launch();
    }
}


