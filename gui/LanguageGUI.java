package gui;
import javax.swing.*;

import constants.CommonConstants;

import java.awt.*;
import java.awt.event.*;

public class LanguageGUI extends JFrame {
    private JComboBox<String> languageComboBox;

    public LanguageGUI() {
        super("LanguageGUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    private void addGUIComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel languageLabel = new JLabel("Select Language: ");
        languageLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Increase font size
        languageComboBox = new JComboBox<>(new String[]{"English", "Spanish", "French", "German", "Indonesian"}); // Add more languages as needed
        topPanel.add(languageLabel);
        topPanel.add(languageComboBox);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton applyButton = new JButton("Apply");
        applyButton.setFont(new Font("Arial", Font.BOLD, 30)); // Increase font size
        centerPanel.add(applyButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 0, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the GoalCalculationGUI when the button is clicked
                SettingsGUI SettingsGUI = new SettingsGUI(null);
                SettingsGUI.setVisible(true);
                LanguageGUI.this.dispose();
            }
        });
        add(backButton);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Add action listener to the apply button
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyLanguageChange();
            }
        });
    }

    private void applyLanguageChange() {
        String selectedLanguage = (String) languageComboBox.getSelectedItem();

        
        // This could involve setting locale, updating UI elements, etc.
       
        System.out.println("Selected Language: " + selectedLanguage);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LanguageGUI().setVisible(true);
            }
        });
    }
}
