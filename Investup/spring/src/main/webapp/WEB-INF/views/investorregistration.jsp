<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
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
<title>Investor Details</title>
<script type="text/javascript">
var ck_name = /^[A-Za-z0-9 ]{3,20}$/;
var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i 
var ck_username = /^[A-Za-z0-9_]{1,20}$/;
var ck_password =  /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;


function validate(investorRegistration){
var name = investorRegistration.userName.value;
 var email = investorRegistration.email.value;
 var usernamef = investorRegistration.investorFirstName.value;
 var usernamel = investorRegistration.investorLastName.value;
 var password = investorRegistration.password.value;
  
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
 var msg = "Please Enter Valide Data...\n";
 for (var i = 0; i<errors.length; i++) {
  var numError = i + 1;
  msg += "\n" + numError + ". " + errors[i];
 }
 alert(msg);
}
</script>
</head>
<body>
<h1>Investor Registration</h1>
<form:form action="investorregistration.htm" commandName="investor"
		method="post" name="investorRegistration" onSubmit="return validate(this);">

<table>
		<tr>
		    <td>User Name* :</td>
		    <td><form:input type="text" path="userName" size="30" required="required" minlength="8" maxlength="20"/>
		    <font color="red"><form:errors path="userName" /></font></td>
		</tr>
		
		<tr>
		    <td>Email* :</td>
		    <td><form:input type="email" path="email" size="30" required="required" minlength="8" maxlength="30"/>
		    <font color="red"><form:errors path="email" /></font></td>
		</tr>
		<tr>
		    <td>Contact Number* :</td>
		    <td><form:input type="Number" path="contactNumber" size="30" required="required" minlength="8" maxlength="10"/>
		    <font color="red"><form:errors path="contactNumber" /></font></td>
		</tr>
		<tr>
		    <td>Password* :</td>
		    <td><form:input type="password" path="password" size="30" required="required" maxlength="15"/>
		    <font color="red"><form:errors path="password" /></font></td>
		</tr>
<!-- 		<tr> -->
<!-- 		    <td>Confirm Password* :</td> -->
<!-- 		    <td><input type="password" name="confirmPassword" size="30" required="required"/> -->
<!-- 		    </td> -->
<!-- 		</tr> -->
		
		<tr>
		    <td>First Name* :</td>
		    <td><form:input type="text" path="investorFirstName" size="30" required="required" maxlength="15" />
		    <font color="red"><form:errors path="investorFirstName" /></font></td>
		</tr>
		
		<tr>
		    <td>Last Name* :</td>
		    <td><form:input type="text" path="investorLastName" size="30" required="required" maxlength="15"/>
		    <font color="red"><form:errors path="investorLastName" /></font></td>
		</tr>
		<tr>
		    <td>Street:</td>
		    <td><form:input type="text" path="investorStreet" size="30" maxlength="15"/>
		    <font color="red"><form:errors path="investorStreet" /></font></td>
		</tr>
		<tr>
		    <td>City:</td>
		    <td><form:input type="text" path="investorCity" size="30" maxlength="15"/>
		    <font color="red"><form:errors path="investorCity" /></font></td>
		</tr>
		<tr>
		    <td>State/Province:</td>
		    <td><form:input type="text" path="investorState" size="30" maxlength="15"/>
		    <font color="red"><form:errors path="investorState" /></font></td>
		</tr>
		<tr>
		 <td>Country:</td>
		    <td><form:input type="text" path="investorCountry" size="30" maxlength="15"/>
		    <font color="red"><form:errors path="investorCountry" /></font></td>  
		</tr>
		<tr>
		 <td>Zip Code:</td>
		    <td><form:input type="text" path="zip" size="30" maxlength="9"/>
		    <font color="red"><form:errors path="zip" /></font></td>  
		
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
		
		<tr>
		    <td colspan="2"><input type="submit" value="Submit" /><input type="submit" value="Home"onclick="form.action='logoutControl.htm;'" /></td>
		</tr>
				
		</table>

</form:form>

</body>
</html>