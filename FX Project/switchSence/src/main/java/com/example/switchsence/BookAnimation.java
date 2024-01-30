package com.example.switchsence;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BookAnimation extends Application  {



    @Override
    public void start(Stage stage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("PageFlip.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("BookAnimation.Css").toExternalForm());
        stage.show();
    }
    Double a=45.0;
    public void m(ActionEvent e){
        new th1().start();

    }
    class th1 extends Thread{
        @Override
        public void run(){
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(1500), mainPane);
            rotateTransition.setAxis(Rotate.X_AXIS);
            rotateTransition.setNode(mainPane);
            //rotateTransition.setFromAngle(0);
            rotateTransition.setByAngle(a);
            a=0.0;
            rotateTransition.setInterpolator(Interpolator.LINEAR);
            rotateTransition.setCycleCount(1);
            rotateTransition.setAutoReverse(false);
            rotateTransition.play();
            try {
                sleep(3000);
            }catch (Exception e){}
            a=180.0;
          page.setPrefWidth(580);
            RotateTransition rotateTransition2 = new RotateTransition(Duration.millis(1500), page);
         // rotateTransition2.setAxis(new Point3D(0,page.getWidth()/2,0));
            rotateTransition2.setAxis(Rotate.Y_AXIS);
            rotateTransition2.setByAngle(a);
            a=0.0;
            rotateTransition2.setInterpolator(Interpolator.LINEAR);
            rotateTransition2.setCycleCount(1);
            rotateTransition2.setAutoReverse(false);
            rotateTransition2.play();

            try {
                sleep(3000);
            }catch (Exception e){}
            a=-45.0;
            System.out.println("in");
            RotateTransition rotateTransition3 = new RotateTransition(Duration.millis(1500), mainPane);
            rotateTransition3.setAxis(Rotate.X_AXIS);
            rotateTransition3.setNode(mainPane);
            //rotateTransition.setFromAngle(0);
            rotateTransition3.setByAngle(a);
            a=0.0;
            rotateTransition3.setInterpolator(Interpolator.LINEAR);
            rotateTransition3.setCycleCount(1);
            rotateTransition3.setAutoReverse(false);
            rotateTransition3.play();
            a=45.0;


            page.setPrefWidth(290);
            page.setTranslateX(290);

        }
    }
    public void close(MouseEvent n){
        System.exit(0);
    }
    class th2 extends Thread{
        @Override
        public void run(){
            a=45.0;
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(1500), mainPane);
            rotateTransition.setAxis(Rotate.X_AXIS);
            rotateTransition.setNode(mainPane);
            //rotateTransition.setFromAngle(0);
            rotateTransition.setByAngle(a);
            a=0.0;
            rotateTransition.setInterpolator(Interpolator.LINEAR);
            rotateTransition.setCycleCount(1);
            rotateTransition.setAutoReverse(false);
            rotateTransition.play();
            try {
                sleep(3000);
            }catch (Exception e){}
            a=-180.0;
            page.setTranslateX(0);
            page.setPrefWidth(580);
            RotateTransition rotateTransition2 = new RotateTransition(Duration.millis(1500), page);
            rotateTransition2.setAxis(Rotate.Y_AXIS);
            //rotateTransition2.setNode(mainPane);
            //rotateTransition.setFromAngle(0);
            rotateTransition2.setByAngle(a);
            a=0.0;
            rotateTransition2.setInterpolator(Interpolator.LINEAR);
            rotateTransition2.setCycleCount(1);
            rotateTransition2.setAutoReverse(false);
            rotateTransition2.play();
            try {
                sleep(3000);
            }catch (Exception e){}
            a=-45.0;
            System.out.println("in");
            RotateTransition rotateTransition3 = new RotateTransition(Duration.millis(1500), mainPane);
            rotateTransition3.setAxis(Rotate.X_AXIS);
            rotateTransition3.setNode(mainPane);
            //rotateTransition.setFromAngle(0);
            rotateTransition3.setByAngle(a);
            a=0.0;
            rotateTransition3.setInterpolator(Interpolator.LINEAR);
            rotateTransition3.setCycleCount(1);
            rotateTransition3.setAutoReverse(false);
            rotateTransition3.play();
            a=45.0;
            page.setPrefWidth(290);

        }
    }
    public void m2(ActionEvent e){
      new th2().start();

    }
    @FXML
    Pane page;
    @FXML
    AnchorPane mainPane;

    public static void main(String[] args) {
        launch(args);
    }
    class Controll implements Initializable{

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {



        }
    }


}
