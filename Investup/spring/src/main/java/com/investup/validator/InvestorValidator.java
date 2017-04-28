package com.investup.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.investup.pojo.Investor;



public class InvestorValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Investor.class);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Investor investor = (Investor) obj ;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.investor", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.investor", "Email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "error.invalid.investor", "Contact Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.investor", "Password Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.investor","Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorFirstName", "error.invalid.investor", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorLastName", "error.invalid.investor", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorStreet", "error.invalid.investor", "Street Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorCity", "error.invalid.investor", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorState", "error.invalid.investor", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "investorCountry", "error.invalid.investor", "Country Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.investor", "zip code Required");
		
	}
	
	

}
