package db_objs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class myJDBC {
    // database configurations 
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/LoginDatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    // if validate return the object with the user's information
    public static User validateLogin(String username, String password) {
        try {
            // Register JDBC driver
        
            // establish a connection to the database using configurations
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // create sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            // repace the ? with values
            // parameter index referring to the iteration of the ? so 1 is the first ? and 2 is the second ?
            preparedStatement.setString (1, username);
            preparedStatement.setString (2, password);

            // execute query and store into a result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // next() returns true or false 
            // true - query returned data and result set now points to the first row
            // false - query returned no data and the result set equals to null
            if(resultSet.next()){
                // success
                // get id
                int userId = resultSet.getInt("id");

                // get current balance
                BigDecimal goalmenuGUI = resultSet.getBigDecimal("current_balance");

                // return user object 
                return new User(userId, username, password, goalmenuGUI);

            }

        
        }catch(SQLException e) {
            e.printStackTrace();
        }

        // not valid user
        return null;
    }

    // sign ups new user to the database
    // true - register success 
    // false - register fails
    public static boolean signup(String username, String password) {

        try{
            // first we  will need to check if the username has already been taken
            if(!checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(username, password) " +
                    "VALUES(?, ?)"
                );

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    // check if username already exists in the db 
    // true - user exists 
    // false - user diesn't exist 
    private static boolean checkUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(

            "SELECT * FROM users WHERE username = ?"
            );

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            // this means that the query returned no data meaning that the username is available
            if(!resultSet.next()) {
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}