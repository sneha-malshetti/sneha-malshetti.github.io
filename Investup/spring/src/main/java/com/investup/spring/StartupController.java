package com.investup.spring;

import java.util.ArrayList;
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

import com.investup.dao.AdminDAO;
import com.investup.dao.StartupDAO;
import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.StartupInvestments;
import com.investup.pojo.UserLoginDetails;

@Controller
public class StartupController {

	
	@Autowired
	@Qualifier("startupDao")
	StartupDAO startupDao;
	
	//Gets the details of the startup to edit
	@RequestMapping(value = "editStartupProfile.htm", method = RequestMethod.POST)
	protected String editStartupProfile(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Startup startupDetails = startupDao.getStartupDetails(session.getAttribute("userId"));
		System.out.println("the id in the controller is "+session.getAttribute("userId"));
		model.addAttribute("startupDetails", startupDetails);
		request.setAttribute("startupDetails", startupDetails);
//		System.out.println(startupDetails.toString());
				return "startup-editProfile";
		
	}
	
	@RequestMapping(value = "startUpDetailsChange.htm", method = RequestMethod.POST)
	protected String updateStartupProfile(HttpServletRequest request,@ModelAttribute("startupDetails") Startup startupDetails, Locale locale,
			Model model) throws Exception {
		
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("in controller Before update"+ startupDetails.toString());
		int rows=startupDao.updateStartup(startupDetails);
		System.out.println("In controller after update:Number of rows updated="+rows);
		if (rows==0){
		request.setAttribute("msg","No rows were updated" );
		}else if (rows==1){
			request.setAttribute("msg","The startup details are up-to-date!" );
		}
		return "startup-success";
	}
	
	
	//Gets the details of all the Investments of the startup
	@RequestMapping(value = "fundCheckStartup.htm", method = RequestMethod.POST)
	protected String checkFund(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		Long userId =  (Long) session.getAttribute("userId");
		List<StartupInvestments> investments = startupDao.getInvestmentsForStartup(userId);
		model.addAttribute("investments", investments);
//		System.out.println(investments.toString());
				return "startup-checkIvestments";
	}
		
	@RequestMapping(value = "trendingInvestors.htm", method = RequestMethod.POST)
	protected String getStartup(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("before sending to startupDao");
		List<Object[]> investments = startupDao.getAllInvestors();
		Object object[]=new Object[3];
		List<Object[]> investments1 = new ArrayList<Object[]>();
		System.out.println("no of objects: "+ investments.size());
		for (Object[] result : investments) {
		    Investor  investor = (Investor)result[0];
		    Long sum = (Long)result[1];
		    Object[] o = new Object[3];
		    String investorFirstName= investor.getInvestorFirstName();
		    String investorLastName=investor.getInvestorLastName();
		    System.out.println("Fname:"+investorFirstName);
		    System.out.println("lname"+investorLastName);
		    o[0]=investorFirstName;
		    o[1]=investorLastName;
		    o[2]=sum;
		    investments1.add(o);
		}
		
		
		
		System.out.println("Received object in controller");
		model.addAttribute("investments1", investments1);
				return "startup-checkInvestor";
		
	}
	
	
	@RequestMapping(value = "latitude.htm", method = RequestMethod.POST)
	protected String getMap(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		return "latitudelongitude";
		
				
	}
	
	@RequestMapping(value = "maps.htm", method = RequestMethod.POST)
	protected String getMapLocation(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		
		return "googleCode";
		
				
	}
	
	
	@RequestMapping(value = "startuphome.htm", method = RequestMethod.POST)
	protected String redirectStartupHome(HttpServletRequest request, Locale locale,
			Model model) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
//		if (session.getAttribute("userId")!=null){
			return "startup-welcome";
//		}else return "home";
	}
	
	
//	@RequestMapping(value = "trendingInvestors.htm", method = RequestMethod.POST)
//	protected String getInvestorsDescending(HttpServletRequest request, Locale locale,
//			Model model) throws Exception {
//		HttpSession session = (HttpSession) request.getSession();
//		System.out.println("before DAO in controller");
//		List<Investor> investors = startupDao.getinvestors();
//		System.out.println("afterdao ");
//		model.addAttribute("startupDetails", startupDetails);
//		request.setAttribute("startupDetails", startupDetails);
//		System.out.println(startupDetails.toString());
//				return "startup-editProfile";
//		
//	}
}
