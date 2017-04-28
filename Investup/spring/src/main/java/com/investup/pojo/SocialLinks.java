package com.investup.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SocialLinks")
public class SocialLinks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invstorId", unique = true, nullable = false)
	private long socialLinkId;
	private long userId;
	private String socialType;
	private String socialStatus;
	private String link;
	public SocialLinks() {
		
	}
	public SocialLinks(long userId, String socialType, String socialStatus, String link) {
		
		this.userId = userId;
		this.socialType = socialType;
		this.socialStatus = socialStatus;
		this.link = link;
	}
	public long getSocialLinkId() {
		return socialLinkId;
	}
	public void setSocialLinkId(long socialLinkId) {
		this.socialLinkId = socialLinkId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getSocialType() {
		return socialType;
	}
	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}
	public String getSocialStatus() {
		return socialStatus;
	}
	public void setSocialStatus(String socialStatus) {
		this.socialStatus = socialStatus;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
