import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame=new JFrame();
        frame.setSize(500,500);
        JPanel pa=new JPanel();
        pa.setSize(500,500);
        pa.setLayout(new FlowLayout());
        pa.add(new JButton("1"));
        pa.add(new JButton("2"));
        pa.add(new JButton("3"));
        JScrollPane p=new JScrollPane();
        p.setSize(500,500);
        p.setWheelScrollingEnabled(true);
        p.add(pa);
        frame.add(p);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}