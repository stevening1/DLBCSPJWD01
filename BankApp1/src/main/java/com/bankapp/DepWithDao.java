package com.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepWithDao {
	public void transaction(DepWithBean transDetails) throws ClassNotFoundException {
        //SQL query that inserts username, date, and amount into database
		String query = "INSERT INTO transactions(username, date, amount) VALUES(?, ?, ?);";

		//Connects to database and runs query
        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
	
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            
	            //Collects query values from transDetails (DepWithBean.java)
	            preparedStatement.setString(1, transDetails.getUsername());
	            preparedStatement.setString(2, transDetails.getDate());
	            preparedStatement.setFloat(3, transDetails.getAmount());
	           
	            preparedStatement.executeUpdate();
	     
        } catch (SQLException e) {
            // process sql exception
        	e.printStackTrace();
        }
        
    }
  
}
