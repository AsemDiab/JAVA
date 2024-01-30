//import javax.swing.*;
//import java.awt.*;
//import java.awt.geom.*;
//
//public class CircularButtonGUI extends JFrame {
//    private JButton circularButton;
//
//    public CircularButtonGUI() {
//        setTitle("Circular Button");
//        setSize(300, 300);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel(new BorderLayout());
//        circularButton = new JButton("Click me!");
//        circularButton.setOpaque(false);
//        circularButton.setContentAreaFilled(false);
//        circularButton.setBorderPainted(false);
//        circularButton.setFocusPainted(false);
//        circularButton.setForeground(Color.WHITE);
//        circularButton.setFont(new Font("Arial", Font.BOLD, 16));
//        circularButton.setPreferredSize(new Dimension(100, 100));
//        circularButton.setUI(new BasicButtonUI() {
//            public void paint(Graphics g, JComponent c) {
//                Graphics2D g2d = (Graphics2D) g.create();
//                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                Ellipse2D ellipse = new Ellipse2D.Float(0, 0, c.getWidth(), c.getHeight());
//                g2d.setColor(Color.BLUE);
//                g2d.fill(ellipse);
//                g2d.setColor(Color.WHITE);
//                g2d.draw(ellipse);
//                g2d.dispose();
//            }
//        });
//        panel.add(circularButton, BorderLayout.CENTER);
//
//        add(panel);
//        setVisible(true);
//    }
//
//
//}
