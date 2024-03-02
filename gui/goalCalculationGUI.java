package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

import constants.CommonConstants;

public class goalCalculationGUI extends JFrame {
    private JTextField nameofgoalField;
    private JTextField currentnumberField;
    private JTextField goalnumberField;
    private JTextField dueDateField;
    private JRadioButton monthlyRadioButton;
    private JRadioButton weeklyRadioButton;
    private JLabel outputLabel;

    public goalCalculationGUI() {
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
                goalCalculationGUI.this.dispose();
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

                String notificationMessage = "";
                if (notificationType.equals("monthly")) {
                    notificationMessage = sendNotificationMonthly(current, goal, nameofgoal, dueDate);
                    
                } else if (notificationType.equals("weekly")) {
                    notificationMessage = sendNotificationWeekly(current, goal, nameofgoal, dueDate);
                    
                } else {
                    notificationMessage = "Invalid type. Please choose 'Monthly' or 'Weekly'.";
                }

                // Display the output of performGoalCalculation
                String output = performGoalCalculation(nameofgoal, current, goal);
                // Format output as HTML to split into lines
        String htmlOutput = "<html>" + output.replaceAll("\n", "<br>") + "</html>";

        // Combine notificationMessage and output
        String combinedMessage = notificationMessage + "<br><br>" + htmlOutput;

        outputLabel.setText("<html>" + combinedMessage + "</html>");
            }
        });

        // Output Label
        outputLabel = new JLabel();
        outputLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Delete button
    JButton deleteButton = new JButton("Delete");
    deleteButton.setFont(new Font("Dialog", Font.BOLD, 18));
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all text fields
            nameofgoalField.setText("");
            currentnumberField.setText("");
            goalnumberField.setText("");
            dueDateField.setText("");
            // Clear radio buttons selection
            monthlyRadioButton.setSelected(false);
            weeklyRadioButton.setSelected(false);
        }
    });
        springLayout.putConstraint(SpringLayout.WEST, deleteButton, 50, SpringLayout.WEST, calculationPanel);
        springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 300, SpringLayout.NORTH, calculationPanel);
        calculationPanel.add(deleteButton);

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
    Calendar currentCal = Calendar.getInstance();
    Calendar dueDateCal = Calendar.getInstance();
    dueDateCal.setTime(dueDate);

    int remainingMonths = dueDateCal.get(Calendar.MONTH) - currentCal.get(Calendar.MONTH);
    int remainingYears = dueDateCal.get(Calendar.YEAR) - currentCal.get(Calendar.YEAR);
    int totalRemainingMonths = remainingYears * 12 + remainingMonths;
    double minimumValuePerMonth = (goal - current) / totalRemainingMonths;

    String firstLine = String.format("To reach the target value of %.2f by %tF for %s,", goal, dueDate, nameOfGoal);
    String secondLine = String.format("you need to make a minimum of %.2f per month.", minimumValuePerMonth);

    return firstLine + "\n" + secondLine;
    }

    private String sendNotificationWeekly(double current, double goal, String nameOfGoal, Date dueDate) {
        long weeksRemaining = (dueDate.getTime() - System.currentTimeMillis()) / (7 * 24 * 60 * 60 * 1000);
        double minimumValuePerWeek = (goal - current) / weeksRemaining;
    
    String firstLine = String.format("To reach the target value of %.2f by %tF for %s,", goal, dueDate, nameOfGoal);
    String secondLine = String.format("you need to make a minimum of %.2f per week.", minimumValuePerWeek);

    return firstLine + "\n" + secondLine;
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
