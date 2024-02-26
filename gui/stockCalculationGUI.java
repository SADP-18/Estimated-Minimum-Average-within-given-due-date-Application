package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import constants.CommonConstants;

public class stockCalculationGUI extends JFrame {
    private JTextField nameField;
    private JTextField limitnumberField;
    private JTextField currentnumberField;
    private JLabel nameLabelDisplay;
    private JLabel currentnumberLabelDisplay;
    private JLabel limitnumberLabelDisplay;

    public stockCalculationGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(springLayout);

        JLabel addstockLabel = new JLabel("Add Stock");
        addstockLabel.setBounds(0, 10, getWidth() - 10,30);
        addstockLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        addstockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(addstockLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 10, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockMenuGUI stockMenuGUI = new stockMenuGUI(null);
                stockMenuGUI.setVisible(true);
                stockCalculationGUI.this.dispose();
            }
            
        });
        add(backButton);

        // name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        nameField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // current number
        JLabel currentnumberLabel = new JLabel("Current Number:");
        currentnumberLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        currentnumberField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        // limit number
        JLabel limitnumberLabel = new JLabel("Limit Number:");
        limitnumberLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
        limitnumberField = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        nameLabelDisplay = new JLabel();
        currentnumberLabelDisplay = new JLabel();
        limitnumberLabelDisplay = new JLabel();

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String name = nameField.getText();
                String currentNumber = currentnumberField.getText();
                String limitNumber = limitnumberField.getText();

                // Set labels with input values
                nameLabelDisplay.setText("Name: " + name);
                currentnumberLabelDisplay.setText("Current Number: " + currentNumber);
                limitnumberLabelDisplay.setText("Limit Number: " + limitNumber);
            }
        });

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 50, SpringLayout.NORTH, submitPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 200, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 50, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, currentnumberLabel, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, currentnumberLabel, 100, SpringLayout.NORTH, submitPanel);
        springLayout.putConstraint(SpringLayout.WEST, currentnumberField, 200, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, currentnumberField, 100, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, limitnumberLabel, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, limitnumberLabel, 150, SpringLayout.NORTH, submitPanel);
        springLayout.putConstraint(SpringLayout.WEST, limitnumberField, 200, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, limitnumberField, 150, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, submitButton, 300, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, submitButton, 300, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, nameLabelDisplay, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabelDisplay, 350, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, currentnumberLabelDisplay, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, currentnumberLabelDisplay, 380, SpringLayout.NORTH, submitPanel);

        springLayout.putConstraint(SpringLayout.WEST, limitnumberLabelDisplay, 50, SpringLayout.WEST, submitPanel);
        springLayout.putConstraint(SpringLayout.NORTH, limitnumberLabelDisplay, 410, SpringLayout.NORTH, submitPanel);

        submitPanel.add(nameLabel);
        submitPanel.add(nameField);
        submitPanel.add(currentnumberLabel);
        submitPanel.add(currentnumberField);
        submitPanel.add(limitnumberLabel);
        submitPanel.add(limitnumberField);
        submitPanel.add(nameLabelDisplay);
        submitPanel.add(currentnumberLabelDisplay);
        submitPanel.add(limitnumberLabelDisplay);
        submitPanel.add(submitButton);

        this.getContentPane().add(submitPanel);
    }
}
