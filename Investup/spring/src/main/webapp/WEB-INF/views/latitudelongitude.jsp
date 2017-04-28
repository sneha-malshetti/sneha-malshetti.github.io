<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<table>
		
		<tr>
		    <td>Latitude* :</td>
		    <td><input type="text" name="latitude" size="30" required="required" value="42.3505004" />
		    </td>
		</tr>
		<tr>
		    <td>Longitude* :</td>
		    <td><input type="text" name="longitude" size="30" required="required" value="-71.1141533" />
		    </td>
		</tr>
		
		</table>


<input type="submit" value="Update" onclick="form.action='maps.htm;'"/> 

<input type="submit" value="Back" onclick="form.action='startuphome.htm;'"/>
  
</form>
</body>
</html>