package com.bankapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   private RegisterDao userDao;

	    public void init() {
	        userDao = new RegisterDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	    	//Gets registration details from register.jsp and assigns values to variables
	        String firstName = request.getParameter("firstname");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        //Adds registration details to user instance of RegisterBean
	        RegisterBean user = new RegisterBean();
	        user.setFirstName(firstName);
	        user.setUsername(username);
	        user.setPassword(password);
	       
	        //If username does not exist, call the registerUser and addLoginCredentials functions from userDao
	        //And write a message to the screen and redirect to login.jsp
	        try {
				if(userDao.checkUsername(username)==false) {
					 try {
				            userDao.registerUser(user);
				            userDao.addLoginCredentials(user);
				            PrintWriter out = response.getWriter();
				            out.println("<script>alert(\"You have registered successfully!\");</script>");
				            request.getRequestDispatcher("login.jsp").include(request, response);
				            out.close();
				    		
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				   
				} else {
					//Write message if username exists and redirect to register.jsp
					PrintWriter out = response.getWriter();
					out.println("<script>alert(\"Username already exists! Choose another username\");</script>");
		            request.getRequestDispatcher("register.jsp").include(request, response);
		            out.close();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	    }

}
