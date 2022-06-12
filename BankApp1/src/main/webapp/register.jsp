<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Adds css styling to page -->
<link rel="stylesheet" href="styles.css">
<link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
</head>
<body>
 <div style="font-size:2.5vw;"> <!-- Font size changes based on the size of the view port -->
  <h3>Registration</h3>
  <!-- RegisterServlet.java is called when form is submitted -->
  <form action="<%= request.getContextPath() %>/register" method="post">
   <!-- Table allows user to enter first name, username and password -->
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstname" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>