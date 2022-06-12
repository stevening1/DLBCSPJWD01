package com.bankapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;




public class DepWithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		   DepWithDao transactionDao;

		    transactionDao = new DepWithDao();
		    HttpSession session = request.getSession();
            
		    String username = (String) session.getAttribute("username"); //assigns username from session to variable username
		    String action = request.getParameter("action"); //assigns action value from depwith.jsp
		    System.out.println(action);
		   
		    //Creates amount variable and converts amount to a negative number is action is withdraw
		    float amount;
		    
		    if(action.equals("deposit")) {
		    	amount = Float.parseFloat(request.getParameter("amount"));
		    } else {
		    	amount = -(Float.parseFloat(request.getParameter("amount")));
		    }
		   
		    //Sets username and amount to DepwithBean.java and gets date from DepWithBean.java
	        DepWithBean transDetails = new DepWithBean();
	        transDetails.setUsername(username);
	        transDetails.getDate();
	       
	        transDetails.setAmount(amount);
	       
	        //Calls transaction function from DepWithDao.java and passes transDetails. Shows message on screen and redirects to home.jsp
	        	try {
	        		transactionDao.transaction(transDetails);
	        		PrintWriter out = response.getWriter();
		            out.println("<script>alert(\"Your transaction was successfully processed!\");</script>");
		            request.getRequestDispatcher("home.jsp").include(request, response);
		            out.close();
	        	} 
	        	catch (Exception e) {
	        		e.printStackTrace();
	        	} 
	        } 
	        
	 }


		        

