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
<title>Insert title here</title>
</head>
<body>
<%
//allow access only if session exists
//String userId = null;
if(session.getAttribute("userId") == null){
	response.sendRedirect("home.jsp");}%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<h1>Welcome Admin!</h1><br/>
<h5>Please make a selection of your choice!</h5>
<form  method="post" >
    <input type="submit" value="Accept Startup Request" onclick="form.action='activate.htm;'"/>
    <br/>
    <br/>
    <input type="submit" value="Deactivate Startups" onclick="form.action='deactivateStartup.htm;'"/>
    <br/>
    <br/>
    <input type="submit" value="Deactivate Investors "onclick="form.action='deactivateInvestors.htm;'" />
    <br/>
    <br/>
    <!-- <input type="submit" value="check investment details"onclick="form.action='checkInvestment.htm;'" /> -->
    <br/>
    <br/>
    <input type="submit" value="Logout"onclick="form.action='logoutControl.htm;'" />
    
</form>


</body>
</html>