<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>

<body>

<% 
//use this java code for secure pages
//prevents caching. Tells browser to not store caches.
response.setHeader("Cache_Control", "no-cache, no-store, must-revalidate");

//user will be redirect to login page if has not logged in
if(session.getAttribute("username")==null)
{
  response.sendRedirect("login.jsp");
}
%>
<div class="col-lg-6">
<h3>Transaction History</h3>

<form action="history.jsp" method="post">
<table>
<tr>
<td>Enter username:</td>
<td><input type="text" name="username"/></td>
</tr>
</table>
<br>
<input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>