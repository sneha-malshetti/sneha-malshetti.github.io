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
<h1>Startup Home</h1>
Start Networking and raising more funds today !

Please select what you want to do...

<form  method="post" >
<!-- To Edit Startup Profile -->
    <input type="submit" value="Edit Your Profile Today" onclick="form.action='editStartupProfile.htm;'"/>
    <br/>
    <br/>
<!--     To check the funds that the startup has received -->
    <input type="submit" value="Check Your Funds" onclick="form.action='fundCheckStartup.htm;'"/>
    <br/>
    <br/>
<!--     To checkout all the investors -->
    <input type="submit" value="Checkout Some Trending Investors" onclick="form.action='trendingInvestors.htm;'"/>
    <br/>
    <br/>
<!--     To see maps -->
    <input type="submit" value="See yourself on the map"onclick="form.action='latitude.htm;'" />
    <br/>
    <br/>
<!--     To logout -->
    <input type="submit" value="Logout"onclick="form.action='logoutControl.htm;'" />
    
    
</form>

</body>
</html>