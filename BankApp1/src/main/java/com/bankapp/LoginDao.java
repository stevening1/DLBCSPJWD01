package com.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {
	//Checks to see if username and password combination exists in database
    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        
        //Connects to database
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");

            
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from logindetails where username = ? and password = ? ")) {
            //Adds username and password from loginBean to SQL query
        	preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            //Executes query
            ResultSet rs = preparedStatement.executeQuery();
            //If rs.next(), then login credentials are correct and exist
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }
    
    //Shows error message in console if there is an SQL exception
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
