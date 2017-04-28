package com.investup.spring;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.investup.dao.RegistrationDAO;
import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.UserLoginDetails;
import com.investup.utils.CustomMail;
import com.investup.utils.Encryption;

//import com.my.spring.dao.CategoryDAO;
import java.util.Base64;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	@Qualifier("registrationDao")
	RegistrationDAO registrationDao;
	
//	@Autowired
//	ServletContext servletContext;
//	
//	@Autowired
//    private CustomMail customMail;
//	
//	
//    @Autowired
//	JavaMailSender mailSender;
//	
//	@Autowired
//	@Qualifier("investorDAO")
//	UserDAO investorDAO;
//	
////	@Autowired
////	@Qualifier("startupDAO")
////	StartupDAO startupDAO;
//
//	
//	
//	@RequestMapping(value = "/investor/add.htm", method = RequestMethod.POST)
//	public ModelAndView showInvestorSuccesPage(HttpServletRequest request) {
//	
//	
//	
//	String investorFirstName= request.getParameter("investorFirstName");
//	String investorLastName= request.getParameter("investorLastName");
//	String investorContact= request.getParameter("investorContact");
//	String investorStreet= request.getParameter("investorStreet");
//	String investorCity= request.getParameter("investorCity");
//	String investorState= request.getParameter("investorState");
//	String investorCountry= request.getParameter("investorCountry");
//	String zip= request.getParameter("zip");
//	
//	Investor investor=new Investor(investorFirstName, investorLastName, investorContact, investorStreet, investorCity, investorState, investorCountry, zip);
//	try {				
//		investor = UserDAO.createInvestor(investor);
//	} catch (Exception e) {
//		System.out.println(e.getMessage());
//		return new ModelAndView("error", "errorMessage", "error while login");
//	}
//	
//	return new ModelAndView("investoradded","investor",investor);
//	}
//	
//	@RequestMapping(value = "/startup/add.htm", method = RequestMethod.POST)
//	public ModelAndView showStartupSuccesPage(HttpServletRequest request) {
//	
//	
//	String startupName= request.getParameter("startupName");
//	String startupDescription= request.getParameter("startupDescription");
//	String startupLicenseNumber= request.getParameter("startupLicenseNumber");
//	String startupEquity= request.getParameter("startupEquity");	
//	String startupContact= request.getParameter("startupContact");
//	String startupFirstName= request.getParameter("startupFirstName");
//	String startupLastName= request.getParameter("startupLastName");
////	String startupContact= request.getParameter("startupContact");
//	String startupStreet= request.getParameter("startupStreet");
//	String startupCity= request.getParameter("startupCity");
//	String startupState= request.getParameter("startupState");
//	String startupCountry= request.getParameter("startupCountry");
//	String zip= request.getParameter("zip");
//	
//	
//	
//	Startup startup=new Startup(startupName, startupDescription, startupLicenseNumber, startupEquity, startupContact, startupFirstName, startupLastName, startupStreet, startupCity, startupState, startupCountry, zip);
//	try {				
//		startup = UserDAO.createStartup(startup);
//	} catch (Exception e) {
//		System.out.println(e.getMessage());
//		return new ModelAndView("error", "errorMessage", "error while login");
//	}
//	
//	return new ModelAndView("startupadd","startup",startup);
//	}
//	
//	@RequestMapping(value = "/investor/add", method = RequestMethod.POST)
//	public ModelAndView addCategory(@ModelAttribute("investor") Investor investor, BindingResult result) throws Exception {

