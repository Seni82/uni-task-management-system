package view;
import model.Model;
import model.Task;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author ganiyuisola
 * @version 20/10/2020
 */
public class AddTaskPanel extends AbstractCommonComponents {

    static final int FIELD_START = 100;
    public static final int MIN_WIDTH = 430;
    public static final int MIN_HEIGHT = 300;

    private JLabel projectName;
    private JTextField projectNameEntry;
    private JLabel taskName;
    private JTextField taskNameEntry;
    private JLabel subTask1;
    private JTextField subTask1NameEntry;
    private JLabel subTask2;
    private JTextField subTask2NameEntry;
    private JLabel subTask3;
    private JTextField subTask3NameEntry;
    private JLabel description;
    private JTextField descriptionEntry;
    private JLabel subTask4;
    private JTextField subTask4NameEntry;
    private JTextField subTask5NameEntry;
    private JLabel subTask5;
    private JLabel taskDueDate;
    private JTextField taskDueDateEntry;
    private JLabel taskDueTime;
    private JTextField taskDueTimeEntry;
    private JComboBox importanceDropDownComponent;
    private JLabel lowAndMediumPriorityRangeDescription;
    private JLabel taskImportance;
    private JLabel highAndHighestPriotityRangeDescription;
    private JLabel estimatedTaskDuration;
    private JTextField estimatedTaskDurationField;

    private JButton clearTaskButton;
    private JButton taskUpdateButton;

    private JButton addTaskButton;
    public Model modelTask;


    public AddTaskPanel(String addTaskPanelTitle, Model model,int x, int y, int width, int height, Color color, Boolean createBorder, int boundsHeight) {
        super(addTaskPanelTitle, x, y, width,height, color, createBorder, boundsHeight);
        modelTask = model;
      //  this.model = modelTask;

        //Project Name and field
        createJLabel(projectName, "Project Name:",5 , 20, FIELD_START - 2, 15, color);
        projectNameEntry=createJTextField( FIELD_START , 18, 3*(this.getWidth()-120)/4, 20);

/*
        //Description and field name.
        createJLabel(description, "Description:",5 , 45, FIELD_START - 2, 15, color);
        createJTextField(descriptionEntry, FIELD_START , 43, this.getWidth()-120, 20);
      
        //Task Name Label and field name
        createJLabel(taskName, "Task Name",5 , 70, FIELD_START - 2, 15, color);
        createJTextField(taskNameEntry, FIELD_START , 68, 3*(this.getWidth()-120)/4, 20);

       
        //sub-task 1 (Needs to be made mandatory)
        createJLabel(subTask1, "Sub Task 1:",5, 95, FIELD_START - 2, 15, color);
        createJTextField(subTask1NameEntry, FIELD_START , 93, 3*(this.getWidth()-120)/4, 20);

        //sub-task 2 (optional)
        createJLabel(subTask2, "Sub Task 2:",5 , 120, FIELD_START - 2, 15, color);
        createJTextField(subTask2NameEntry, FIELD_START , 118, 3*(this.getWidth()-120)/4, 20);

        //sub-task 3 (optional)
        createJLabel(subTask3, "Sub Task 3:",5 , 145, FIELD_START - 2, 15, color);
        createJTextField(subTask3NameEntry, FIELD_START , 143, 3*(this.getWidth()-120)/4, 20);

        //sub-task 4 (optional)
        createJLabel(subTask4, "Sub Task 4:",5 , 170, FIELD_START - 2, 15, color);
        createJTextField(subTask4NameEntry, FIELD_START , 168, 3*(this.getWidth()-120)/4, 20);

        //sub-task 5 (optional)
        createJLabel(subTask5, "Sub Task 5:",5 , 195, FIELD_START - 2, 15, color);
        createJTextField(subTask5NameEntry, FIELD_START , 193, 3*(this.getWidth()-120)/4, 20);


        //Task due date field
        createJLabel(taskDueDate, "Task Due Date:",5, 220, FIELD_START - 2, 15, color);
        createJTextField(taskDueDateEntry, FIELD_START, 218, (this.getWidth()-220)/2, 20);

        //Task due time field
        createJLabel(taskDueTime, "Due Time:",138+(this.getWidth()-220)/2, 220, FIELD_START - 27, 15, color);
        createJTextField(taskDueTimeEntry, 200+(this.getWidth()-220)/2, 218, (this.getWidth()-220)/2, 20);
*/
        //Importance field and combo box.
        createJLabel(taskImportance, "Importance:",5, 250, FIELD_START - 2, 15, color);
        importanceDropDownComponent = new JComboBox(model.getImportanceModel());
        importanceDropDownComponent.setBounds(FIELD_START, 248, (this.getWidth()-120)/3, 20);
        this.add(importanceDropDownComponent);


        createJLabel(lowAndMediumPriorityRangeDescription, "[0 - 3 : LOW]        " +
                        "[4 - 6 : MEDIUM]",
                110+(this.getWidth()-120)/3, 248, 2*(this.getWidth()-120)/3, 15, color);

        createJLabel(highAndHighestPriotityRangeDescription, "[7 - 9 : HIGH]        " +
                        "[10 : HIGHEST]",
                110+(this.getWidth()-120)/3, 263, 2*(this.getWidth()-120)/3, 15, color);

/*
        //Estimated Duration and field name.
        createJLabel(estimatedTaskDuration, "Est. Duration:",5, 283, FIELD_START-2, 15, color);
        createJTextField(estimatedTaskDurationField, FIELD_START, 281, (this.getWidth()-220)/2, 20);
*/
        //create buttons
        addTaskButton=createJButton("Add Task", this.getWidth()/4-50, height-42, 100, 40, true,Color.blue,true);
        //createJButton(taskUpdateButton,"Update Task",this.getWidth()/2-50, height-42, 100,40, false, Color.blue, true);
        //createJButton(clearTaskButton,"Clear Field",3*this.getWidth()/4-50, height-42, 100,40, false, Color.blue, true);
        
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (projectNameEntry.getText().isEmpty() ){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Please complete compulsory fields.");
                }
                else{
                    Task newTask = new Task(projectNameEntry.getText(), importanceDropDownComponent.getSelectedIndex());

                    modelTask.addTask(newTask);
                    //modelTask.taskTreeModel.insertNodeInto(new DefaultMutableTreeNode(projectNameEntry.getText()), model.rootNode, 0);
                  //  modelTask.getTaskTreeModel().fireTreeNodeAdded((TreeNode) newTask);
                }

            }
        });
    }
}


