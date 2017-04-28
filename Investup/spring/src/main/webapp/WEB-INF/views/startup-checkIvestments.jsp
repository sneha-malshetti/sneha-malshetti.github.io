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
<script>
    history.forward();
</script>
<form method="post">
The following are some Smart Investments that you have made

<table>
  <tr>
    <th>Investor First Name</th>
    <th>Investor Last Name</th>
    <th>Investment Status </th>
    <th>Investment Amount</th>
    <th>Date of Investment</th>
    
    
    
  </tr>
  <c:forEach var="investmentsList" items="${investments}">
  <tr>
    <td>${investmentsList.investor.investorFirstName}</td>
    <td>${investmentsList.investor.investorLastName}</td>
    <td>${investmentsList.investmentStatus}</td>
    <td>${investmentsList.amount}</td>
    <td>${investmentsList.date}</td>
   
    
  </tr>
  </c:forEach>
</table>


    
<!-- <input type="submit" value="View Details" onclick="form.action='checkSingleStartup.htm;'"/>  -->

<input type="submit" value="Back" onclick="form.action='startuphome.htm;'"/>
  
</form>
</body>
</html>