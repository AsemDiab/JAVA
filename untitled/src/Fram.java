import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SFrame extends JFrame{
    JTextField textField;
    JButton button;
    JLabel label;
    SFrame(){
        textField=new JTextField();
        button=new JButton();
        label=new JLabel();
        Icon icon=new ImageIcon(getClass().getResource("benny1.jpg"));

        //setIconImage();


        textField.setBounds(0,500,450,100);
        textField.setOpaque(true);
        label.setOpaque(true);
        label.setBounds(0,0, icon.getIconWidth(), icon.getIconHeight());
        label.setIcon(icon);
        add(textField);
        add(label);
        setSize(new Dimension(500,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // label.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }

            public void mouseReleased(MouseEvent e) {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        label.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() + label.getX();
                int y = e.getY() + label.getY();
                label.setLocation(x, y);
            }
        });
    }
}
public class Fram{
    public static void main(String[]args){
        new SFrame();
    }
}