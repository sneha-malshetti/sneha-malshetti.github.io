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
@Table(name="Startup")
@PrimaryKeyJoinColumn(name = "userId")
public class Startup extends UserLoginDetails{
	
//	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="startupId", unique = true, nullable = false)
	private long startupId;
	
//	@JoinColumn(name = "userId", unique = true, nullable = false)
//	private long userId;
	
	@Column(name="startupName", unique = true, nullable = false)
	private String startupName;
	
	@Column(name="startupDescription", nullable = false)
	private String startupDescription;
	
	@Column(name="startupLicenseNumber", unique = true, nullable = false)
	private String startupLicenseNumber;
	
	@Column(name="startupFirstName")
	private String startupFirstName;
	
	@Column(name="startupLastName")
	private String startupLastName;
	
	@Column(name="startupEquity", nullable = false)
	private String startupEquity;
	
	@Column(name="startupStreet")
	private String startupStreet;
	
	@Column(name="startupCity")
	private String startupCity;
	
	@Column(name="startupState")
	private String startupState;
	
	@Column(name="startupCountry")
	private String startupCountry;
	
	@Column(name="zip")
	private String zip;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "startup")
//  @JoinColumn(name="investorId")
	private Set<StartupInvestments> startupInvestments = new HashSet<StartupInvestments>();
//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="investorId")
//    private Set<StartupInvestments> investments;
	
	public Startup() {
		
	}



	public Startup(String startupName, String startupDescription, String startupLicenseNumber,
			String startupFirstName, String startupLastName, String startupEquity, String startupStreet,
			String startupCity, String startupState, String startupCountry, String zip) {
		
//		this.userId = userId;
		this.startupName = startupName;
		this.startupDescription = startupDescription;
		this.startupLicenseNumber = startupLicenseNumber;
		this.startupFirstName = startupFirstName;
		this.startupLastName = startupLastName;
		this.startupEquity = startupEquity;
		this.startupStreet = startupStreet;
		this.startupCity = startupCity;
		this.startupState = startupState;
		this.startupCountry = startupCountry;
		this.zip = zip;
	}



	public long getStartupId() {
		return startupId;
	}



	public void setStartupId(long startupId) {
		this.startupId = startupId;
	}



//	public long getUserId() {
//		return userId;
//	}
//
//
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}



	public String getStartupName() {
		return startupName;
	}



	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}



	public String getStartupDescription() {
		return startupDescription;
	}



	public void setStartupDescription(String startupDescription) {
		this.startupDescription = startupDescription;
	}



	public String getStartupLicenseNumber() {
		return startupLicenseNumber;
	}



	public void setStartupLicenseNumber(String startupLicenseNumber) {
		this.startupLicenseNumber = startupLicenseNumber;
	}



	public String getStartupFirstName() {
		return startupFirstName;
	}



	public void setStartupFirstName(String startupFirstName) {
		this.startupFirstName = startupFirstName;
	}



	public String getStartupLastName() {
		return startupLastName;
	}



	public void setStartupLastName(String startupLastName) {
		this.startupLastName = startupLastName;
	}



	public String getStartupEquity() {
		return startupEquity;
	}



	public void setStartupEquity(String startupEquity) {
		this.startupEquity = startupEquity;
	}



	public String getStartupStreet() {
		return startupStreet;
	}



	public void setStartupStreet(String startupStreet) {
		this.startupStreet = startupStreet;
	}



	public String getStartupCity() {
		return startupCity;
	}



	public void setStartupCity(String startupCity) {
		this.startupCity = startupCity;
	}



	public String getStartupState() {
		return startupState;
	}



	public void setStartupState(String startupState) {
		this.startupState = startupState;
	}



	public String getStartupCountry() {
		return startupCountry;
	}



	public void setStartupCountry(String startupCountry) {
		this.startupCountry = startupCountry;
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

	 public void addStartupInvestments(StartupInvestments startupInvestments) {
	        this.startupInvestments.add(startupInvestments);
	    }



	@Override
	public String toString() {
		return "Startup [startupId=" + startupId + ", startupName=" + startupName + ", startupDescription="
				+ startupDescription + ", startupLicenseNumber=" + startupLicenseNumber + ", startupFirstName="
				+ startupFirstName + ", startupLastName=" + startupLastName + ", startupEquity=" + startupEquity
				+ ", startupStreet=" + startupStreet + ", startupCity=" + startupCity + ", startupState=" + startupState
				+ ", startupCountry=" + startupCountry + ", zip=" + zip + ", startupInvestments=" + startupInvestments
				+ "]";
	}
	
	
}
