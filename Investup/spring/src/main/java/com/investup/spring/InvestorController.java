package com.investup.spring;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.investup.dao.InvestorDAO;
import com.investup.dao.StartupDAO;
import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.StartupInvestments;

@Controller
public class InvestorController {

	

	@Autowired
	@Qualifier("investorDao")
	InvestorDAO investorDao;

	@Autowired
	@Qualifier("startupDao")
	StartupDAO startupDao;
	
	@RequestMapping(value = "editInvestorProfile.htm", method = RequestMethod.POST)
	protected String viewInvestor(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		long userId=(Long) session.getAttribute("userId");
		Investor investorDetails = investorDao.getInvestorDetails(userId);
//		System.out.println("the id in the controller is "+session.getAttribute("userId"));
		model.addAttribute("investorDetails", investorDetails);
//		System.out.println(investorDetails.toString());
				return "investor-editProfile";
		
	}
	
		
	
	@RequestMapping(value = "fundCheckInvestors.htm", method = RequestMethod.POST)
	protected String checkFund(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Long userId =  (Long) session.getAttribute("userId");
		List<StartupInvestments> investments = investorDao.getInvestments(userId);
		model.addAttribute("investments", investments);
//		System.out.println(investments.toString());
				return "investor-checkInvestments";
				
		
	}
	@RequestMapping(value = "trendingStartups.htm", method = RequestMethod.POST)
	protected String getStartup(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		List<StartupInvestments> investments = investorDao.getStartup(session.getAttribute("userId"));
		model.addAttribute("investments", investments);
				return "investor-checkStartup";
		
	}
	
	
	@RequestMapping(value = "checkSingleStartup.htm", method = RequestMethod.POST)
	protected String getSingleStartup(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Long userId =  Long.parseLong(request.getParameter("selection"));
		System.out.println("selection : " + request.getParameter("selection"));
		System.out.println("UserId " + userId);
		StartupInvestments investment = investorDao.getStartupDetail(userId);
		System.out.println("success");
//		model.addAttribute("investment", investment);
		System.out.println("from controller to page!");
				return "investor-checkSingleStartup";
		
	}
	
	@RequestMapping(value = "makeInvestment.htm", method = RequestMethod.POST)
	protected String makeInvestment(HttpServletRequest request, @ModelAttribute("investment") StartupInvestments investment, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("startupId " + request.getParameter("startupId"));
		Long userId =  Long.parseLong(request.getParameter("startupId"));
		System.out.println("userId " + userId);
//		StartupInvestments editStratupInvestment=startupInvestments;
		investment.setAmount(Long.parseLong(request.getParameter("amount")));
		System.out.println(investment.getAmount());
		Long investorId = (Long) session.getAttribute("userId");
		System.out.println("investor id" + investorId);
		Investor investor = investorDao.getInvestor(investorId);
		System.out.println("after getInvestor ");
		Startup startup = startupDao.getStartup(userId);
		System.out.println("after getStartup ");
		investor.getStartupInvestments().add(investment);
		System.out.println("after getStartupInvestments().add ");
		startup.getStartupInvestments().add(investment);
		System.out.println("after startup.getStartupInvestments().add ");
		investment.setInvestmentStatus("success");
		System.out.println("after success ");
		investment.setInvestor(investor);
		System.out.println("after investment.setInvestor ");
		investment.setStartup(startup);
		System.out.println("after investment.setStartup ");
//		investorDao.updateInvestorInvestment(investor);
		System.out.println("after updateinvestor");
//		startupDao.updateStartupInvestment(startup);
		System.out.println("after update startup");
		StartupInvestments investments = investorDao.makeAnInvestment(investment);
		System.out.println("after investment");
		//model.addAttribute("investments", investments);
//		System.out.println("the investment details!"+investment.toString());
		request.setAttribute("msg", "Congratulations on your new Smart Investment");
				return "investor-success";
		
	}
	
	
	@RequestMapping(value = "investorDetailsChange.htm", method = RequestMethod.POST)
	protected String updateinvestor(HttpServletRequest request,@ModelAttribute("investorDetails") Investor investorDetails, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("in controller Before update"+ investorDetails.toString());
		int rows=investorDao.updateInvestor(investorDetails);
		System.out.println("In controller after update:Number of rows updated="+rows);
		if (rows==0){
		request.setAttribute("msg","No rows were updated" );
		}else if (rows==1){
			request.setAttribute("msg","The startup details are up-to-date!" );
		}
		return "investor-success";
				
		
	}
	
	
	@RequestMapping(value = "investorhome.htm", method = RequestMethod.POST)
	protected String redirectToInvestorHome(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
//		if (session.getAttribute("userId")!=null){
		return "investor-welcome";
//		}else return "home";
		
	}
	
}
