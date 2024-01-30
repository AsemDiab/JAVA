import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoList implements ActionListener {
    JTextField textField;
    JList<String> list;
    DefaultListModel<String> model;
    JButton addButton, editButton, deleteButton;

    TodoList() {
        // Create the JFrame
        JFrame frame = new JFrame("Todo List");

        // Create the JTextField
        textField = new JTextField(10);

        // Create the JList and the model
        model = new DefaultListModel<>();
        list = new JList<>(model);

        // Create the JButton
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Add the action listeners
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Create the JPanel and add the components to it
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(textField);
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        // Create the JFrame and add the JPanel and JList to it
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Add the new task to the model
            model.addElement(textField.getText());
            textField.setText("");
        } else if (e.getSource() == editButton) {
            // Get the selected task and allow the user to edit it
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                String task = model.getElementAt(selectedIndex);
                String editedTask = JOptionPane.showInputDialog("Edit Task", task);
                if (editedTask != null) {
                    model.setElementAt(editedTask, selectedIndex);
                }
            }
        } else if (e.getSource() == deleteButton) {
            // Remove the selected task from the model
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                model.removeElementAt(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new TodoList();
    }
}