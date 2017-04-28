package com.investup.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "UserLoginDetails")
@Inheritance(strategy=InheritanceType.JOINED)  
public class UserLoginDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId", unique = true, nullable = false)
	private long userId;
	
	@Column(name="userName", unique = true, nullable = false)
	private String userName;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="type", nullable = false)
	private String type;
	
	@Column(name="contactNumber", nullable = false)
	private String contactNumber;
	
	@Column(name="status", nullable = false)
	private String status;
	
	public UserLoginDetails(String userName, String email, String password, String type, String contactNumber,
			String status) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.type = type;
		this.contactNumber = contactNumber;
		this.status = status;
	}

	public UserLoginDetails() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UserLoginDetails [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", type=" + type + ", contactNumber=" + contactNumber + ", status=" + status + "]";
	}

	
	
}
