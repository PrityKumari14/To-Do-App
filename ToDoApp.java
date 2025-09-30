package To_Do_App;

import javax.swing.*;
import java.awt.*;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel; // Stores tasks
    private JList<String> taskList; // Shows tasks
    private JTextField taskInput; // User enters tasks

    public ToDoApp() {
        // Frame setup
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ----------------- TOP PANEL (TextField + Add Button) -----------------
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));

        taskInput = new JTextField();
        taskInput.setPreferredSize(new Dimension(200, 30)); // Visible height
        JButton addButton = new JButton("Add Task");

        topPanel.add(taskInput, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // ----------------- CENTER (Task List) -----------------
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // ----------------- BOTTOM PANEL (Delete Button) -----------------
        JPanel bottomPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Task");
        bottomPanel.add(deleteButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // ----------------- ACTION LISTENERS -----------------
        // Add Task Action
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText(""); // Clear input field
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task first!");
            }
        });

        // Delete Task Action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete!");
            }
        });

        // ----------------- SHOW FRAME -----------------
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