//		try {	
			
			
//			
//			User u = userDao.get(advert.getPostedBy());
//			advert.setUser(u);
//			advert = advertDao.create(advert);
//			
//            
//            for(Category c: advert.getCategories()){
//            	c = categoryDAO.get(c.getTitle());
//            	c.getAdverts().add(advert);
//            	categoryDAO.update(c); //to maintain many to many relationship
//            }
//			
//			return new ModelAndView("advert-success", "advert", advert);
//			
//		} catch (AdvertException e) {
//			System.out.println(e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
		
		
//	}
	
	
//	@Autowired
//	@Qualifier("userDao")
//	UserDAO userDao;
//	
//
//	@RequestMapping(value = "/advert/add", method = RequestMethod.POST)
//	public ModelAndView addCategory(@ModelAttribute("advert") Advert advert, BindingResult result) throws Exception {
//
//		try {			
//			
//			User u = userDao.get(advert.getPostedBy());
//			advert.setUser(u);
//			advert = advertDao.create(advert);
//			
//            
//            for(Category c: advert.getCategories()){
//            	c = categoryDAO.get(c.getTitle());
//            	c.getAdverts().add(advert);
//            	categoryDAO.update(c); //to maintain many to many relationship
//            }
//			
//			return new ModelAndView("advert-success", "advert", advert);
//			
//		} catch (AdvertException e) {
//			System.out.println(e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
//		
//		
//	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}

		
	@RequestMapping(value = "loginControl.htm", method = RequestMethod.POST)
	protected String addStartupDetails(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password,Locale locale,
			Model model) throws Exception {
		String page = "home";
		UserLoginDetails userLoginDetails = new UserLoginDetails();
		HttpSession session = (HttpSession) request.getSession();
		password = Encryption.encrypt(password);
		
		try {
			userLoginDetails=registrationDao.getUserDetails(userName,password);
			if(userLoginDetails.getType().equalsIgnoreCase("startup") && userLoginDetails.getStatus().equalsIgnoreCase("active")){
		        session.setAttribute("userName",userLoginDetails.getUserName()); 
		        session.setAttribute("userId",userLoginDetails.getUserId());
		        logger.info("Startup User Logged in!");
				page = "startup-welcome";
			}
			else if(userLoginDetails.getType().equalsIgnoreCase("investor") && userLoginDetails.getStatus().equalsIgnoreCase("active")){
				session.setAttribute("userName",userLoginDetails.getUserName());
				session.setAttribute("userId",userLoginDetails.getUserId());
				 logger.info("Investor User Logged in!");
				page = "investor-welcome";
			}
			else if(userLoginDetails.getType().equalsIgnoreCase("admin") && userLoginDetails.getStatus().equalsIgnoreCase("active")){
				session.setAttribute("userName",userLoginDetails.getUserName()); 
				session.setAttribute("userId",userLoginDetails.getUserId());
				 logger.info("ADMIN Logged in!");
				page = "admin-welcome";
			}else if(userLoginDetails.getType().equalsIgnoreCase("investor") && userLoginDetails.getStatus().equalsIgnoreCase("deactivated")){
//				session.setAttribute("userName",userLoginDetails.getUserName()); 
				request.setAttribute("msg", "The Admin had deactivated this account due to some suspicious activities from this account");
				 logger.info("Investor User with a deactivation on his account attempted Login!");
				page = "investor-startup-login-error";
			}else if(userLoginDetails.getType().equalsIgnoreCase("startup") && userLoginDetails.getStatus().equalsIgnoreCase("deactivated")){
//				session.setAttribute("userName",userLoginDetails.getUserName()); 
				request.setAttribute("msg", "The Admin had deactivated this account due to some suspicious activities from this account");
				 logger.info("Startup User with a deactivation on his account attempted Login!");
				page = "investor-startup-login-error";
			}else if(userLoginDetails.getType().equalsIgnoreCase("startup") && userLoginDetails.getStatus().equalsIgnoreCase("rejected")){
//				session.setAttribute("userName",userLoginDetails.getUserName()); 
				request.setAttribute("msg", "The Admin has rejected the startup from registering!");
				 logger.info("Startup User with a Reject on account attempted Login!");
				page = "investor-startup-login-error";
			}else if(userLoginDetails.getType().equalsIgnoreCase("startup") && userLoginDetails.getStatus().equalsIgnoreCase("pending")){
//				session.setAttribute("userName",userLoginDetails.getUserName()); 
				request.setAttribute("msg", "Please wait while the admin accepts your request for registration!");
				
				 logger.info("Pending startup attempted login");
				 page = "investor-startup-login-error";
			}else{
				
			}
			System.out.println(session.getAttribute("userName"));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			request.setAttribute("msg", "<h1> ERROR </h1>error while login");
			logger.error("Wrong username or password login attempt");
			return "investor-startup-login-error";
			
		}
		return page;
		
	}
	
	
	
	@RequestMapping(value = "logoutControl.htm", method = RequestMethod.GET)
	protected String logoutUser(HttpServletRequest request) throws Exception {
//		String page = "home";
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("userName",null);
		session.setAttribute("userId",null);
		session.invalidate();
		
//		
//		password = Encryption.encrypt(password);
		return "home";
	}
	
	
	
//	private static int getRandomNumberInRange(int min, int max) {
//
//		if (min >= max) {
//			throw new IllegalArgumentException("max must be greater than min");
//		}
//
//		Math.random()Random r = new Random();
//		return r.nextInt((max - min) + 1) + min;
//	}
//	@RequestMapping(value = "forgotPassword.htm", method = RequestMethod.POST)
//	protected String resetPasswordCode(HttpServletRequest request) throws Exception {
////		String page = "home";
//		String code="123456";
//		String msg="The code is "+code;
//		customMail.sendMail(mailSender, "sneharm25@gmail.com" , "Reset Code", msg);
//	
//		
//		request.setAttribute("msg", "Your password has been reset and sent on your email Id");
//		
//		return "investor-startup-login-error";
//	}
	
	@RequestMapping(value="mainhome.htm")
	public String getLoginPage(Model model)
	{
		return "home";
	}
	@RequestMapping(value="about.htm")
	public String getAbout(Model model)
	{
		return "about";
	}
	
}
