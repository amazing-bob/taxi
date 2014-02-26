package com.taxi.vo.member.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;


public class BaseMbr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int		mbrNo;
	protected String 	mbrPhoneNo;
	protected String 	mbrDeviceNo;
	protected String 	mbrName;
	protected String 	mbrPhotoUrl;
	protected String 	mbrGender;
	protected Date 		mbrRegDate;
	protected Date 		lastLoginDate;
	protected Date 		mbrUpdateDate;
	protected int 		mbrKeywordNo;
	
	public int getMbrKeywordNo() {
		return mbrKeywordNo;
	}
	public BaseMbr setMbrKeywordNo(int mbrKeywordNo) {
		this.mbrKeywordNo = mbrKeywordNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseMbr setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public BaseMbr setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrDeviceNo() {
		return mbrDeviceNo;
	}
	public BaseMbr setMbrDeviceNo(String mbrDeviceNo) {
		this.mbrDeviceNo = mbrDeviceNo;
		return this;
	}
	public String getMbrName() {
		return mbrName;
	}
	public BaseMbr setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public BaseMbr setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	public String getMbrGender() {
		return mbrGender;
	}
	public BaseMbr setMbrGender(String mbrGender) {
		this.mbrGender = mbrGender;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getMbrRegDate() {
		return mbrRegDate;
	}
	public BaseMbr setMbrRegDate(Date mbrRegDate) {
		this.mbrRegDate = mbrRegDate;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public BaseMbr setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getMbrUpdateDate() {
		return mbrUpdateDate;
	}
	public BaseMbr setMbrUpdateDate(Date mbrUpdateDate) {
		this.mbrUpdateDate = mbrUpdateDate;
		return this;
	}
	
}
