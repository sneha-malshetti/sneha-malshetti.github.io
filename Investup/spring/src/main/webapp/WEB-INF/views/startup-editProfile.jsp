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
<title>Startup-Edit</title>
</head>
<body>
You can edit the details but this will go through a stage of authentication by the Admin!

<form method="post" >
<table>
		<tr>
<!-- 		    <td>User Name* :</td> -->
		    <td><input type="hidden" name="userName" size="30" required="required" value="${startupDetails.userName }" />
		    <input type="hidden" name="userId" size="30" required="required" value="${startupDetails.userId }" />
		    </td>
		</tr>
		
		<tr>
		    <td>Email* :</td>
		    <td><input type="email" name="email" size="30" required="required" value="${startupDetails.email }" />
		    </td>
		</tr>
		<tr>
		    <td>Contact Number* :</td>
		    <td><input type="Number" name="contactNumber" size="30" required="required" value="${startupDetails.contactNumber }" />
		    </td>
		</tr>
		<tr>
<!-- 		    <td>Password* :</td> -->
		    <td><input type="hidden" name="text" size="30" required="required" value="${startupDetails.password }" />
		    </td>
		</tr>
<!-- 		<tr> -->
<!-- 		    <td>Confirm Password* :</td> -->
<!-- 		    <td><input type="password" name="confirmPassword" size="30" required="required"/> -->
<!-- 		    </td> -->
<!-- 		</tr> -->
		
		<tr>
<!-- 		    <td>Startup Name* :</td> -->
		    <td><input type="hidden" name="startupName" size="30" required="required"  value="${startupDetails.startupName }" />
		    </td>
		</tr>
		
		<tr>
		    <td>Description* :</td>
		    <td><input type="text" name="startupDescription" size="30" required="required" value="${startupDetails.startupDescription }" />
		    </td>
		</tr>
		
		<tr>
		    <td>Equity* :</td>
		    <td><input type="text" name="startupEquity" size="30" required="required" value="${startupDetails.startupEquity }" />
		    </td>
		</tr>
		<tr>
<!-- 		    <td>First Name* :</td> -->
		    <td><input type="hidden" name="startupFirstName" size="30" required="required"  value="${startupDetails.startupFirstName }" />
		   </td>
		</tr>
		
		<tr>
<!-- 		    <td>Last Name* :</td> -->
		    <td><input type="hidden" name="startupLastName" size="30" required="required" value="${startupDetails.startupLastName }" />
		    </td>
		</tr>
		<tr>
		    <td>Street:</td>
		    <td><input type="text" name="startupStreet" size="30"  value="${startupDetails.startupStreet }" />
		    </td>
		</tr>
		<tr>
		    <td>City:</td>
		    <td><input type="text" name="startupCity" size="30"  value="${startupDetails.startupCity }" />
		    </td>
		</tr>
		<tr>
		    <td>State/Province:</td>
		    <td><input type="text" name="startupState" size="30" value="${startupDetails.startupState }" />
		    </td>
		</tr>
		<tr>
		 <td>Country:</td>
		    <td><input type="text" name="startupCountry" size="30" value="${startupDetails.startupCountry }" />
		    </td>  
		</tr>
		<tr>
		 <td>Zip Code:</td>
		    <td><input type="text" name="zip" size="30" value="${startupDetails.zip }" />
		    </td>  
		
</tr>
		<tr>
		 <td></td>
		    <td><input type="hidden" name="type" value="startup"/>
		    </td>  
		</tr>
		<tr>
		 <td></td>
		    <td><input type="hidden" name="status" value="pending"/>
		    </td>  
		</tr>
		
		<tr>
		 <td></td>
		    <td><input type="hidden" name="startupLicenseNumber" value="startupLicenseNumber"/>
		    </td>  
		</tr>
		
		</table>

		   <input type="submit" value="Update" onclick="form.action='startUpDetailsChange.htm;'"/> 
<br/>
<br/>

		
		    <input type="submit" value="Back" onclick="form.action='investorhome.htm;'"/>
	
				
</form>
</body>
</html>