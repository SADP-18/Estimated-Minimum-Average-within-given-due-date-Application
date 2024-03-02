import db_objs.User;
import gui.GoalmenuGUI;
import gui.LoginGUI;
import gui.SettingsGUI;
import gui.signUpGUI;
import gui.stockMenuGUI;
import gui.ContactUsGUI;


import javax.swing.*;


public class AppLauncher {
    public static void main(String[] args) {
        //use invokeLater to make updates to the GUI more thread-safe
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             new LoginGUI().setVisible(true);
            // new signUpGUI().setVisible(true);
               // new GoalmenuGUI(
                   // new User(1, "username", "password", new BigDecimal("20.00"))
               // ).setVisible(true);
              // new stockMenuGUI(new User(1, "username", "password", new BigDecimal("20.00"))
              // ).setVisible(true);
              //new ContactUsGUI().setVisible(true);
              //new SettingsGUI(null).setVisible(true);
               
            }
        });
    }
}
