# Java To-Do List App 

##  Project Overview

This is a simple **Java Swing GUI application** that allows users to maintain a **To-Do List**.
You can **add tasks** to the list and **delete selected tasks** using buttons.

It is built using only **core Java and Swing (no external libraries)**, making it lightweight and beginner-friendly.

---

##  Tools & Technologies

* **Language:** Java
* **GUI Toolkit:** Swing (built-in with Java)
* **IDE:** IntelliJ IDEA CE / Eclipse (or any Java IDE)

---

## How to Run

1. Copy the `ToDoApp.java` file into your project folder.
2. Compile and run it using your IDE or terminal:

   ```bash
   javac ToDoApp.java
   java ToDoApp
   ```
3. A window will open where you can manage your tasks.

---

##  Application Features

* **Add Task:** Enter text in the input field and click **"Add Task"** to insert it into the list.
* **Delete Task:** Select a task from the list and click **"Delete Task"** to remove it.
* **Validation:** Prevents adding empty tasks and deleting without selection.

---

##  Code Explanation

### 1. JFrame Setup

```java
setTitle("To-Do List App");
setSize(400, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
```

* Creates the main window with a title, size, close behavior, and layout.

---

### 2. Task Input Field

```java
taskInput = new JTextField();
add(taskInput, BorderLayout.NORTH);
```

* A text field at the **top** of the frame where the user types tasks.

---

### 3. Task List

```java
taskListModel = new DefaultListModel<>();
taskList = new JList<>(taskListModel);
add(new JScrollPane(taskList), BorderLayout.CENTER);
```

* `DefaultListModel` holds the list of tasks.
* `JList` displays the tasks in the center with scroll support.

---

### 4. Buttons (Add & Delete)

```java
JButton addButton = new JButton("Add Task");
JButton deleteButton = new JButton("Delete Task");
```

* Two buttons placed at the **bottom** inside a panel.

---

### 5. Add Task Action

```java
addButton.addActionListener(e -> {
    String task = taskInput.getText().trim();
    if (!task.isEmpty()) {
        taskListModel.addElement(task);
        taskInput.setText(""); // clear input field
    } else {
        JOptionPane.showMessageDialog(null, "Enter a task first!");
    }
});
```

* Reads text from input.
* Adds to the task list if not empty.
* Shows a popup if user tries to add an empty task.

---

### 6. Delete Task Action

```java
deleteButton.addActionListener(e -> {
    int selectedIndex = taskList.getSelectedIndex();
    if (selectedIndex != -1) {
        taskListModel.remove(selectedIndex);
    } else {
        JOptionPane.showMessageDialog(null, "Select a task to delete!");
    }
});
```

* Deletes the **selected task** from the list.
* Shows a popup if no task is selected.

---

##  Sample Run

1. Enter `Buy groceries` → Click **Add Task** → Task appears in list.
2. Select `Buy groceries` → Click **Delete Task** → Task is removed.

---

##  Deliverables

* `ToDoApp.java` (main code)
* `README.md` (this file for explanation)

