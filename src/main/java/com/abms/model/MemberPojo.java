package com.abms.model;

import java.sql.Date;

public class MemberPojo {
	
	private String MemberId; 
	private String MemberName;
	private Date MemberDate;
	private String Address;
	private String MemberType;
	private Date ExpiryDate;
	
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public Date getMemberDate() {
		return MemberDate;
	}
	public void setMemberDate(Date memberDate) {
		MemberDate = memberDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMemberType() {
		return MemberType;
	}
	public void setMemberType(String memberType) {
		MemberType = memberType;
	}
	public Date getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		ExpiryDate = expiryDate;
	}
}
