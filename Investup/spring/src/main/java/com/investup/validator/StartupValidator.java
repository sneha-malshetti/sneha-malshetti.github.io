package com.investup.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.investup.pojo.Investor;
import com.investup.pojo.Startup;

public class StartupValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		
		return aClass.equals(Startup.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	
		Startup startup=(Startup) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.investor", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.investor", "Email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "error.invalid.investor", "Contact Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.investor", "Password Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.investor","Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupDescription", "error.invalid.investor", "Description Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupName", "error.invalid.investor", "Startup Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupLicenseNumber", "error.invalid.investor", "License Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "equity", "error.invalid.investor", "Equity Required in %");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupFirstName", "error.invalid.investor", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupLastName", "error.invalid.investor", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupStreet", "error.invalid.investor", "Street Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupCity", "error.invalid.investor", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupState", "error.invalid.investor", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startupCountry", "error.invalid.investor", "Country Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.investor", "zip code Required");
		
	}
	
	
	

	

}
