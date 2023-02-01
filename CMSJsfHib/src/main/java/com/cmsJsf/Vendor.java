package com.cmsJsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
@ManagedBean
@SessionScoped
public class Vendor {
	@Id
	@Column(name = "VEN_ID")
	private int vendorId;
	@Column(name = "VEN_NAME")
	private String vendorName;
	@Column(name = "VEN_PHN_NO")
	private String phoneNo;
	@Column(name = "VEN_USERNAME")
	private String userName;
	@Column(name = "VEN_PASSWORD")
	private String password;
	@Column(name = "VEN_EMAIL")
	private String email;
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
