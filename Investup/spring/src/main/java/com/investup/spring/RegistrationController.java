package com.investup.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.investup.pojo.UserLoginDetails;
import com.investup.validator.InvestorValidator;
import com.investup.validator.StartupValidator;
import com.investup.exception.UserException;




@Controller
public class RegistrationController {
	
//	
	@Autowired
	@Qualifier("registrationDao")
	RegistrationDAO registrationDao;
	
	@Autowired
	@Qualifier("investorValidator")
	InvestorValidator validator;
	
//	@Autowired
//	@Qualifier("startupValidator")
//	StartupValidator validator1;
//	
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		
	}
	
//	@InitBinder
//	private void initBinder1(WebDataBinder binder1) {
//		binder1.setValidator(validator1);
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	protected String goToUserHome(HttpServletRequest request) throws Exception {
//		return "index";
//	}
	@RequestMapping(value = "investorregister.htm", method = RequestMethod.GET)
	protected ModelAndView registerInvestor() throws Exception {
		System.out.print("register investor");

		return new ModelAndView("investorregistration", "investor", new Investor());

	}
	
//	@RequestMapping(value = "startupregister.htm", method = RequestMethod.GET)
//	protected ModelAndView registerStartup() throws Exception {
//		System.out.print("register startup");
//
//		return new ModelAndView("startupregistration", "startup", new Startup());
//
//	}
	
//
//	@RequestMapping(value = "registration.htm", method = RequestMethod.POST)
//	protected ModelAndView registerNewUser(HttpServletRequest request) throws Exception {
//		
//		UserLoginDetails user=new UserLoginDetails();
//		ModelAndView model=new ModelAndView();
//		
//		user.setUserName(request.getParameter("userName"));
//		user.setEmail(request.getParameter("email"));
//		user.setPassword(request.getParameter("password"));
//		user.setContactNumber(request.getParameter("contactNumber"));
//		user.setStatus("pending");
//		
//		HttpSession session = request.getSession(true);
//        String choice = request.getParameter("selectedOption");
//        
//        if(choice.equals("startup")) {
//        	user.setType("startup");
//        	session.setAttribute("user", user);
//            return new ModelAndView("startupregistration", "startup", new Startup() );
//        }
//        else if(choice.equals("investor")){
//        	user.setType("investor");
//        	session.setAttribute("user", user);
//        	
//            return new ModelAndView ("investorregistration","investor", new Investor() );
//            }
//        
//
//        else return null;
//	}
//	
	
	
	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	protected String welcomeHome(HttpServletRequest request) throws Exception {
	return "home";
	}
	
	
	
	@RequestMapping(value = "investorregistration.htm", method = RequestMethod.POST)
	protected String addInvestorDetails(HttpServletRequest request,@ModelAttribute("investor") Investor investor, BindingResult result, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		System.out.println(investor.getUserName());
		System.out.println("investor firstname : " + investor.getInvestorFirstName());
		System.out.println("type:"+ investor.getType());
		System.out.println("status:"+ investor.getStatus());
		
//		int check=0;
		try {
//			UserLoginDetails user=(UserLoginDetails) session.getAttribute("user");
//		//	check=registrationDao.setUser(user, investor);
//			
//			return "investor";
//			
			registrationDao.addInvestor(investor);
			model.addAttribute("msg", "Congratulations! <br/> Happy Investing !");
			request.setAttribute("msg","Congratulations! <br/> Happy Investing !");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
//			session.setAttribute("errorMessage", "error while login");
//			return "error";
			request.setAttribute("msg","The Investor details could not be added due to some issue.<br/> Please check your form or try again later!");
		}
		return "registrationsuccess";
	}
	
//	@RequestMapping(value = "startupregistration.htm", method = RequestMethod.POST)
//	protected String addStartupDetails(HttpServletRequest request) throws Exception {
//
//		HttpSession session = (HttpSession) request.getSession();
//		System.out.println(startup.getUserName());
//		System.out.println("startup firstname : " + startup.getStartupFirstName());
//		System.out.println("type:"+ startup.getType());
//		System.out.println("status:"+ startup.getStatus());
//		
//		try {
//			registrationDao.addStartup(startup);
//			
//			
//		} catch (Exception e) {
//			System.out.println("Exception: " + e.getMessage());
//			session.setAttribute("errorMessage", "error while login");
////			return "error";
//			
//		}
//		return "startup-welcome";
//		
//	}
//	
}
