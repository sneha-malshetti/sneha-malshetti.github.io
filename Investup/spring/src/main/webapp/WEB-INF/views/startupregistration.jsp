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
<title>Startup Details</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Investor Details</title>
<script type="text/javascript">
var ck_name = /^[A-Za-z0-9 ]{3,20}$/;
var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i 
var ck_username = /^[A-Za-z0-9_]{1,20}$/;
var ck_password =  /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;


function validate(startupregistration){
var name = startupregistration.userName.value;
 var email = startupregistration.email.value;
 var usernamef = startupregistration.startupFirstName.value;
 var usernamel = startupregistration.startupLastName.value;
 var password = startupregistration.password.value;
  
 var errors = [];
 
 if (!ck_name.test(name)) {
  errors[errors.length] = "You must enter a valid userName(max 20 characters) .";
 }
  
 if (!ck_email.test(email)) {
  errors[errors.length] = "You must enter a valid email address.";
 }
 if (!ck_username.test(usernamef)) {
  errors[errors.length] = "You must enter a valid FirstName no special char .";
 }
 if (!ck_username.test(usernamel)) {
	  errors[errors.length] = "You must enter a valid LastName no special char .";
	 }
 if (!ck_password.test(password)) {
  errors[errors.length] = "You must enter a valid Password min 6 char.";
 }
 
 
 if (errors.length > 0) {
  reportErrors(errors);
  return false;
 }
 
 return true;
}

function reportErrors(errors){
 var msg = "Please Enter Valid Data...\n";
 for (var i = 0; i<errors.length; i++) {
  var numError = i + 1;
  msg += "\n" + numError + ". " + errors[i];
 }
 alert(msg);
}
</script>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<h1>Startup Registration</h1>
<form:form action="startupregistration.htm" method="post" name="startupregistration" modelAttribute="startup" commandName="startup"
onSubmit="return validate(this);">
<table>
		<tr>
		    <td>User Name* :</td>
		    <td><form:input type="text" path="userName" size="30" required="required" />
		    <font color="red"><form:errors path="userName" /></font></td>
		</tr>
		
		<tr>
		    <td>Email* :</td>
		    <td><form:input type="email" path="email" size="30" required="required"/>
		    <font color="red"><form:errors path="email" /></font></td>
		</tr>
		<tr>
		    <td>Contact Number* :</td>
		    <td><form:input type="Number" path="contactNumber" size="30" required="required" minlength="10" maxlength="10"/>
		    <font color="red"><form:errors path="contactNumber" /></font></td>
		</tr>
		<tr>
		    <td>Password* :</td>
		    <td><form:input type="password" path="password" size="30" required="required" minlength="8" maxlength="20"/>
		    <font color="red"><form:errors path="password" /></font></td>
		</tr>
<!-- 		<tr> -->
<!-- 		    <td>Confirm Password* :</td> -->
<!-- 		    <td><input type="password" name="confirmPassword" size="30" required="required"/> -->
<!-- 		    </td> -->
<!-- 		</tr> -->
		
		<tr>
		    <td>Startup Name* :</td>
		    <td><form:input type="text" path="startupName" size="30" required="required" minlength="8" maxlength="40"/>
		    <font color="red"><form:errors path="startupName" /></font></td>
		</tr>
		
		<tr>
		    <td>Description* :</td>
		    <td><form:input type="text" path="startupDescription" size="30" required="required"/>
		    <font color="red"><form:errors path="startupDescription" /></font></td>
		</tr>
		<tr>
		    <td>License Number* :</td>
		    <td><form:input type="text" path="startupLicenseNumber" size="30" required="required" minlength="8" maxlength="20"/>
		    <font color="red"><form:errors path="startupLicenseNumber" /></font></td>
		</tr>
		<tr>
		    <td>Equity* :</td>
		    <td><form:input type="number" path="startupEquity" size="30" required="required" min="1" max="99"/>
		    <font color="red"><form:errors path="startupEquity" /></font></td>
		</tr>
		<tr>
		    <td>First Name* :</td>
		    <td><form:input type="text" path="startupFirstName" size="30" required="required" minlength="8" maxlength="20"/>
		    <font color="red"><form:errors path="startupFirstName" /></font></td>
		</tr>
		
		<tr>
		    <td>Last Name* :</td>
		    <td><form:input type="text" path="startupLastName" size="30" required="required" minlength="8" maxlength="20"/>
		    <font color="red"><form:errors path="startupLastName" /></font></td>
		</tr>
		<tr>
		    <td>Street:</td>
		    <td><form:input type="text" path="startupStreet" size="30" />
		    <font color="red"><form:errors path="startupStreet" /></font></td>
		</tr>
		<tr>
		    <td>City:</td>
		    <td><form:input type="text" path="startupCity" size="30" />
		    <font color="red"><form:errors path="startupCity" /></font></td>
		</tr>
		<tr>
		    <td>State/Province:</td>
		    <td><form:input type="text" path="startupState" size="30"/>
		    <font color="red"><form:errors path="startupState" /></font></td>
		</tr>
		<tr>
		 <td>Country:</td>
		    <td><form:input type="text" path="startupCountry" size="30"/>
		    <font color="red"><form:errors path="startupCountry" /></font></td>  
		</tr>
		<tr>
		 <td>Zip Code:</td>
		    <td><form:input type="text" path="zip" size="20" maxlength="9"/>
		    <font color="red"><form:errors path="zip" /></font></td>  
		
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
		    <td colspan="2"><input type="submit" class="btn btn-primary" value="Submit" /><input type="submit" class="btn btn-primary" value="Home"onclick="form.action='logoutControl.htm;'" /></td>
		</tr>
				
		</table>

</form:form>


</body>
</html>