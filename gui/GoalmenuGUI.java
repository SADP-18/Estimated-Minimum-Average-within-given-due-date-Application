package gui;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// maybe 
import javax.swing.*;



import db_objs.User;

import constants.CommonConstants;

// the main menu of the program

public class GoalmenuGUI extends JFrame{
    
    

    public GoalmenuGUI(User user) {
        super("Keep It Up!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);
        
        addGUIComponents();
    }

    public void addGUIComponents() {
    
    // (testing) first from video about making current balance POTENTIALLY COULD BE FOR ROWS)
    JLabel GoalmenuLabel = new JLabel("Goal Menu");
    GoalmenuLabel.setBounds(0, 80, getWidth() - 10,30);
    GoalmenuLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    GoalmenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(GoalmenuLabel);

    
    JButton stockButton = new JButton("Stock:");
    stockButton.setBounds(5, 130, getWidth()-580,30);
    stockButton.setFont(new Font("Dialog", Font.BOLD, 22));
    stockButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the stockMenuGUI when the button is clicked
            stockMenuGUI stockMenuGUI = new stockMenuGUI(null);
            stockMenuGUI.setVisible(true);
        }
    });
    add(stockButton);

    JButton ContactusButton = new JButton("Contact Us");
    ContactusButton.setBounds(5, 40, getWidth()-580,30);
    ContactusButton.setFont(new Font("Dialog", Font.BOLD, 22));
    ContactusButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            ContactUsGUI ContactUsGUI = new ContactUsGUI();
            ContactUsGUI.setVisible(true);
        }
    });
    add(ContactusButton);

    JLabel settingsLabel = new JLabel("<html><a href=\"#\">Settings</a></html>");
    settingsLabel.setBounds(25,0, getWidth()-580,30);
    settingsLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    settingsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    settingsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                GoalmenuGUI.this.dispose();

                // launch the sign up gui
                new SettingsGUI(null).setVisible(true);
                
            }
        });
   
    add(settingsLabel);  

    JButton NotificationsButton = new JButton("Notifications");
    NotificationsButton.setBounds(200, 0, getWidth()-400,30);
    NotificationsButton.setFont(new Font("Dialog", Font.BOLD, 22));
    NotificationsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            NotificationsGUI NotificationsGUI = new NotificationsGUI();
            NotificationsGUI.setVisible(true);
        }
    });
    add(NotificationsButton);
     

    // (testing) button button 
    JButton firstRowButton = new JButton("Press Row to add");
firstRowButton.setBounds(15, 180, getWidth() - 50, 50);
firstRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
firstRowButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        GoalmenuGUI.this.dispose();
        // Open the GoalCalculationGUI when the button is clicked
        goalCalculationGUI goalCalculationGUI = new goalCalculationGUI();
        goalCalculationGUI.setVisible(true);
    }
});
add(firstRowButton);



    // (testing) Another Button
    JButton secondRowButton = new JButton("Press Row to add");
    secondRowButton.setBounds(15, 250, getWidth()-50,50);
    secondRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    secondRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            goalCalculationGUI goalCalculationGUI = new goalCalculationGUI();
            goalCalculationGUI.setVisible(true);
        }
    });
    add(secondRowButton);
    

    JButton thirdRowButton = new JButton("Press Row to add");
    thirdRowButton.setBounds(15, 320, getWidth()-50,50);
    thirdRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    thirdRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            goalCalculationGUI goalCalculationGUI = new goalCalculationGUI();
            goalCalculationGUI.setVisible(true);
        }
    });
    add(thirdRowButton);
    
    JButton fourthRowButton = new JButton("Press Row to add");
    fourthRowButton.setBounds(15, 390, getWidth()-50, 50);
    fourthRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    fourthRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            goalCalculationGUI goalCalculationGUI = new goalCalculationGUI();
            goalCalculationGUI.setVisible(true);
        }
    });
    add(fourthRowButton);

    JButton fifthRowButton = new JButton("Press Row to add");
    fifthRowButton.setBounds(15, 460, getWidth()-50, 50);
    fifthRowButton.setFont(new Font("Dialog", Font.BOLD, 22));
    fifthRowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GoalmenuGUI.this.dispose();
            // Open the GoalCalculationGUI when the button is clicked
            goalCalculationGUI goalCalculationGUI = new goalCalculationGUI();
            goalCalculationGUI.setVisible(true);
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
