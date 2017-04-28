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
<title>Admin-welcome</title>
</head>
<body>

<form>
Startups for approval
<table style="width:100%">
  <tr>
    <th>Startup Name</th>
    <table style="width:100%">
  <tr>
  	<th>Startup Name</th>
    <th>Description</th>
    <th>Action(Accept/Reject)</th> 
  </tr>
  <tr>
    <td>Quicken Loans</td>
    <td>Mortagage lending company </td> 
    <td>Accept</td>
    <td>Reject</td>
  </tr>
  
</table>
  
</form>

</body>
</html>