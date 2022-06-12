package com.bankapp;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpSession;




public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Removes username from session
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		//Writes log out message on screen
		PrintWriter out = response.getWriter();
		out.println("You have logged out successfully");
	}
	

}