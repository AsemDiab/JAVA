package com.example.switchsence;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RadioButton1 extends Application implements Initializable {


    @Override
    public void start(Stage stage) throws Exception {
        try {


        Parent root= FXMLLoader.load(getClass().getResource("RadioButton.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        scene.setOnKeyPressed(keyEvent -> {
            System.out.println(keyEvent.getCode());
            System.out.println(keyEvent.getCode()== KeyCode.UP);
        });
        stage.show();
        }
        catch (Exception exp){
            System.out.println("exception");
            System.out.println(exp);
            System.exit(0);
        }
    }
    public static void main(String []args){
        launch();
    }
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private RadioButton image;

    @FXML
    private Label label;

    @FXML
    private RadioButton line;

    @FXML
    private ProgressBar progress;

    @FXML
    private Slider slider;

    @FXML
    private Spinner<Integer> spinner;
    String str[]={"slider","spinner"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(str);
        System.out.println(str[0]);
        progress.setProgress(0.0);
        SpinnerValueFactory<Integer>i=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        i.setValue(1);
        spinner.setValueFactory(i);
        progress.setStyle("-fx-accent:#00ff00");
        choiceBox.setOnAction(this::action);
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                //   action(new ActionEvent());
                if(choiceBox.getValue()=="spinner")
                    progress.setProgress(spinner.getValue()*0.1);

            }
        });
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                if(choiceBox.getValue()=="slider")
                    progress.setProgress(slider.getValue()*0.01);
            }
        });
    }
    public void action(ActionEvent e){
        if(choiceBox.getValue()=="slider")
            progress.setProgress(slider.getValue()*0.01);
        else
            progress.setProgress(spinner.getValue()*0.1);
    }
}
class  controll  {

}
