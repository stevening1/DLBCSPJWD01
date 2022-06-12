<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html>
<%
//String username = request.getParameter("username"); 
//Gets username from session
String username = (String) session.getAttribute("username");
%>

<html>
<head>
<!-- Adds css styling to page -->
<link rel="stylesheet" href="styles.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
</head>

<body>
<div style="font-size:2.5vw;"> <!-- font size changes based on the size of view port -->
<!-- Username is printed with Transaction history -->
<h3><%=username%> Transaction History</h3>

<% 
//use this java code for secure pages
//prevents caching. Tells browser to not store caches.
response.setHeader("Cache_Control", "no-cache, no-store, must-revalidate");

//user will be redirected to login page if user has not logged in
if(session.getAttribute("username")==null)
{
  response.sendRedirect("login.jsp");
}
%>

<table border="1">
<tr>
<!-- Column headers -->
<th>Date</th>
<th>Amount</th>
</tr>

<%
//Connects to database and adds date and amount values for user from database to table
try{
	String query ="select date, amount from transactions where username=?";
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
	PreparedStatement preparedStatement1 = connection.prepareStatement(query);
	//preparedStatement1.setString(1, username);
	
	preparedStatement1.setString(1, username);
	ResultSet result = preparedStatement1.executeQuery();
	
if(result.next()){
	while(result.next()){
%>
<tr>
<td><%=result.getString("date") %></td>
<td><%=result.getFloat("amount") %></td>
</tr>
<%
} 
} else { %>
<tr>
<td colspan="2">No records</td>
</tr>	
<% }
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

<%
//Connects to database and fetches the amount sum from database
try{
	String query2 ="select sum(amount) as balance from transactions where username=?";
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "Sxing1993!");
	PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
	preparedStatement2.setString(1, username);
	ResultSet result2 = preparedStatement2.executeQuery();
	
	if(result2.next()){ 
	
%>
<!-- Displays balance -->
<p>Your balance is <b><%=result2.getFloat("balance")%></b>.</p>
<a href="home.jsp">Home</a>
</div>
<%
	connection.close();
	}
} catch (Exception e) {
	e.printStackTrace();
	}
%>

</body>
</html>