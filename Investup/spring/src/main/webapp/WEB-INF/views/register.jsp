<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
    history.forward();
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>


<form action="/user/registration.htm" method="post">
	
		<table>
		<tr>
		    <td>User Name:</td>
		    <td><input name="userName" size="30" required="required" /></td>
		</tr>
		
		<tr>
		    <td>Email:</td>
		    <td><input type="email" name="password" size="30" required="required"/></td>
		</tr>
		<tr>
		    <td>Contact Number:</td>
		    <td><input type="Number" name="contactNumber" size="30" required="required"/></td>
		</tr>
		<tr>
		    <td>Password:</td>
		    <td><input type="password" name="password" size="30" required="required"/></td>
		</tr>
		<tr>
		    <td>Confirm Password:</td>
		    <td><input type="password" name="confirmPassword" size="30" required="required"/></td>
		</tr>
		<tr>
		    <div>
  <select name="selectedOption">
  <option value="startup">I am a Startup Company</option>
  <option value="investor">I am an Investor</option>
  
</select>
</div>
		</tr>
		
		
		<tr>
		    <td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
				
		</table>

	</form>

</body>
</html>