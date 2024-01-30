//package com.example.switchsence;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.PasswordField;
//import javafx.stage.Stage;
//
//public class LoginExample extends Application {
//    @FXML
//    PasswordField passwordField;
//    LoginExampleControll loginExampleControll=new LoginExampleControll();
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("LoginExample.fxml"));
//        Scene scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//        stage.setOnCloseRequest(windowEvent -> {
//           System.exit(0);
//
//            Platform.exit();
//        });
//    }
//    public static void main(String[]args){
//        launch();
//    }
//}
