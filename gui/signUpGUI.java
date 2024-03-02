package gui;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import constants.CommonConstants;
import db_objs.myJDBC;

public class signUpGUI extends JFrame {
    public signUpGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(springLayout);

        // name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField nameField = new JTextField(CommonConstants.TEXTFIELD_SIZE);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 35, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 85, SpringLayout.NORTH, signUpPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 135, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 85, SpringLayout.NORTH, signUpPanel);

        signUpPanel.add(nameLabel);
        signUpPanel.add(nameField);

        // password
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField(CommonConstants.TEXTFIELD_SIZE);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 35, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 135, SpringLayout.NORTH, signUpPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 135, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 135, SpringLayout.NORTH, signUpPanel);

        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);

        // re-type password
        JLabel rePasswordLabel = new JLabel("Re-type Password:");
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField rePasswordField = new JPasswordField(CommonConstants.TEXTFIELD_SIZE);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, rePasswordLabel, 35, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, rePasswordLabel, 185, SpringLayout.NORTH, signUpPanel);
        springLayout.putConstraint(SpringLayout.WEST, rePasswordField, 135, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, rePasswordField, 185, SpringLayout.NORTH, signUpPanel);

        signUpPanel.add(rePasswordLabel);
        signUpPanel.add(rePasswordField);

        // sign up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Dialog", Font.BOLD, 18));
        springLayout.putConstraint(SpringLayout.WEST, signUpButton, 150, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, signUpButton, 250, SpringLayout.NORTH, signUpPanel);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String username = nameField.getText();
                // get password
                String password = String.valueOf(passwordField.getPassword());
                // get re password
                String rePassword = String.valueOf(rePasswordField.getPassword());

                // we will need to validate the user input
                if (validateUserInput(username, password, rePassword)) {
                    // attempt to register the user to the database
                    if (myJDBC.signUp(username, password)) {
                        // register success
                        // dispose of this gui
                        signUpGUI.this.dispose();

                        // launch the login gui
                        LoginGUI loginGUI = new LoginGUI();
                        loginGUI.setVisible(true);

                        // create a result dialog
                        JOptionPane.showMessageDialog(loginGUI, "Successful Signed Up Account!");
                    } else {
                        // registered failed
                        JOptionPane.showMessageDialog(signUpGUI.this, "Error: Username already taken");
                    }
                } else {
                    // invalid user input
                    JOptionPane.showMessageDialog(signUpGUI.this,
                            "Error: Username must be at least 6 characters\n" +
                                    "and/or Password must match");
                }


            }
        });

        signUpPanel.add(signUpButton);

        // Login label
        JLabel loginLabel = new JLabel("<html><a href=\"#\">Already have an account? Login here</a></html>");
        springLayout.putConstraint(SpringLayout.WEST, loginLabel, 35, SpringLayout.WEST, signUpPanel);
        springLayout.putConstraint(SpringLayout.NORTH, loginLabel, 10, SpringLayout.SOUTH, signUpButton);
        loginLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                signUpGUI.this.dispose();

                // launch the login gui
                new LoginGUI().setVisible(true);
                
            }

        });
        signUpPanel.add(loginLabel);

        this.getContentPane().add(signUpPanel);
    }

    private boolean validateUserInput(String username, String password, String rePassword) {
        // all fields must have a value
        if (username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        // username has to be at least 6 characters long
        if (username.length() < 6) return false;

        // password and re-password must be the same
        if (!password.equals(rePassword)) return false;

        // passes validation
        return true;
    }
}
