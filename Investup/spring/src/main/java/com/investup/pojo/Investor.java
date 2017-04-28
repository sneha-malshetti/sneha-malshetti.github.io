package com.investup.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Investor")
@PrimaryKeyJoinColumn(name = "userId")
public class Investor extends UserLoginDetails{

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="investorId", unique = true, nullable = false)
	private long investorId;*/
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="investorId", unique = true, nullable = false)
//	private long investorId;
//	@JoinColumn(name = "userId", unique = true, nullable = false)
//	private long userId;
	
	@Column(name="investorFirstName")
	private String investorFirstName;
	
	@Column(name="investorLastName")
	private String investorLastName;
	
	@Column(name="investorStreet")
	private String investorStreet;
	
	@Column(name="investorCity")
	private String investorCity;
	
	@Column(name="investorState")
	private String investorState;
	
	@Column(name="investorCountry")
	private String investorCountry;
	
	@Column(name="zip")
	private String zip;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "investor")
//    @JoinColumn(name="investorId")
	private Set<StartupInvestments> startupInvestments = new HashSet<StartupInvestments>();
	
	
	

	public Investor() {
	}



	public Investor(String investorFirstName, String investorLastName, String investorStreet,
			String investorCity, String investorState, String investorCountry, String zip) {
		
//		this.userId = userId;
		this.investorFirstName = investorFirstName;
		this.investorLastName = investorLastName;
		this.investorStreet = investorStreet;
		this.investorCity = investorCity;
		this.investorState = investorState;
		this.investorCountry = investorCountry;
		this.zip = zip;
	}




//
//	public long getInvstorId() {
//		return investorId;
//	}
//
//
//
//
//
//	public void setInvstorId(long invstorId) {
//		this.investorId = invstorId;
//	}
//



//
//	public long getUserId() {
//		return userId;
//	}
//
//
//
//
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}





	public String getInvestorFirstName() {
		return investorFirstName;
	}





	public void setInvestorFirstName(String investorFirstName) {
		this.investorFirstName = investorFirstName;
	}





	public String getInvestorLastName() {
		return investorLastName;
	}





	public void setInvestorLastName(String investorLastName) {
		this.investorLastName = investorLastName;
	}





	public String getInvestorStreet() {
		return investorStreet;
	}





	public void setInvestorStreet(String investorStreet) {
		this.investorStreet = investorStreet;
	}





	public String getInvestorCity() {
		return investorCity;
	}





	public void setInvestorCity(String investorCity) {
		this.investorCity = investorCity;
	}





	public String getInvestorState() {
		return investorState;
	}





	public void setInvestorState(String investorState) {
		this.investorState = investorState;
	}





	public String getInvestorCountry() {
		return investorCountry;
	}





	public void setInvestorCountry(String investorCountry) {
		this.investorCountry = investorCountry;
	}





	public String getZip() {
		return zip;
	}





	public void setZip(String zip) {
		this.zip = zip;
	}

	
    
    public Set<StartupInvestments> getStartupInvestments() {
		return startupInvestments;
	}



	public void setStartupInvestments(Set<StartupInvestments> startupInvestments) {
		this.startupInvestments = startupInvestments;
	}



	public void addUserGroup(StartupInvestments startupInvestments) {
        this.startupInvestments.add(startupInvestments);
    }
	
	@Override
	public String toString() {
		return "Investor [investorFirstName=" + investorFirstName + ", investorLastName=" + investorLastName
				+ ", investorStreet=" + investorStreet + ", investorCity=" + investorCity + ", investorState="
				+ investorState + ", investorCountry=" + investorCountry + ", zip=" + zip + ", startupInvestments="
				+ startupInvestments + "]";
	}
	
}
