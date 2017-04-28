package com.investup.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.investup.dao.AdminDAO;
import com.investup.exception.UserException;
import com.investup.pojo.UserLoginDetails;

@Controller
public class AdminController {
 private Logger logger=Logger.getLogger(AdminController.class);
	
	@Autowired
	@Qualifier("adminDao")
	AdminDAO adminDao;
	
	//redirect to admin home 
	@RequestMapping(value = "adminhome.htm", method = RequestMethod.GET)
	protected String redirectAdmin(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			
			return "home";
			
		}else{
				return "admin-welcome";
		}
				
		
	}
	//sends pending statuses to the admin
	@RequestMapping(value = "activate.htm", method = RequestMethod.POST)
	protected String activateStartup(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		List<UserLoginDetails> userDetails = adminDao.getPendingStartup();
		model.addAttribute("userList", userDetails);
		
//		System.out.println(userDetails.toString());
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
				return "admin-pendingstatus";
		}		
		
	}
	//Activate pending statuses
	@RequestMapping(value = "changestatus.htm", method = RequestMethod.POST)
	protected String activateStartupStatus(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		String[] results = request.getParameterValues("selection");
		
		List<Long> userIds=new ArrayList<Long>();
		for (int i = 0; i < results.length; i++) {
//		    System.out.println("result"+results[i]); 
		    userIds.add(Long.parseLong(results[i]));
		}
		Long adminUserID=(Long) session.getAttribute("userId");
		System.out.println("number of startups reaching controller"+userIds.size());
		int activatedStartups=adminDao.activateStartupStatus(userIds,adminUserID);
		System.out.println("number of statuses changed="+activatedStartups);
		if (activatedStartups==0){
			request.setAttribute("msg", "No Startups were activated!");
		}
		else{
		request.setAttribute("msg", activatedStartups+" Startup(s) were activated!");
		}
//		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
	
				return "admin-success";
		}	
		
	}
	
	//Rejects pending statuses
	@RequestMapping(value = "rejectstatus.htm", method = RequestMethod.POST)
	protected String rejectStartupStatuses(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
	
		String[] results = request.getParameterValues("selection");
		List<Integer> userIds=new ArrayList<Integer>();
		for (int i = 0; i < results.length; i++) {
//		    System.out.println("result"+results[i]); 
		    userIds.add(Integer.parseInt(results[i]));
		}
		
		int rejectedStartups=adminDao.rejectStartupStatus(userIds);
		System.out.println("number of statuses changed="+rejectedStartups);
		if (rejectedStartups==0){
			request.setAttribute("msg", "No Startups were rejected!");
		}
		else{
		request.setAttribute("msg", rejectedStartups+" Startup(s) were rejected!");
		}
		
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
				return "admin-success";
				
		}
	}
	
	//Deactivates startups -admin
	@RequestMapping(value = "deactivateStartupStatus.htm", method = RequestMethod.POST)
	protected String deactivateStartupStatuses(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
	
		String[] results = request.getParameterValues("selection");
		List<Integer> userIds=new ArrayList<Integer>();
		for (int i = 0; i < results.length; i++) {
		    System.out.println("result"+results[i]); 
		    userIds.add(Integer.parseInt(results[i]));
		}
		
		int deactivatedStartups=adminDao.deactivateStartupStatus(userIds);
		System.out.println("number of statuses changed="+deactivatedStartups);
		if (deactivatedStartups==0){
			request.setAttribute("msg", "No Startups were deactivated!");
		}
		else{
		request.setAttribute("msg", deactivatedStartups+" Startup(s) were deactivated!");
		}
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
	
				return "admin-success";
				
		}
	}
	
	
	
	// sends a list of startups
	@RequestMapping(value = "deactivateStartup.htm", method = RequestMethod.POST)
	protected String deactivateStartup(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		List<UserLoginDetails> userDetails = adminDao.getactiveStartup();
		model.addAttribute("userList", userDetails);
				return "admin-deactivatestartup";
		
	}
	
	

	@RequestMapping(value = "deactivateInvestorstatus.htm", method = RequestMethod.POST)
	protected String deactivateInvestorStatuses(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
	
		String[] results = request.getParameterValues("selection");
		List<Integer> userIds=new ArrayList<Integer>();
		for (int i = 0; i < results.length; i++) {
//		    System.out.println("result"+results[i]); 
		    userIds.add(Integer.parseInt(results[i]));
		}
		
		int rejectedStartups=adminDao.deactivateInvestorStatus(userIds);
		System.out.println("number of statuses changed="+rejectedStartups);
		if (rejectedStartups==0){
			request.setAttribute("msg", "No Startups were activated!");
		}
		else{
		request.setAttribute("msg", rejectedStartups+" Startup(s) were rejected!");
		}
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
	
				return "admin-success";
		}
		
	}	
	
	// sends a list of investors
	@RequestMapping(value = "deactivateInvestors.htm", method = RequestMethod.POST)
	protected String deactivateInvestor(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		List<UserLoginDetails> userDetails = adminDao.getactiveInvestors();
		model.addAttribute("userList", userDetails);
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
				return "admin-deactivate investors";
		}
	}
	
	@RequestMapping(value = "checkInvestment.htm", method = RequestMethod.POST)
	protected String checkInvestments(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		List userDetails = adminDao.checkInvestments();
		model.addAttribute("userList", userDetails);
		HttpSession session = (HttpSession) request.getSession();
		if(session.getAttribute("userId")==null){
			return "home";
		}else{
				return "admin-checkinvestments";
		}
	}
	
	
}
