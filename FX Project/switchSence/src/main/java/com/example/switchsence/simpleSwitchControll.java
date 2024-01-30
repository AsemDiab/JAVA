package com.example.switchsence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class simpleSwitchControll {
    Stage stage;
    Scene scene;
    Parent root;


    public void toSecond(ActionEvent e)throws Exception{
        root= FXMLLoader .load(getClass().getResource("hello-view.fxml"));
        stage=(Stage) ((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void toFirst(){

    }
}
