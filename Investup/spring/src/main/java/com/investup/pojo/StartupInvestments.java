package com.investup.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="StartupInvestments")
//@FilterDef(name="successfulTransactions", parameters={
//		@ParamDef( name="investmentStatusSuccessful", type="string" )
//////		@ParamDef( name="minAge", type="integer" ),
//////		@ParamDef( name="minNumber", type="integer")
//})
//@Filters( {
//    @Filter(name="successfulTransactions", condition=":investmentStatusSuccessful=investmentStatus "),
////    @Filter(name="studentFilter", condition=":minNumber <= number")
//} )
//@FilterDef(name="minimumInvestment", parameters={
//		@ParamDef( name="minInvestment", type="integer" )
		
//})
//@Filters( {
//    @Filter(name="minimumInvestment", condition=":minInvestment <= amount")
    
//} )
public class StartupInvestments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="investmentId", unique = true, nullable = false)
	private long investmentId;
	
//	@JoinColumn(name = "startupId", unique = true, nullable = false)
//	private long startupId;
	
//	@JoinColumn(name = "investorId", unique = true, nullable = false)
//	private long investorId;
	
	@Column(name = "amount", nullable = false)
	private long amount;
	
	@Temporal(TemporalType.DATE)
	private Date date ;
	
	@Column(name = "investmentStatus")
	private String investmentStatus;
	
	@ManyToOne
	@JoinColumn(name="startupId")
	private Startup startup;
	
	
	@ManyToOne
	@JoinColumn(name="investorId")
	private Investor investor;

	public StartupInvestments() {
	
	}

	public StartupInvestments(long investorId, long amount, Date date, String investmentStatus) {
		
//		this.startupId = startupId;
//		this.investorId = investorId;
		this.amount = amount;
		this.date = date;
		this.investmentStatus = investmentStatus;
	}

	public long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
	}

//	public long getStartupId() {
//		return startupId;
//	}
//
//	public void setStartupId(long startupId) {
//		this.startupId = startupId;
//	}

//	public long getInvestorId() {
//		return investorId;
//	}
//
//	public void setInvestorId(long investorId) {
//		this.investorId = investorId;
//	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInvestmentStatus() {
		return investmentStatus;
	}

	public void setInvestmentStatus(String investmentStatus) {
		this.investmentStatus = investmentStatus;
	}

	public Startup getStartup() {
		return startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	@Override
	public String toString() {
		return "StartupInvestments [investmentId=" + investmentId + ", amount=" + amount + ", date=" + date
				+ ", investmentStatus=" + investmentStatus + ", startup=" + startup + ", investor=" + investor + "]";
	}
	

	
	
	
}
