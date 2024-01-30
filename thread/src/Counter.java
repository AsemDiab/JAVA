import javax.swing.*;

public class Counter extends JFrame {
    public static JLabel label=new JLabel("0");
    Counter(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(label);
        setVisible(true);
        CT ct=new CT();
        ct.start();
    }
    public static void main(String [] args){
        new Counter();
    }
}
class CT extends Thread{
    public void run(){
        while (true){
        try {
            JTextField text;

            sleep(1000);
            Counter.label.setText(String.valueOf(Integer.valueOf(Counter.label.getText())+1));
        }
        catch (Exception e){

        }
    }}
}