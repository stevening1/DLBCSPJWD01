package com.bankapp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Creates date of session and holds user transaction details
public class DepWithBean implements Serializable {
	 private static final long serialVersionUID = 1L;
	    
	 	private String username;
	 	private float amount;
	 	
	 	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        private String date = df.format(now);
	 	
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
	
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
	 
	    
	  
	    
}
