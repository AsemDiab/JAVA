package com.example.switchsence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class RadioButtonControll {
    @FXML
    private Label label;
    @FXML
    private RadioButton color,line,image;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    public void clicked(ActionEvent e){
        if (color.isSelected()){
            label.setText("color");
            label.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("Color");
        }
        else if (line.isSelected()) {
             label.setText("Line");
             color.setSelected(false);
            System.out.println("Line");
        } else if (image.isSelected()) {
             label.setText("Image");
            System.out.println("Image");
        }
        else {
            label.setText(" none ");
        }
    }
}
