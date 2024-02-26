package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import constants.CommonConstants;

public class goalCalculationGUI4 extends JFrame {
    private JTextField nameofgoalField;
    private JTextField currentnumberField;
    private JTextField goalnumberField;
    private JTextField dueDateField;
    private JRadioButton monthlyRadioButton;
    private JRadioButton weeklyRadioButton;
    private JLabel outputLabel;

    public goalCalculationGUI4() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel calculationPanel = new JPanel();
        calculationPanel.setLayout(springLayout);

        // name of goal
        JLabel nameofgoalLabel = new JLabel("Name of Goal:");
        nameofgoalLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        nameofgoalField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // current number
        JLabel currentnumberLabel = new JLabel("Current Number:");
        currentnumberLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        currentnumberField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // goal number
        JLabel goalnumberLabel = new JLabel("Goal Number:");
        goalnumberLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        goalnumberField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // due date
        JLabel dueDateLabel = new JLabel("Due Date (YYYY-MM-DD):");
        dueDateLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        dueDateField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // notification type
        JLabel notificationLabel = new JLabel("Notification Type:");
        notificationLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        monthlyRadioButton = new JRadioButton("Monthly");
        weeklyRadioButton = new JRadioButton("Weekly");

        ButtonGroup notificationGroup = new ButtonGroup();
        notificationGroup.add(monthlyRadioButton);
        notificationGroup.add(weeklyRadioButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 10, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoalmenuGUI GoalmenuGUI = new GoalmenuGUI(null);
                GoalmenuGUI.setVisible(true);
                goalCalculationGUI4.this.dispose();
            }
        });
        add(backButton);

        // button to perform calculations
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Dialog", Font.BOLD, 18));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from text fields
                String nameofgoal = nameofgoalField.getText();
                double current = Double.parseDouble(currentnumberField.getText());
                double goal = Double.parseDouble(goalnumberField.getText());
                Date dueDate = parseDate(dueDateField.getText());

                // Check which notification type is selected
                String notificationType = monthlyRadioButton.isSelected() ? "monthly" : "weekly";

                double percentage = calculatePercentage(current, goal);

                System.out.printf("Current Value: %s, Target Value: %s, Percentage: %.2f%%\n", current, goal, percentage);

                if (notificationType.equals("monthly")) {
                    String notificationMessage = sendNotificationMonthly(current, goal, nameofgoal, dueDate);
                    System.out.println("Type: " + notificationMessage);
                } else if (notificationType.equals("weekly")) {
                    String notificationMessage = sendNotificationWeekly(current, goal, nameofgoal, dueDate);
                    System.out.println("Type: " + notificationMessage);
                } else {
                    System.out.println("Invalid notification type. Please choose 'Monthly' or 'Weekly'.");
                }

                // Display the output of performGoalCalculation
                String output = performGoalCalculation(nameofgoal, current, goal);
                outputLabel.setText(output);

                
            }
        });

        // Output Label
        outputLabel = new JLabel();
        outputLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, nameofgoalLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameofgoalLabel, 50, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameofgoalField, 200, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameofgoalField, 50, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, currentnumberLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, currentnumberLabel, 100, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, currentnumberField, 200, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, currentnumberField, 100, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, goalnumberLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, goalnumberLabel, 150, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, goalnumberField, 200, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, goalnumberField, 150, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, dueDateLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, dueDateLabel, 200, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, dueDateField, 300, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, dueDateField, 200, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, notificationLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, notificationLabel, 250, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, monthlyRadioButton, 300, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, monthlyRadioButton, 250, SpringLayout.NORTH, calculationPanel);
        springLayout.putConstraint(SpringLayout.WEST, weeklyRadioButton, 400, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, weeklyRadioButton, 250, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, calculateButton, 300, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, calculateButton, 300, SpringLayout.NORTH, calculationPanel);

        springLayout.putConstraint(SpringLayout.WEST, outputLabel, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, outputLabel, 350, SpringLayout.NORTH, calculationPanel);

        calculationPanel.add(nameofgoalLabel);
        calculationPanel.add(nameofgoalField);
        calculationPanel.add(currentnumberLabel);
        calculationPanel.add(currentnumberField);
        calculationPanel.add(goalnumberLabel);
        calculationPanel.add(goalnumberField);
        calculationPanel.add(dueDateLabel);
        calculationPanel.add(dueDateField);
        calculationPanel.add(notificationLabel);
        calculationPanel.add(monthlyRadioButton);
        calculationPanel.add(weeklyRadioButton);
        calculationPanel.add(calculateButton);
        calculationPanel.add(outputLabel);

        this.getContentPane().add(calculationPanel);
    }

    private double calculatePercentage(double current, double goal) {
        return (current / goal) * 100;
    }

    private String sendNotificationMonthly(double current, double goal, String nameOfGoal, Date dueDate) {
        // Implementation for monthly notification
        return "Monthly Calculation"; // Replace this with your logic
    }

    private String sendNotificationWeekly(double current, double goal, String nameOfGoal, Date dueDate) {
        // Implementation for weekly notification
        return "Weekly Calculation"; // Replace this with your logic
    }

    private String performGoalCalculation(String nameofgoal, double currentnumber, double goal) {
        // Your goal calculation logic goes here
        // You can print the results or display them in another GUI
        return String.format("Goal Calculation: Name=%s, Current=%.2f, Goal=%.2f\n", nameofgoal, currentnumber, goal);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new goalCalculationGUI().setVisible(true);
            }
        });
    }
}
