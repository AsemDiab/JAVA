import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class trashThread extends JFrame {


    public static void main(String [] args){
      threa ths[]=new threa[5];
      for(int i=0;i<ths.length;i++){
          ths[i]=new threa();
          ths[i].setName("thread "+i);
      }
        ExecutorService ex= Executors.newCachedThreadPool();

        for(int i=0;i<ths.length-1;i++)
            ex.execute(ths[i]);

        ex.shutdown();
        ths[4].start();
        System.out.println(ths[0].isAlive());
        System.out.println(ths[4].isAlive());

    }}

class Mythread extends Thread{
    int SleepTime=0;
    @Override
    public void run(){
        SleepTime=(int)(Math.random()*2000);
        System.out.println(getName()+" sleeps "+SleepTime);
        for(int v=0;v<5;v++){
            System.out.println(getName()+" count s: "+v);
            try {
                sleep(SleepTime);
            }catch (Exception es){

            }
        }
    }
}


class threa extends Thread{
    static int x=0;
    static Object key=new Object();
    public void run(){
        for (int i=0; i<10 ;i++){
        synchronized (key){
            int old=x;
            x++;
            System.out.println(getName()+" : oldVlaue"+old+" new value "+x);

        }
            try {
                sleep((int)(1000*Math.random()));
            }
            catch (Exception e){

            }
       }
    }
}