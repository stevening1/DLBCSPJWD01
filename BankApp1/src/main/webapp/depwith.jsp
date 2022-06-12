<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Adds css styling from styles.css -->
<link rel="stylesheet" href="styles.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 -->
</head>

<body>
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

<div style="font-size:2.5vw;"> <!-- font size changes based on the size of the view port -->
<h3>Cash Transaction</h3>
<!-- When form is submitted, DepWithServlet is called and user is redirected to history.jsp -->
<form name="" method="post" action="<%= request.getContextPath() %>/transaction">

<!-- table that allows users to enter transaction details -->
<table class=transactionform>

<!-- <tr>
		<td>Username</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr> -->
	<tr>
		<td>Action</td>
		<td>
		<select name="action">
		<option>deposit</option>
		<option>withdraw</option>
		</select>
		</td>
	</tr>

	<tr>
		<td>Amount</td>
		<td><input type="text" name="amount"></td>
	</tr>

	<tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Submit"></td>
	</tr>
	
</table>
</form>
<br>
<!-- option to go back to homepage -->
<a href="home.jsp">Home</a>
<br>
<br>
<!-- User is logged out when logout button is pressed -->
<form action="<%=request.getContextPath()%>/logout">
	<input type="submit" value="Logout">
</form>
</div>
</body>
</html>