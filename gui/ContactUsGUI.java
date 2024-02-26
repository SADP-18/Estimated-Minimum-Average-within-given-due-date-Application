package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import constants.CommonConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContactUsGUI extends JFrame {
    private JTextField nameField;
    private JTextArea feedbackArea;

    public ContactUsGUI() {
        super("Contact Us Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    private void addGUIComponents() {
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Contact Us");
        titleLabel.setBounds(0, 10, getWidth(), 30);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contactPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 60, 100, 30);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        contactPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 60, 200, 30);
        contactPanel.add(nameField);

        JLabel feedbackLabel = new JLabel("Feedback:");
        feedbackLabel.setBounds(30, 100, 100, 30);
        feedbackLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        contactPanel.add(feedbackLabel);

        feedbackArea = new JTextArea();
        feedbackArea.setBounds(140, 100, 200, 100);
        feedbackArea.setLineWrap(true);
        contactPanel.add(feedbackArea);

        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 10, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoalmenuGUI GoalmenuGUI = new GoalmenuGUI(null);
                GoalmenuGUI.setVisible(true);
                ContactUsGUI.this.dispose();
            }
        });
        add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 220, 100, 30);
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> contactInfo = new HashMap<>();
                contactInfo.put("name", nameField.getText());
                contactInfo.put("feedback", feedbackArea.getText());
                saveToFile(contactInfo);
            }
        });
        contactPanel.add(submitButton);

        this.getContentPane().add(contactPanel);
    }

    private void saveToFile(Map<String, String> contact) {
        String fileName = "contact_info.txt";
        String folderPath = "C:\\school stuff\\Computer Science\\Forms\\Product"; // Replace "your_folder_path" with your desired folder path
        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File(folderPath + File.separator + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Name: " + contact.get("name"));
            writer.newLine();
            writer.write("Feedback: " + contact.get("feedback"));
            writer.newLine();
            writer.flush();
            JOptionPane.showMessageDialog(this, "Contact information saved to file successfully!",
                    "File Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while saving contact information to file!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContactUsGUI().setVisible(true);
            }
        });
    }
}
