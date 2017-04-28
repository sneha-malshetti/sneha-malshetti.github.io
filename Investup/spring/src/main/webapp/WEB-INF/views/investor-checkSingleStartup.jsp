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
Startup Details:

<form method="post">
<table>
<!-- 		startupId -->
		<input type="hidden" name= "startupId" value= "${investment.startup.userId}"/>
		    <td>Startup Name* :</td>
		    <td>${investment.startup.startupName }</td>
		    
		</tr>
		
		<tr>
		    <td>Description* :</td>
		    <td>${investment.startup.startupDescription}</td>
		    
		</tr>
		
		<tr>
		    <td>Equity* :</td>
		    <td>${investment.startup.startupEquity}</td>
		    
		</tr>
		<tr>
		    
		<tr>
		    <td>Street:</td>
		    <td>${investment.startup.startupStreet}</td>
		   
		</tr>
		<tr>
		    <td>City:</td>
		    <td>${investment.startup.startupCity}</td>
		    
		</tr>
		<tr>
		    <td>State/Province:</td>
		    <td>${investment.startup.startupState }</td>
		    
		</tr>
		<tr>
		 <td>Country:</td>
		    <td>${investment.startup.startupCountry }</td>
		     
		</tr>
		<tr>
		 <td>Zip Code:</td>
		    <td>${investment.startup.zip }</td>
		     </tr>
		<tr>
		    <td>Investment Amount* :</td>
		    <td><input type="number" size="30" required="required" name="amount" min=1 maxlength="12" /></td>
		    
		</tr>
</tr>
		<tr>
		 <td></td>
		    <td>status<input type="hidden" name="investmentStatus" value="success"/>
		    </td>  
		</tr>
		
		<tr>
		 <td></td>
		    <td>investor Id<input type="hidden" name="investorId" value="${sessionScope.userId }"/>
		    </td>  
		</tr>		
		
		
				
		</table>
		
		
<input type="submit" value="Invest" onclick="form.action='makeInvestment.htm;'"/> 

<input type="submit" value="Back" onclick="form.action='investorhome.htm;'"/>
</form>
</body>
</html>