package com.investup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.StartupInvestments;
import com.investup.pojo.UserLoginDetails;
import com.investup.utils.Encryption;

public class StartupDAO extends DAO{

	public Startup getStartupDetails(Object object) {
		
		begin();
		
			System.out.println("in startupDAO");
			Criteria criteria = getSession().createCriteria(Startup.class);
			criteria.add(Restrictions.eq("userId", object));
			Startup startup=new Startup();
			startup=(Startup) criteria.uniqueResult();
//			System.out.println("StartupDAO"+startup.getUserName()+", "+startup.getUserId());
		
		commit();
		System.out.println("commit done ");
		return startup;
	}
//Update Startup details
	public int updateStartup(Startup startupDetails) {
		try{
			int rows=0;
			begin();
			
			System.out.println("before commit"+startupDetails.toString());
			
			
			startupDetails.setPassword(Encryption.encrypt(startupDetails.getPassword()));
			getSession().update(startupDetails);
			commit();
//					
			rows=1;
//			System.out.println("After commit: "+startupDetails.toString());
			return rows;
//		return rows1;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Exception while updating startup: " + e.getMessage());
			return 0;
			
			
		}	
	}
	
	public int updateStartupInvestment(Startup startupDetails) {
		try{
			int rows=0;
			System.out.println("inside updateStartupInvestment()");
			begin();
			
	//		System.out.println("before commit"+startupDetails.toString());
	//		startupDetails.setPassword(Encryption.encrypt(startupDetails.getPassword()));
			getSession().merge(startupDetails);
			commit();
//					
			rows=1;
//			System.out.println("After commit: "+startupDetails.toString());
			return rows;
//		return rows1;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Exception while updating startup: " + e.getMessage());
			return 0;

		}	
	}
	
	
	public List<StartupInvestments> getInvestmentsForStartup(Long userId) {
		begin();
		
		
		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
		criteria.add(Restrictions.eq("startupInvestments.startup.userId", userId));
		List<StartupInvestments> investmentList=new ArrayList<StartupInvestments>();
		investmentList=criteria.list();
		
	return investmentList;
		
	}
	public List<Object[]> getAllInvestors() {
		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
		ProjectionList projList= Projections.projectionList();
		projList.add(Projections.property("investor"));
//		projList.add(Projections.property("investor.getInvestorLasttName()"));
		projList.add(Projections.sum("amount"),"sum_of_investments");
		projList.add(Projections.groupProperty("investor"));
//		projList.add(Projections.distinct("investor"));
//		projList.add(Projections.distinct("investorId");
		criteria.setProjection(projList);
//		criteria.addOrder(Order.desc("sum_of_investments"));
		
		List<Object[]> investmentList=criteria.list();
		System.out.println("List Size:"+investmentList.size());
		System.out.println("Output from startupDao");
		return investmentList;
	}
	
	public Startup getStartup(Long userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query q = session.createQuery("from Startup s where userId = :startupId");
		q.setLong("startupId", userId);
		Startup s = (Startup) q.uniqueResult();
		return s;
	}
	
	

//	public List<> getinvestors() {
//		begin();
//		Query query=createQuery("");
//		
//		
//		
//		List<Investor> investors=criteria.list();
//		System.out.println("StartupDAO"+startup.getUserName()+", "+startup.getUserId());
//		commit();
//		return investors;
//	}

//	Query q1=getSession().createQuery("update Startup as s set startupDescription = :startupDescription," +
//			"startupEquity= :startupEquity,"+
//			"startupStreet= :startupStreet,"+
//			"startupCity= :startupCity,"+
//			"startupState= :startupState,"+
//			"startupCountry= :startupCountry,"+
//			"zip= :zip"+
//			" where userId = :userId");
//	q1.setString("startupDescription", startupDetails.getStartupDescription());
//	q1.setString("startupStreet", startupDetails.getStartupStreet());
//	q1.setString("startupCity", startupDetails.getStartupCity());
//	q1.setString("startupCountry", startupDetails.getStartupCountry());
//	q1.setString("zip", startupDetails.getZip());
//	q1.setLong("userId", startupDetails.getUserId());
//	int rows1=q1.executeUpdate();
//	System.out.println("No of Rows1 "+ rows1);
//	
//	Query q2=getSession().createQuery("update UserLoginDetails as u set userName = :userName," +
//			"email= :email,"+
//			"contactNumber= :contactNumber,"+
//			"password= :password"+
//			" where userId = :userId");
//	
////	q2.setString("userName", startupDetails.getUserName());
//	q2.setString("email", startupDetails.getEmail());
//	q2.setString("contactNumber", startupDetails.getContactNumber());
//	q2.setString("password", startupDetails.getPassword());
//	q2.setLong("userId", startupDetails.getUserId());
//	
//	int rows2=q2.executeUpdate();
//	System.out.println("No of Rows2 "+ rows2);	
}
