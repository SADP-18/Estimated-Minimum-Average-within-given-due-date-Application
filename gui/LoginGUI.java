package gui;

import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import db_objs.User;
import db_objs.myJDBC;
import constants.CommonConstants;

public class LoginGUI extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    private void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(springLayout);

        // name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // password
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameField = new JTextField(CommonConstants.TEXTFIELD_SIZE);
        passwordField = new JPasswordField(CommonConstants.TEXTFIELD_SIZE);

        // login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String username = nameField.getText();
                // get password
                String password = String.valueOf(passwordField.getPassword());
                // validate login
                User user = myJDBC.validateLogin(username, password);

                // if user is null it means invalid otherwise it is a valid account
                if (user != null) {
                    // means valid login

                    // dispose this gui
                    LoginGUI.this.dispose();

                    // launch app GUI
                    GoalmenuGUI goalmenuGUI = new GoalmenuGUI(user);
                    goalmenuGUI.setVisible(true);

                    // show success dialog
                    JOptionPane.showMessageDialog(goalmenuGUI, "Login Successful!");
                } else {
                    // invalid login
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Failed! Please try again");
                }
            }
        });
        add(loginButton);

        // sign up label
        JLabel signUpLabel = new JLabel("<html><a href=\"#\">Don't have an account? Sign Up Here</a></html>");
        signUpLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        signUpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adds an event listener so when the mouse is clicked it will launch the register gui
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                LoginGUI.this.dispose();

                // launch the sign up gui
                new signUpGUI().setVisible(true);

            }
        });

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 85, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 85, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 135, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 135, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, 150, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 250, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, signUpLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, signUpLabel, 10, SpringLayout.SOUTH, loginButton);

        loginPanel.add(nameLabel);
        loginPanel.add(nameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(signUpLabel);

        this.getContentPane().add(loginPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}
