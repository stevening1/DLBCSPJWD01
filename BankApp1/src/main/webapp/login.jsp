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
  <div style="font-size:2.5vw;"> <!-- changes font size based on size of the view port -->
  <h3>Login</h3>
  <!-- LoginServlet.java is called when submit is pressed -->
  <form action="<%=request.getContextPath()%>/login" method="post">
  <!-- Table that allows user to enter username and password --> 
   <table style="with: 100%">
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
  <br>
  <a href="register.jsp">New User?</a> <!-- Redirects user to register.jsp -->
 </div>
</body>
</html>