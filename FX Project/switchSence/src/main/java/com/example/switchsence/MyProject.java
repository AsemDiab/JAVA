package com.example.switchsence;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyProject extends Application {
    @FXML
    PasswordField passwordField;
    @FXML
    TextField shownPassword;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("MyProject.fxml"));
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getResource("MyProject.CSS").toExternalForm());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();

    }
    @FXML
    public void close(ActionEvent e){
        ((Stage) ((Node)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    public void change(ActionEvent e){
        if(((CheckBox) e.getSource()).isSelected()){
           passwordField.setVisible(false);
           shownPassword.setText(passwordField.getText());
           shownPassword.setVisible(true);
            Label label=new Label();
            label.setRotate(180);

        }
            else{
                shownPassword.setVisible(false);
                passwordField.setText(shownPassword.getText());
                passwordField.setVisible(true);
    }

    }
    @FXML
    public void login(ActionEvent e){
        try {


        Stage stage=(Stage) (((Node)e.getSource()).getScene().getWindow());
        Scene scene=new Scene((Parent)FXMLLoader.load(getClass().getResource("hello-view.fxml")) );
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("simpl.css").toExternalForm());
    }catch (Exception exception){}
    }
    public static void main(String[]args){
        launch();
    }
}
