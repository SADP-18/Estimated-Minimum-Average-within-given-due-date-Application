package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import constants.CommonConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextSizeGUI extends JFrame {
    private JLabel textLabel;
    private JSlider sizeSlider;

    public TextSizeGUI() {
        super("Text Size Changer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);


        addGUIComponents();
    }

    private void addGUIComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create panel to hold text label and back button
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create label with initial font size
        textLabel = new JLabel("Goal Menu");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(textLabel, BorderLayout.CENTER);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 10, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to SettingsGUI
                SettingsGUI settingsGUI = new SettingsGUI(null);
                settingsGUI.setVisible(true);
                TextSizeGUI.this.dispose();
            }
        });
        contentPanel.add(backButton, BorderLayout.NORTH);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Create slider to adjust font size
        sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 40, 20);
        sizeSlider.setMajorTickSpacing(5);
        sizeSlider.setMinorTickSpacing(1);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newSize = sizeSlider.getValue();
                Font currentFont = textLabel.getFont();
                textLabel.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), newSize));
            }
        });
        mainPanel.add(sizeSlider, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextSizeGUI().setVisible(true);
            }
        });
    }
}
