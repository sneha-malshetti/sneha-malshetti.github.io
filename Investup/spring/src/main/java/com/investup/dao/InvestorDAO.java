package com.investup.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.ast.SqlASTFactory;

import com.investup.pojo.Investor;
import com.investup.pojo.StartupInvestments;
import com.investup.utils.Encryption;

public class InvestorDAO extends DAO{

	public Investor getInvestorDetails(long userId) {
		
		begin();
		
		
		Criteria criteria = getSession().createCriteria(Investor.class);
		criteria.add(Restrictions.eq("userId", userId));
		Investor investor=new Investor();
		System.out.println("before query");
		investor=(Investor) criteria.uniqueResult();
//		System.out.println("InvestorDAO"+investor.toString());
	
	return investor;
	}


//	@SuppressWarnings("unchecked")
//	public List<StartupInvestments> getInvestments(Long userId) {
//begin();
//		
//		
////		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
////		criteria.createAlias("startupInvestments.investor", "investor");
////		criteria.createAlias("startupInvestments.startup", "startup");
////		criteria.add(Restrictions.eq("investor.userId", "startupInvestments.investorId"));
////		criteria.add(Restrictions.eq("startup.userId", "startupInvestments.startupId"));
////		criteria.add(Restrictions.eq("investor.userId", attribute));
////		/*Query query = getSession().createQuery("select * from StartupInvestments si "+
////		" join fetch si.investor i "+ 
////		" join fetch si.startup s "+
////		" where i.userId =:userId ");*/
////		//query.setInteger("userId", (Integer) attribute);
////		List<StartupInvestments> investmentList=new ArrayList<StartupInvestments>();
////		investmentList=criteria.list();
//try{
//System.out.println("before query");
//Query query = getSession().createQuery("from StartupInvestments startupInvestments inner join startupInvestments.startup startup where startup.userId= startupInvestments.startupId and startupInvestments.investorId=6 ");
//		query.setLong("userId",userId );
//		List<StartupInvestments> investments=query.list();
//		System.out.println("After Query");
//		System.out.println("Object retrieved");
//		System.out.println("In DAO after retriving"+investments.toString());
////		System.out.println("InvestorDAO"+investmentList.toString());
//	
//	return investments;
//	} catch (HibernateException e) {
//		rollback();
//		System.out.println("Exception while creating user: " + e.getMessage());
//		return null;
//		
//		
//	}	
//	}
	
	@SuppressWarnings("unchecked")
	public List<StartupInvestments> getInvestments(Object attribute) {
begin();
		
		
		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
		criteria.add(Restrictions.eq("startupInvestments.investor.userId", attribute));
		List<StartupInvestments> investmentList=new ArrayList<StartupInvestments>();
		investmentList=criteria.list();
		
	return investmentList;
	}

	@SuppressWarnings("unchecked")
	public List<StartupInvestments> getStartup(Object attribute) {
//		System.out.println("--Enable Filter--");
//		Filter filter = getSession().enableFilter("investmentStatusSuccessful");
//		filter.setParameter("investmentStatusSuccessful", new String("success"));
//		
		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
		System.out.println("inside getStartup()");
		System.out.println("attribure " +attribute);
//		criteria.add(Restrictions.eq("startupInvestments.investor.userId", attribute));
		criteria.addOrder(Order.desc("startupInvestments.amount"));
//		criteria.add(Restrictions.eq("startupInvestments.investmentStatus", "success"));
		List<StartupInvestments> investmentList=new ArrayList<StartupInvestments>();
		investmentList=criteria.list();
	//	System.out.println("InvestorDAO"+investmentList.toString());
	
	return investmentList;
	}

//	@SuppressWarnings("unchecked")
//	public List<StartupInvestments> getStartup(Object attribute) {
//		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
//		criteria.createAlias("startupInvestments.investor", "investor");
//		criteria.createAlias("startupInvestments.startup", "startup");
//		criteria.add(Restrictions.eq("investor.userId", "startupInvestments.investorId"));
//		criteria.add(Restrictions.eq("startup.userId", "startupInvestments.startupId"));
//		criteria.add(Restrictions.eq("investor.userId", attribute));
//		criteria.addOrder(Order.desc("amount"));
//		List<StartupInvestments> investmentList=new ArrayList<StartupInvestments>();
//		investmentList=criteria.list();
//		System.out.println("InvestorDAO"+investmentList.toString());
//	
//	return investmentList;
//	}

	
	public int updateInvestor(Investor investor) {
		try{
			int rows=0;
			begin();
			
			System.out.println("before commit"+investor.toString());
			getSession().update(investor);
			commit();		
			rows=1;
//			System.out.println("After commit: "+investor.toString());
			return rows;
//		return rows1;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Exception while updating investor: " + e.getMessage());
			return 0;
			
			
		}	
		
	}

	public int updateInvestorInvestment(Investor investor) {
		try{
			int rows=0;
			begin();
			
			System.out.println("before commit"+investor.toString());
			getSession().merge(investor);
			commit();		
			rows=1;
//			System.out.println("After commit: "+investor.toString());
			return rows;
//		return rows1;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Exception while updating investor: " + e.getMessage());
			return 0;
			
			
		}	
		
	}

	public StartupInvestments getStartupDetail(Long userId) {
		begin();
		System.out.println("inside getStartupDetail ");
		Criteria criteria = getSession().createCriteria(StartupInvestments.class,"startupInvestments");
		criteria.add(Restrictions.eq("startupInvestments.startup.userId", userId));
//		criteria.add(Restrictions.ge("amount",1));
		StartupInvestments investment=new StartupInvestments();
		criteria.setMaxResults(1); 
		investment=(StartupInvestments) criteria.uniqueResult();
//		System.out.println(investment.toString());
	return investment;
		
	}


	public StartupInvestments makeAnInvestment(StartupInvestments startupInvestments) {
		Date date=new Date();
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = ymdFormat.format(date);
		Date sqlDate=new Date();
		try {
			sqlDate = ymdFormat.parse(ymd);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
//		Query q2=getSession().createQuery("from Investor i where i.investorId= :adminId");
//		q2.setLong("adminId", );
//		Query q2=getSession().createQuery("from Startup s where s.startupId=:adminId");
//		q2.setLong("adminId", startupInvestments.getInvestmentStatus());
		
		System.out.println("IID"+startupInvestments.getInvestmentStatus());
		System.out.println("name"+startupInvestments.getInvestor().getInvestorFirstName());
		System.out.println("Date"+startupInvestments.getDate());
		System.out.println("SID"+startupInvestments.getStartup().getUserId());
		System.out.println("amt"+startupInvestments.getAmount());
		startupInvestments.setDate(sqlDate);
		begin();
		getSession().save(startupInvestments);
		commit();
		System.out.println("after saving"+new SimpleDateFormat("yyyy-MM-dd").format(date));
		System.out.println(sqlDate);
		System.out.println(date);
		
		return startupInvestments;
	}


	public Investor getInvestor(long investorId) {
		Session session = getSession();
		Query q = session.createQuery("from Investor i where userId = :investorId");
		q.setLong("investorId", investorId);
		Investor i = (Investor) q.uniqueResult();
		return i;
	}

	
	
	
	
	// FROM Startup s inner join StartupInvestments si on si.startup=s.userId where si.investor = :investor
	//select startup.startupName, startup.equity, startupinvestment.date, startupinvestment.amount from StartupInvestments as si inner join si.startup as s where si.startupId=s.userId and si.investorId=:userId");//on si.startup=s.userId where si.investor = :investor")

}
