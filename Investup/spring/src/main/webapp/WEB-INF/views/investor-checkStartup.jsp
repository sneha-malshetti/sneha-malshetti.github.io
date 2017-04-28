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
    
//   $().ready(function(){                        
// 	  $("#hide").click(function(){
// 		    $("#").hide();
// 		});
//     	$("#ddta2").hide();
//     	$("#ddta3").hide();
    
    
    
</script>
<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
The following are some Smart investments that you have made

<table>
  <tr>
    <th>startup Name</th>
    <th>Description </th>
    <th>equity</th>
    <th>Total Funds Invested</th>
   
    
    
    
  </tr>
  <c:forEach var="investmentsList" items="${investments}">
  <tr>
    <td><input type="radio" value="${investmentsList.startup.userId}" name="selection">${investmentsList.startup.startupName}</td>
    <td>${investmentsList.startup.startupDescription}</td>
    <td>${investmentsList.startup.startupEquity }</td>
    <td>${investmentsList.amount }</td>
<!--     <td id="ddta1"><input type="submit" value="Make Investment" onclick="form.action='startuphome.htm;'"/></td> -->
<!--     <td id="ddta2"><input type="number" value="0"  maxlength=10 onclick="form.action='startuphome.htm;'"/></td> -->
<!--     <td id="ddta3"><input type="submit" value="Submit" onclick="form.action='startuphome.htm;'"/></td> -->
    
   
    
  </tr>
  </c:forEach>
</table>


    
<input type="submit" value="View Details" onclick="form.action='checkSingleStartup.htm;'"/> 

<input type="submit" value="Back" onclick="form.action='investorhome.htm'"/>
  
</form>
</body>
</html>