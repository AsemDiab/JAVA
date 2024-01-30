package com.example.switchsence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class LoginExampleControll {
    boolean isVaildUserName;
    boolean isEnteredPassword;
    @FXML
    Button button;
    @FXML
    TextField textField;
    @FXML
    PasswordField passwordField;
    @FXML
    CheckBox checkBox;
    @FXML
    ImageView imageView;
    @FXML
    Label userlabel;
    @FXML
    Label passlabel;
    protected boolean isVaildPassWard;


    class passowrdThread extends  Thread{
        public void run(){
            boolean atleastOnelowerAlpha ;
            boolean atleastOneupperAlpha ;
            boolean atleastOnesympol ;
            boolean atleastOneDigit ;
            String str=new String();
            while (true){
                str= passwordField.getText();
                isVaildPassWard=str.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
                System.out.println(isVaildPassWard);
                if (isVaildPassWard)
                    passlabel.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                else
                    passlabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                if (isVaildPassWard)
                    break;

            }

        }}
    class userNameThread extends  Thread{
            public void run(){
                String str=new String();
                while (true){
                    str= textField.getText();
                    isVaildUserName=str.matches("^[a-zA-Z0-9_]{4,20}$");
                    if (isVaildUserName)
                        userlabel.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                    else
                        userlabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    if(isVaildUserName)
                        break;
                }

            }
    }
    public void startWritename(ActionEvent e){
              userNameThread t1=new userNameThread();
              t1.start();

    }
        public void startWritepassword(ActionEvent e){
            passowrdThread t1=new passowrdThread();
            t1.start();
//            try {
//
//               // isVaildPassWard = textField.getText().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
//                isVaildPassWard = "asem".matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
//            }
//            catch (Exception exp){}
//            System.out.println(isVaildPassWard);
        }

        public void clickedForPassword(){
            String str=new String();
                str= passwordField.getText();
                isVaildPassWard=str.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
                System.out.println(isVaildPassWard);
                if (isVaildPassWard)
                    passlabel.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                else
                    passlabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            System.out.println("hello password");

        }
    public  void enterButtonDomain(ActionEvent e){
        System.out.println("i'm in");
        if(isVaildUserName&&isVaildUserName)
            System.out.println("hello");
        }
    }

