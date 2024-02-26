package constants;
import db_objs.*;


public class CommonConstants {
    // store user information 
    protected User user;
    
    public CommonConstants(String title) {initialize(title);}
    private void initialize(String title) {
        
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    public CommonConstants(String title, User user ){
        // initialize user 
        this.user = user;
        
        initialize(title);

    }
    
    public final static String APP_NAME = "Keep It Up!";

    public final static int[] FRAME_SIZE = {720, 600};

    public static final int TEXTFIELD_SIZE = 25;
}
