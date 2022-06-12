package com.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	String query1 = "SELECT username FROM user where username=?";    
	String query2 = "INSERT INTO user(firstname, username, password) VALUES(?, ?, ?);";
	String query3 = "INSERT INTO logindetails(username, password) VALUES(?, ?);";
	
	//Checks to see if username already exists
	public boolean checkUsername(String username) throws ClassNotFoundException {
		
		//Connects to database and executes query1
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
        	PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
        	preparedStatement1.setString(1, username);
        	ResultSet result = preparedStatement1.executeQuery();        
        	
        	//If username exists, one row will be output, i.e. rs.next() is true
        	if(result.next()) {
        		return true;
        		} else {
        			return false;
        		}
        	} catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
		return false;
        		 
	}
	
	//Adds registration details to the user table in the database
	public void registerUser(RegisterBean user) throws ClassNotFoundException {
	    	
		//Connects to database and executes query2
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        		preparedStatement2.setString(1, user.getFirstName());
	            preparedStatement2.setString(2, user.getUsername());
	            preparedStatement2.setString(3, user.getPassword());
	            preparedStatement2.executeUpdate();		
			} catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        	}
	   
	    }
	
	//Adds username and password to logindetails table in the database
	public void addLoginCredentials(RegisterBean user) throws ClassNotFoundException {
	    
		//Connects to database and executes query3
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
			PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
            preparedStatement3.setString(1, user.getUsername());
            preparedStatement3.setString(2, user.getPassword());
            preparedStatement3.executeUpdate();		
		} catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        	}
   
    }
	
		//Shows messages in the console to debug SQL exceptions
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
