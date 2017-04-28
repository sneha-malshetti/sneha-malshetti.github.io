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
<title>Investor Added</title>
</head>
<body>
<h1>Investor Home</h1>
Make Smart Investment Choices with Investup Today !


Please select what you want to do...

<form  method="post" >
    <input type="submit" value="Edit Your Profile" onclick="form.action='editInvestorProfile.htm;'"/>
    <br/>
    <br/>
    <input type="submit" value="Check Your Investments" onclick="form.action='fundCheckInvestors.htm;'"/>
    <br/>
    <br/>
    <input type="submit" value="Checkout Some Trending Startups" onclick="form.action='trendingStartups.htm;'"/>
    <br/>
    <br/>
    <input type="submit" value="Logout"onclick="form.action='logoutControl.htm;'" />
    
</form>


</body>
</html>