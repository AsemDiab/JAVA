/*public class Main{
    public static void main(String [] args){
        Fram1 fram=new Fram1();
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
        setTitle("Login");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);
        panel.add(new JLabel());
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Validate username and password
            }
        });
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }}
class LabelMoveGUI extends JFrame {
    private JLabel label;

    public LabelMoveGUI() {
        setTitle("Label Move");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        label = new JLabel("Move me!");
        label.setBounds(50, 50, 100, 30);
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
        panel.add(label);

        add(panel);
        setVisible(true);
    }}
class Main{
    public static void main(String[] args) {
       // new LoginGUI();
        new LabelMoveGUI();
    }
}