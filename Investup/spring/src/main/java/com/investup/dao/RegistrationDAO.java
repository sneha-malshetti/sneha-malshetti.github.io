package com.investup.dao;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.UserLoginDetails;
import com.investup.utils.Encryption;
import com.investup.exception.UserException;

public class RegistrationDAO extends DAO{

//public static Investor createInvestor(Investor investor)
//{
//	return investor;
//}
//	
//public static Startup createStartup(Startup startup)
//{
//	return startup;
//}
	
	
		
	public RegistrationDAO() {
		
	}

	public int setUser(UserLoginDetails user, Investor investor) throws UserException {
	int returnValue=0;
			try{
	begin();			
//	getSession().save(user);
	
	investor.setPassword(Encryption.encrypt(investor.getPassword()));
	getSession().save(investor);
	commit();
	returnValue=0;

} catch (HibernateException e) {
	rollback();
	returnValue=1;
	throw new UserException("Exception while creating user: " + e.getMessage());
}
	
	return returnValue;
}

	public void addInvestor(Investor investor) throws UserException {
		try{
			Session session = (Session) DAO.getSession();
			System.out.println("inside addInvestor");
		
			begin();
			investor.setPassword(Encryption.encrypt(investor.getPassword()));
			System.out.println("investor firstname : " + investor.getInvestorFirstName());
			System.out.println("type " + investor.getType());
			System.out.println("type:"+ investor.getStatus());
			session.save(investor);
			System.out.println("*** SAVED");
			commit();
			

		} catch (HibernateException e) {
			rollback();
			
			System.out.println("Exception while creating user: " + e.getMessage());
		}
			
		
	}

	public void addStartup(Startup startup) throws UserException {
		
		try{
			begin();			
			startup.setPassword(Encryption.encrypt(startup.getPassword()));
			getSession().save(startup);
			commit();
			

		} catch (HibernateException e) {
			rollback();
			
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
			
	}

	public UserLoginDetails getUserDetails(String userName, String password) {
		// TODO Auto-generated method stub
		
		UserLoginDetails userLoginDetails= new UserLoginDetails();
		begin();
		Query query=getSession().createQuery("from UserLoginDetails u where u.userName=:userName and u.password=:password");
		query.setString("userName", userName);
		query.setString("password", password);
		userLoginDetails= (UserLoginDetails) query.uniqueResult();
		return userLoginDetails;
	}
}
