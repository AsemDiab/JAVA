package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


class MyGui{
    ArrayList<String>memory;
    JLabel labels[]=new JLabel[4];
    JTextField textField[]=new JTextField[4];
    JButton buttons[]=new JButton[4];

}
public class Gui extends JFrame {
    ArrayList<String>memory;
    JLabel labels[]=new JLabel[4];
    JTextField textField[]=new JTextField[4];
    JButton buttons[]=new JButton[4];

    int yCoro[]={50,150,250,350,50,150,250,350,450 ,450 ,550 ,550};
    int xCoro[]={50,50,50,50,150,150,150,150,50 ,200,50 ,200};
    String labelCaption[]={"Room ID","Room Building","Room Size","Room Type"};
    String buttonCaption[]={"Save","update","Search","Delete"};
    int indexOfLAstSearch=-1;
    public void init(){
        memory=new ArrayList<>();
        try {
            Scanner sr= new Scanner(new File("D:\\New folder (2)\\Asem\\DataBaseHW1\\src\\main\\java\\text.txt"));
            String str;
            while (sr.hasNextLine()){
                str= sr.nextLine();
                memory.add(str);
                System.out.println(str);
            }
        }
        catch (Exception exp){
            System.out.println(exp);
        }
    }
    public Gui(){
        int k=0;
        init();
        setLayout(null);
        for(int i=0;i<4 ;i++){
            labels[i]=new JLabel(labelCaption[i]);
            labels[i].setBounds(xCoro[k]-30,yCoro[k],90,20);
            add(labels[k]);
            k++;
        }

        for(int i=0;i<4 ;i++){
            textField[i]=new JTextField();
            textField[i].setBounds(xCoro[k],yCoro[k],150,40);
            add(textField[i]);
            k++;
        }
        for (int i=0;i<4;i++){
            buttons[i]=new JButton(buttonCaption[i]);
            buttons[i].setBounds(xCoro[k],yCoro[k],100,50);
            add(buttons[i]);
            k++;

        }

        setSize(400,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("text"));
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    String inputFromBox=getBoxContant();
                   if (!inputFromBox.equals(",,,,"))
                    memory.add(inputFromBox);
             writeOnFile();
                    buttons[1].setEnabled(false);
                    buttons[3].setEnabled(false);
                }
                catch (Exception exp){}
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory.set(indexOfLAstSearch,getBoxContant());
                writeOnFile();
                buttons[1].setEnabled(false);
                buttons[3].setEnabled(false);
        }});
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField[0].getText().equals("")){
                    for(int i=0;i<memory.size();i++){
                        if((memory.get(i).split(","))[0].equals(textField[0].getText())){
                            indexOfLAstSearch=i;
                            fillBoxs(memory.get(i).split(","));
                            buttons[1].setEnabled(true);
                            buttons[3].setEnabled(true);
                            break;
                        }
                        if(i==memory.size()-1)
                            JOptionPane.showMessageDialog(null,"not found");
                    }

                }
                else if(!textField[1].getText().equals("")){
                    for(int i=0;i<memory.size();i++){
                        if((memory.get(i).split(","))[1].equals(textField[1].getText())){
                            fillBoxs(memory.get(i).split(","));
                            buttons[1].setEnabled(true);
                            buttons[3].setEnabled(true);
                            indexOfLAstSearch=i;
                            break;
                        }
                        if(i==memory.size()-1)
                            JOptionPane.showMessageDialog(null,"not found");
                    }

                }
                else if(!textField[2].getText().equals("")){
                    for(int i=0;i<memory.size();i++){
                        if((memory.get(i).split(","))[2].equals(textField[2].getText())){
                            fillBoxs(memory.get(i).split(","));
                            indexOfLAstSearch=i;
                            buttons[1].setEnabled(true);
                            buttons[3].setEnabled(true);
                            break;
                        }
                        if(i==memory.size()-1)
                            JOptionPane.showMessageDialog(null,"not found");
                    }
                }
                else if(!textField[3].getText().equals("")){
                    for(int i=0;i<memory.size();i++){
                        if((memory.get(i).split(","))[3].equals(textField[3].getText())){
                            fillBoxs(memory.get(i).split(","));
                            indexOfLAstSearch=i;
                            buttons[1].setEnabled(true);
                            buttons[3].setEnabled(true);
                            break;
                        }
                        if(i==memory.size()-1)
                            JOptionPane.showMessageDialog(null,"not found");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null,"no Infornation to Search");
                    indexOfLAstSearch=-1;
                }
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory.remove((int)indexOfLAstSearch);
                writeOnFile();
                buttons[1].setEnabled(false);
                buttons[3].setEnabled(false);
            }
        });
        buttons[1].setEnabled(false);
        buttons[3].setEnabled(false);


        setVisible(true);
    }

    private void fillBoxs(String[] s) {
        for(int i=0;i<4;i++){
            textField[i].setText(s[i]);
        }
    }

    public String getBoxContant(){
        return textField[0].getText()+","+textField[1].getText()+","+textField[2].getText()+","+textField[3].getText();
    }
    public void writeOnFile(){
        try{
            PrintWriter printWriter =
                    new PrintWriter(new FileWriter("D:\\New folder (2)\\Asem\\DataBaseHW1\\src\\main\\java\\text.txt", false));

            for (String s:memory){
                printWriter.println(s);
                printWriter.flush();}
        }catch (Exception exp){}

    }
}
