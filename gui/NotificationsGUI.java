package gui;

import javax.swing.*;

import constants.CommonConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationsGUI extends JFrame {
    private JCheckBox goalCheckBox;
    private JCheckBox stockCheckBox;
    private JTextArea notificationArea;

    public NotificationsGUI() {
        super("Notification");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);
        
        addGUIComponents();
    }

    private void addGUIComponents() {
        JPanel topPanel = new JPanel();
        JLabel notificationTypeLabel = new JLabel("Notification Types:");
        goalCheckBox = new JCheckBox("Goal");
        stockCheckBox = new JCheckBox("Stock");
        topPanel.add(notificationTypeLabel);
        topPanel.add(goalCheckBox);
        topPanel.add(stockCheckBox);

        JPanel centerPanel = new JPanel(new BorderLayout());
        notificationArea = new JTextArea();
        notificationArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notificationArea);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton showButton = new JButton("Show Notifications");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNotifications();
            }
        });
        bottomPanel.add(showButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(0, 0, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the GoalCalculationGUI when the button is clicked
                GoalmenuGUI GoalmenuGUI = new GoalmenuGUI(null);
                GoalmenuGUI.setVisible(true);
                NotificationsGUI.this.dispose();
            }
        });
        add(backButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private void showNotifications() {
        StringBuilder message = new StringBuilder();

        if (goalCheckBox.isSelected()) {
            message.append("Goal notification: Name = Goal, Current = ?, Target Value = ?\n");
        }

        if (stockCheckBox.isSelected()) {
            message.append("Stock notification: Name = Stock, Current = ?, Limit = ?\n");
        }

        if (message.length() == 0) {
            message.append("No notification types selected.");
        }

        notificationArea.setText(message.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotificationsGUI().setVisible(true);
            }
        });
    }
}
