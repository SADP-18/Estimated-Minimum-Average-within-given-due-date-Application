package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import constants.CommonConstants;
import db_objs.User;

public class SettingsGUI extends JFrame {
    public SettingsGUI(User user) {
        super("Settings");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);
        
        addGUIComponents();
    }

    public void addGUIComponents() {
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(0, 40, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the GoalCalculationGUI when the button is clicked
                GoalmenuGUI GoalmenuGUI = new GoalmenuGUI(null);
                GoalmenuGUI.setVisible(true);
                SettingsGUI.this.dispose();
            }
        });
        add(backButton);

    JButton ContactusButton = new JButton("Contact Us");
    ContactusButton.setBounds(0,0, getWidth()-580,30);
    ContactusButton.setFont(new Font("Dialog", Font.BOLD, 22));
    ContactusButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            ContactUsGUI ContactUsGUI = new ContactUsGUI();
            ContactUsGUI.setVisible(true);
            SettingsGUI.this.dispose();
        }
    });
    add(ContactusButton);

    JButton languageButton = new JButton("Language");
        languageButton.setBounds(15, 180, getWidth() - 50, 50);
        languageButton.setFont(new Font("Dialog", Font.BOLD, 22));
        languageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LANGUAGE GUI when the button is clicked
                LanguageGUI LanguageGUI = new LanguageGUI();
                LanguageGUI.setVisible(true);
                SettingsGUI.this.dispose();
            }
        });
        add(languageButton);

        JButton NotificationButton = new JButton("Notificaton");
        NotificationButton.setBounds(15, 250, getWidth()-50,30);
        NotificationButton.setFont(new Font("Dialog", Font.BOLD, 22));
        
        add(NotificationButton);

        JButton ChangePasswordButton = new JButton("Change Password");
        ChangePasswordButton.setBounds(15, 320, getWidth()-50,30);
        ChangePasswordButton.setFont(new Font("Dialog", Font.BOLD, 22));
        
        add(ChangePasswordButton);

        JButton LogoutButton = new JButton("Logout");
        LogoutButton.setBounds(15, 390, getWidth()-50,30);
        LogoutButton.setFont(new Font("Dialog", Font.BOLD, 22));
        LogoutButton.addActionListener(new ActionListener() {
             @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
            // Open the LOGIN GUI when the user clicks "Yes"
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
            SettingsGUI.this.dispose(); // Close the current window
        } else {
            // Do nothing if the user clicks "No" or closes the dialog
        }
    }
});
        add(LogoutButton);
        
        JLabel fakeLabel = new JLabel("");
    fakeLabel.setBounds(0, 46, getWidth() - 50,50);
    fakeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    fakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(fakeLabel);
}
}
