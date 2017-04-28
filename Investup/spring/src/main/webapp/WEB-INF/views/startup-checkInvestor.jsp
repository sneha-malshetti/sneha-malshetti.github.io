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
The following are some Smart Investments that you have made

<table>
  <tr>
    <th>Investor First Name</th>
    <th>Investor Last Name</th>
    <th>Amount Invested</th>
    
    
    
    
  </tr>
  <c:forEach var="investmentsList" items="${investments1}">
  <tr>
<%--   	<c:forEach  var=object begin="0" end="30"varStatus="loop"> --%>
<c:forEach var="object" begin="0" end="30" items="${investmentsList}">
    <%--<Index: ${loop.index}<br/>--%>

  
<%--     <td>${object(loop.index).userId}" </td> --%>
<%--     <td>${object(loop.index)}" </td>  --%>
    
<!--   </tr> -->
 
<!--   <tr> -->
<%--     <td>${object..investor.investorFirstName}</td> --%>
<%--     <td>${investmentsList.investor.investorLastName}</td> --%>
<%--     <td>${investmentsList. } --%>
    
   <td>${object} </td>
   
    </c:forEach>
  </tr>
 	
  </c:forEach>
</table>


    
<!-- <input type="submit" value="View Details" onclick="form.action='checkSingleStartup.htm;'"/>  -->

<input type="submit" value="Back" onclick="form.action='startuphome.htm;'"/>
  
</form>

</body>
</html>