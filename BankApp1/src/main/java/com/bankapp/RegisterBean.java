package com.bankapp;

import java.io.Serializable;

//Collects user registration details
public class RegisterBean implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	    private String firstName;
	    private String username;
	    private String password;
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	  
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
}
