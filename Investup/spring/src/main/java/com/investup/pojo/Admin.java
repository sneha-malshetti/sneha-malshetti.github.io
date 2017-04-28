package com.investup.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name = "userId")
public class Admin extends UserLoginDetails{

//	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="adminId", unique = true, nullable = false)
	private long adminId;
	
//	@JoinColumn(name = "userid")
//	private long userId;
	
		
	@Column(name="adminfirstname")
	private String adminFirstName;
	
	@Column(name="adminlastname")
	private String adminLastName;
	
	
	public Admin() {
		
	}
	public Admin(String adminFirstName, String adminLastName) {
		
//		this.adminId = adminId;
//		this.userId = userId;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
//	public long getUserId() {
//		return userId;
//	}
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	
	
	
}
