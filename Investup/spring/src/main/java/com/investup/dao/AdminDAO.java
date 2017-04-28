package com.investup.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.investup.exception.UserException;
import com.investup.pojo.Investor;
import com.investup.pojo.Startup;
import com.investup.pojo.StartupInvestments;
import com.investup.pojo.UserLoginDetails;

public class AdminDAO extends DAO{

	@SuppressWarnings("unchecked")
	public List<UserLoginDetails> getPendingStartup() {
		begin();
		Criteria criteria = getSession().createCriteria(UserLoginDetails.class);
		criteria.add(Restrictions.eq("status", "pending"));
		criteria.add(Restrictions.eq("type", "startup"));
		List<UserLoginDetails> userList = new ArrayList<UserLoginDetails>();
		userList=criteria.list();
		System.out.println(userList.size());
		return userList;
	}
	@SuppressWarnings("unchecked")
	public List<UserLoginDetails> getactiveStartup() {
		begin();
		Criteria criteria = getSession().createCriteria(UserLoginDetails.class);
		criteria.add(Restrictions.eq("status", "active"));
		criteria.add(Restrictions.eq("type", "startup"));
		List<UserLoginDetails> userList = new ArrayList<UserLoginDetails>();
		userList=criteria.list();
		System.out.println(userList.size());
		return userList;
	}

	@SuppressWarnings("unchecked")
	public List<UserLoginDetails> getactiveInvestors() {
		begin();
		Criteria criteria = getSession().createCriteria(UserLoginDetails.class);
		criteria.add(Restrictions.eq("status", "active"));
		criteria.add(Restrictions.eq("type", "investor"));
		List<UserLoginDetails> userList = new ArrayList<UserLoginDetails>();
		userList=criteria.list();
		System.out.println(userList.size());
		return userList;
	}
	@SuppressWarnings("rawtypes")
	public List checkInvestments() {
		begin();
		Query query=getSession().createQuery("from Startup s , Investor i, StartupInvestments si  where s.startupId=si.startupId and i.userId=si.investorId");
		Criteria criteria = getSession().createCriteria("from Startup s , Investor i, StartupInvestments si  where s.startupId=si.startupId and i.userId=si.investorId");
		System.out.println(query.getQueryString());
		List userList = new ArrayList();
		List userList1 = new ArrayList();
		userList1=criteria.list();
		userList = (List) query.uniqueResult();
		
		System.out.println(userList.size()+","+userList1.size());
		return userList;
	}
	
	
	public int activateStartupStatus(List<Long> userIds, Long adminUserID) {
try{
		begin();
		Long result;
		int count=0;
		
		int i=0;
//		Investor investor=new Investor();
//		Startup startup=new Startup();
//		StartupInvestments startupInvestment=new StartupInvestments();
//		
////		Query q2=getSession().createQuery("from Investor i where i.investorId=:adminId");
//		q2.setLong("adminId", adminUserID);
//		investor=(Investor) q2.uniqueResult();
//		System.out.println(investor.toString());
		for(i = 0 ; i<userIds.size(); i++){
			result=userIds.get(i);
//		
		Query query=getSession().createQuery("update UserLoginDetails s set s.status='active' where s.userId=:startupId and status='pending'");
		query.setLong("startupId", result);
		int update=query.executeUpdate();
//		Query q1=getSession().createQuery("from Startup s where s.userId=:startupId");
//		q1.setLong("startupId",result);
//		startup=(Startup) q1.uniqueResult();
//		
//		Date date=new Date();
//		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String ymd = ymdFormat.format(date);
//		Date sqlDate=new Date();
//		try {
//			sqlDate = ymdFormat.parse(ymd);
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//		
//		startupInvestment.setAmount(0);
//		startupInvestment.setInvestmentStatus("Success");
//		startupInvestment.setInvestor(investor);
//		startupInvestment.setStartup(startup);
//		startupInvestment.setDate(sqlDate);
//		
//		begin();
//		getSession().save(startupInvestment);
//		commit();
		
		
		count= count+update;
//		System.out.println(query.getQueryString());
//		System.out.println("Query1"+q1.getQueryString());
//		System.out.println("Query2"+q2.getQueryString());
//		
		
		}
		commit();
		return count;
} catch (HibernateException e) {
	rollback();
	return 0;
//	System.out.println("Exception while creating user: " + e.getMessage());
}
	}
	
	
	public int rejectStartupStatus(List<Integer> userIds) {
		
		try{
			begin();
			int result=0;
			int count=0;
			
			int i=0;
			for(i = 0 ; i<userIds.size(); i++){
				result=userIds.get(i);
			
			Query query=getSession().createQuery("update UserLoginDetails s set s.status='rejected' where s.userId=:startupId and status='pending'");
			query.setInteger("startupId", result);
			int update=query.executeUpdate();
			count= count+update;
			System.out.println(query.getQueryString());
			
			}
			commit();
			return count;
	} catch (HibernateException e) {
		rollback();
		return 0;
//		System.out.println("Exception while creating user: " + e.getMessage());
		
	}	
	}
//public int rejectStartupStatus(List<Integer> userIds) {
//		
//		try{
//			begin();
//			int result=0;
//			int count=0;
//			
//			int i=0;
//			for(i = 0 ; i<userIds.size(); i++){
//				result=userIds.get(i);
//			
//			Query query=getSession().createQuery("update UserLoginDetails s set s.status='reject' where s.userId=:startupId and status='pending'");
//			query.setInteger("startupId", result);
//			int update=query.executeUpdate();
//			count= count+update;
//			System.out.println(query.getQueryString());
//			
//			}
//			commit();
//			return count;
//	} catch (HibernateException e) {
//		rollback();
//		return 0;
////		System.out.println("Exception while creating user: " + e.getMessage());
//		
//	}	
//	}
public int deactivateStartupStatus(List<Integer> userIds) {
	try{
		begin();
		int result=0;
		int count=0;
		
		int i=0;
		for(i = 0 ; i<userIds.size(); i++){
			result=userIds.get(i);
		
		Query query=getSession().createQuery("update UserLoginDetails s set s.status='deactivated' where s.userId=:startupId and status='active'");
		query.setInteger("startupId", result);
		int update=query.executeUpdate();
		count= count+update;
		System.out.println(query.getQueryString());
		
		}
		commit();
		return count;
} catch (HibernateException e) {
	rollback();
	return 0;
//	System.out.println("Exception while creating user: " + e.getMessage());
	
}
}
public int deactivateInvestorStatus(List<Integer> userIds) {
	try{
		begin();
		int result=0;
		int count=0;
		
		int i=0;
		for(i = 0 ; i<userIds.size(); i++){
			result=userIds.get(i);
		
		Query query=getSession().createQuery("update UserLoginDetails s set s.status='deactivated' where s.userId=:investorId and status='active'");
		query.setInteger("investorId", result);
		int update=query.executeUpdate();
		count= count+update;
		System.out.println(query.getQueryString());
		
		}
		commit();
		return count;
} catch (HibernateException e) {
	rollback();
	return 0;
//	System.out.println("Exception while creating user: " + e.getMessage());
	
}
}

}
