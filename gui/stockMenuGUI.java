package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// maybe 
import javax.swing.*;



import db_objs.User;

import constants.CommonConstants;

// the main menu of the program

public class stockMenuGUI extends JFrame{
    

    public stockMenuGUI(User user) {
        super("Keep It Up!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);
        
        addGUIComponents();
    }

    public void addGUIComponents() {
    
        // (testing) first from video about making current balance POTENTIALLY COULD BE FOR ROWS)
        JLabel stockMenuLabel = new JLabel("Stock Menu");
        stockMenuLabel.setBounds(0, 80, getWidth() - 10,30);
        stockMenuLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        stockMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(stockMenuLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(5, 130, getWidth()-580,30);
        backButton.setFont(new Font("Dialog", Font.BOLD, 22));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the GoalCalculationGUI when the button is clicked
                GoalmenuGUI GoalmenuGUI = new GoalmenuGUI(null);
                GoalmenuGUI.setVisible(true);
                stockMenuGUI.this.dispose();
            }
        });
        add(backButton);

        JLabel settingsLabel = new JLabel("<html><a href=\"#\">Settings</a></html>");
    settingsLabel.setBounds(25,0, getWidth()-580,30);
    settingsLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    settingsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         settingsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                stockMenuGUI.this.dispose();

                // launch the sign up gui
                new SettingsGUI(null).setVisible(true);
                
            }
        });
    add(settingsLabel); 

    JButton firstRowButton = new JButton("Press Row to add");
    firstRowButton.setBounds(15, 180, getWidth() - 50, 50);
    firstRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    firstRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            stockCalculationGUI stockCalculationGUI = new stockCalculationGUI();
            stockCalculationGUI.setVisible(true);
            stockMenuGUI.this.dispose();
        }
    });
    add(firstRowButton);

    JButton secondRowButton = new JButton("Press Row to add");
    secondRowButton.setBounds(15, 250, getWidth() - 50, 50);
    secondRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    secondRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            stockCalculationGUI stockCalculationGUI = new stockCalculationGUI();
            stockCalculationGUI.setVisible(true);
            stockMenuGUI.this.dispose();
        }
    });
    add(secondRowButton);

    JButton thirdRowButton = new JButton("Press Row to add");
    thirdRowButton.setBounds(15, 320, getWidth() - 50, 50);
    thirdRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    thirdRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            stockCalculationGUI stockCalculationGUI = new stockCalculationGUI();
            stockCalculationGUI.setVisible(true);
            stockMenuGUI.this.dispose();
        }
    });
    add(thirdRowButton);

    JButton fourthRowButton = new JButton("Press Row to add");
    fourthRowButton.setBounds(15, 390, getWidth() - 50, 50);
    fourthRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    fourthRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            stockCalculationGUI stockCalculationGUI = new stockCalculationGUI();
            stockCalculationGUI.setVisible(true);
            stockMenuGUI.this.dispose();
        }
    });
    add(fourthRowButton);

    JButton fifthRowButton = new JButton("Press Row to add");
    fifthRowButton.setBounds(15, 460, getWidth() - 50, 50);
    fifthRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    fifthRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the GoalCalculationGUI when the button is clicked
            stockCalculationGUI stockCalculationGUI = new stockCalculationGUI();
            stockCalculationGUI.setVisible(true);
            stockMenuGUI.this.dispose();
        }
    });
    add(fifthRowButton);

    JLabel fakeLabel = new JLabel("");
    fakeLabel.setBounds(0, 46, getWidth() - 50,50);
    fakeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    fakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(fakeLabel);

    }
}