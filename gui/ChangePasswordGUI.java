package gui;
import javax.swing.*;

import constants.CommonConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordGUI extends JFrame {
    private JTextField currentPasswordField;
    private JPasswordField newPasswordField;

    public ChangePasswordGUI() {
        super("Change Password");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addComponents();
    }

    private void addComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel for text fields
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel currentPasswordLabel = new JLabel("Current Password:");
        currentPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        currentPasswordField = new JTextField();
        currentPasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        newPasswordField = new JPasswordField();
        newPasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        fieldsPanel.add(currentPasswordLabel);
        fieldsPanel.add(currentPasswordField);
        fieldsPanel.add(newPasswordLabel);
        fieldsPanel.add(newPasswordField);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton changeButton = new JButton("Change Password");
        changeButton.setFont(new Font("Dialog", Font.BOLD, 18));
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChangePassword();
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Dialog", Font.BOLD, 18));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to SettingsGUI
                SettingsGUI settingsGUI = new SettingsGUI(null);
                settingsGUI.setVisible(true);
                ChangePasswordGUI.this.dispose();
            }
        });
        buttonPanel.add(changeButton);
        buttonPanel.add(backButton);

        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    private void handleChangePassword() {
        // Get current and new passwords
        String currentPassword = currentPasswordField.getText();
        String newPassword = new String(newPasswordField.getPassword());

        // Perform password change here
        // Replace this with your actual logic to change the password
        System.out.println("Current Password: " + currentPassword);
        System.out.println("New Password: " + newPassword);

        // Ask for confirmation
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to change the password?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            // Password change confirmed
            // Replace this with your actual logic for password change confirmation
            System.out.println("Password change confirmed.");
        } else {
            // User canceled password change
            System.out.println("Password change canceled.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordGUI().setVisible(true);
            }
        });
    }
}
