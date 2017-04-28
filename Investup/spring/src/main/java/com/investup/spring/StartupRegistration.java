package com.investup.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.investup.dao.RegistrationDAO;
import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.utils.CustomMail;
import com.investup.validator.InvestorValidator;
import com.investup.validator.StartupValidator;
@Controller
public class StartupRegistration {
	
	@Autowired
	@Qualifier("registrationDao")
	RegistrationDAO registrationDao;
	
	@Autowired
	@Qualifier("startupValidator")
	StartupValidator validator;
	
	@Autowired
    private CustomMail customMail;
	
    @Autowired
	JavaMailSender mailSender;
	
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		
	}
	
	@RequestMapping(value = "startupregister.htm", method = RequestMethod.GET)
	protected ModelAndView registerStartup() throws Exception {
		System.out.print("register startup");

		return new ModelAndView("startupregistration", "startup", new Startup());

	}
	
	@RequestMapping(value = "startupregistration.htm", method = RequestMethod.POST)
	protected String addStartupDetails(HttpServletRequest request, @ModelAttribute("startup") Startup startup, BindingResult result) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		System.out.println(startup.getUserName());
		System.out.println("startup firstname : " + startup.getStartupFirstName());
		System.out.println("type:"+ startup.getType());
		System.out.println("status:"+ startup.getStatus());
		
		try {
			registrationDao.addStartup(startup);
			String recipient="malshetti.s@husky.neu.edu";
			String subject="New Startup Added!";
			String message="There is a new startup that just got added. Please look into it and assign a status.";
//			customMail.sendMail(mailSender, recipient, subject, message);
			request.setAttribute("msg","Congratulations your are a registered startup now.<br/><br/> We have an authentication process in place for the startups.<br/> Once you pass that you will be allowed to login. <br/>It wont take more than 24 hours for the process!");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
//			return "error";
			request.setAttribute("msg","The startup could not be added due to some issue. Please check your form or try again later!");  
		}
		return "registrationsuccess";
		
	}
	
}
