<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Adds styling from styles.css -->
<link rel="stylesheet" href="styles.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
</head>
<body>
<br><br><br>
<div style="font-size:2.5vw;"> <!-- font size changes based on size of the view port -->
<h3>Welcome</h3>
<table>

<% 
//use this java code for secure pages
//prevents caching. Tells browser to not store caches.
response.setHeader("Cache_Control", "no-cache, no-store, must-revalidate");

//user will be redirected to login page if has not logged in
if(session.getAttribute("username")==null)
{
  response.sendRedirect("login.jsp");
}
%>

 <tr><td> 
 <!-- Directs to depwith.jsp page -->
  <a href="depwith.jsp">Cash Transaction</a>
 </td></tr>
 <tr><td> 
 <br>
 </td></tr>
 <tr><td> 
 <!-- Directs to history.jsp page -->
  <a href="history.jsp">Transaction History</a>
  </td></tr>
  
</table>
<br>
<br>
<!-- Logout.java is called when Logout button is pressed and user is logged out -->
<form action="<%=request.getContextPath()%>/logout">
	<input type="submit" value="Logout">
</form>
</div>


</body>
</html>