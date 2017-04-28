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
<form method="post">


<table><tr>
<!-- 		    <td>User Name* :</td> -->
		    <td><input type="hidden" name="userName" size="30" required="required"  value="${investorDetails.userName }" />
		    <input type="hidden" name="userId" size="30" required="required"  value="${investorDetails.userId }" />
		    </td>
		</tr>
		
		<tr>
		    <td>Email* :</td>
		    <td><input type="email" name="email" size="30" required="required" value="${investorDetails.email }" />
		    </td>
		</tr>
		<tr>
		    <td>Contact Number* :</td>
		    <td><input type="number" name="contactNumber" size="30" required="required" value="${investorDetails.contactNumber }" />
		    </td>
		</tr>
		<tr>
<!-- 		    <td>Password* :</td> -->
		    <td><input type="hidden" name="password" size="30" required="required" value="${investorDetails.password }" />
		    </td>
		</tr>
<!-- 		<tr> -->
<!-- 		    <td>Confirm Password* :</td> -->
<!-- 		    <td><input type="password" name="confirmPassword" size="30" required="required"/> -->
<!-- 		    </td> -->
<!-- 		</tr> -->
	
		<tr>
		    <td>First Name* :</td>
		    <td><input type="text" name="investorFirstName" size="30" required="required" value="${investorDetails.investorFirstName }" />
		    
		</tr>
		
		<tr>
		    <td>Last Name* :</td>
		    <td><input type="text" name="investorLastName" size="30" required="required" value="${investorDetails.investorLastName }"/>
		    
		</tr>
		<tr>
		    <td>Street:</td>
		    <td><input type="text" name="investorStreet" size="30" value="${investorDetails.investorStreet }" />
		    
		</tr>
		<tr>
		    <td>City:</td>
		    <td><input type="text" name="investorCity" size="30" value="${investorDetails.investorCity }"/>
		    </td>
		</tr>
		<tr>
		    <td>State/Province:</td>
		    <td><input type="text" name="investorState" size="30" value="${investorDetails.investorState }" />
		    </td>
		</tr>
		<tr>
		 <td>Country:</td>
		    <td><input type="text" name="investorCountry" size="30" value="${investorDetails.investorCountry }"/>
		    </td>  
		</tr>
		<tr>
		 <td>Zip Code:</td>
		    <td><input type="text" name="zip" size="30" value="${investorDetails.zip }"/>
		    </td>  
		
</tr>
		<tr>
		 <td></td>
		    <td><input type="hidden" name="type" value="investor"/>
		    </td>  
		</tr>
		<tr>
		 <td></td>
		    <td><input type="hidden" name="status" value="active"/>
		    </td>  
		</tr>
		
<!-- 		<tr> -->
<!-- 		    <td colspan="2"><input type="submit" value="Submit" /></td> -->
<!-- 		</tr> -->
				
		</table>



    
<input type="submit" value="Update" onclick="form.action='investorDetailsChange.htm;'"/> 

<input type="submit" value="Back" onclick="form.action='investorhome.htm;'"/>
  
</form>
</body>
</html>