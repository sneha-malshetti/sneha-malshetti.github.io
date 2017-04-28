<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</script>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
    history.forward();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--<form  action="activatestartups?action=activatestartups" method="post" >-->
<form method="post">
Please make selections to deactivate the startups !

<table>
  <tr>
    <th>startup Name</th>
    <th>Description </th>
    <th>License Number</th>
    <!-- <th>License pdf </th> -->
    <th>First Name of Startup admin</th>
    <th>Last name of startup admin  </th>
    <th>Contact Number</th>
    <th>Email</th>
    
  </tr>
  <c:forEach var="startupList" items="${userList}">
  <tr>
    <td><input type="checkbox" value="${startupList.userId}" name="selection">${startupList.startupName}</td>
    <td>${startupList.startupDescription}</td>
    <td>${startupList.startupLicenseNumber }</td>
    <td>${startupList.startupFirstName }</td>
    <td>${startupList.startupLastName }</td>
    <td>${startupList.contactNumber }</td>
    <td>${startupList.email }</td>
    <!-- <td>${startupList.startupLicenseNumber }</td> -->
  </tr>
  </c:forEach>
</table>


    
<input type="submit" value="Activate Startups" onclick="form.action='changestatus.htm;'"/> 
<input type="submit" value="Reject Startups" onclick="form.action='rejectstatus.htm;'"/>
<input type="submit" value="Back" onclick="form.action='adminhome.htm;'"/>
  
</form>

</body>
</html>