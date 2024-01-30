import javax.swing.*;
import java.awt.*;

public class timer extends JFrame {
    JLabel m,h,s;
    timer(){
        setSize(500,500);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       h=new JLabel("00");
        m=new JLabel("00");
         s=new JLabel("00");
        add(h);
        add(m);
        add(s);
        setVisible(true);
        mythread vs=new mythread(s);
        mythread vs1=new mythread(m);
        mythread vs2=new mythread(h);
        vs.start();
        vs1.start();
        vs2.start();


    }
    class mythread extends Thread{
        JLabel s;
        int sleeptime;
        mythread(JLabel l){
            super();
            s=l;
            sleeptime=(int)(Math.random()*4000);
        }
        public void run(){
            while (true){
                try {
                    sleep((int)(Math.random()*4000));
                }catch (Exception e){}
                s.setText(String.valueOf(Integer.valueOf(s.getText())+1));
            }
        }
    }
    public static void main(String [] args){
        new timer();
    }
}
