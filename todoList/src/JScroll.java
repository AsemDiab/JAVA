import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class ButtonScrollPaneExample extends JFrame {

     int x=5;
    JPanel buttonPanel;
     ArrayList<JButton>buttons;
    public ButtonScrollPaneExample() {
        buttons=new ArrayList<>();
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(750,750));
        buttonPanel.setLayout(new GridLayout(5,1));


        // Create a new JPanel to hold the buttons
        // Add some buttons to the panel


        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 1"));



        // Create a new JScrollPane and add the button panel to it
        JScrollPane scrollPane = new JScrollPane(buttonPanel);

        buttonPanel.setLayout(new GridLayout(6,1));
        buttonPanel.add(new JButton("asem"));
        // Add the JScrollPane to the JFrame
        getContentPane().add(scrollPane);

        // Set the size of the JFrame and make it visible
        setSize(500, 700);
        setVisible(true);
    }


}



class Frame extends JFrame{

    //JScrollPane scrollPane;
    JButton addButton;
    JLabel label;
    JPanel panel;
    public JPanel pa;
    int countOfLine=0;
    class handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==addButton)
            {
                String str=JOptionPane.showInputDialog("enter missoin");
                Lines.add(new Line(str));
                pa.add(Lines.get(Lines.size()-1));
                System.out.println("done"+str);
                pa.revalidate();
                pa.repaint();

            }
        }
    }
    class Line extends JPanel {
        private JLabel label;
        private JCheckBox checkBox;
        private JButton button;
        int index;

        public Line(String s){
            setPreferredSize(new Dimension(500,50));
            setBounds(0,countOfLine*60,500,50);
            setLayout(new GridLayout(1,3));
            label=new JLabel(s);
            checkBox=new JCheckBox();
            button =new JButton(new ImageIcon(getClass().getResource("OIP1.jpg")));
            button.setBackground(Color.WHITE);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Lines.get(index).label.setText(Lines.get(Lines.size()-1).label.getText());
                    pa.remove(Lines.get(Lines.size()-1));
                    Lines.remove(Lines.size()-1);
                    pa.revalidate();
                    pa.repaint();
                    countOfLine--;
                }
            });
            add(checkBox);
            add(label);
            add(button);
            System.out.println(this.getClass());
            index=countOfLine++;
        }


    }
    public ArrayList<Line>Lines=new ArrayList<>();
    public Frame(){
        pa=new JPanel();
        pa.setLayout(null);
        pa.setBackground(Color.WHITE);
        setSize(500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);

        addButton=new JButton("add mission");
        label=new JLabel("label");
        panel=new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(addButton);
        panel.add(label);
        add(panel,BorderLayout.NORTH);

        JScrollPane scrollPane=new JScrollPane(pa);
        //scrollPane.add(p);
        addButton.addActionListener(new handler());
        getContentPane().add(scrollPane);
        setVisible(true);
        setLayout(new BorderLayout());


    }
}
public class JScroll {
    public static void main(String[] args) {
        // Create a new instance of the example and set it to exit on close
//        ButtonScrollPaneExample example = new ButtonScrollPaneExample();
//        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Frame();
    }
}
