package com.taxi.vo.member;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.base.BaseMbr;


public class Mbr extends BaseMbr implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int		mbrNo;
	 * protected String 	mbrPhoneNo;
	 * protected String 	mbrDeviceNo;
	 * protected String 	mbrName;
	 * protected String 	mbrPhotoUrl;
	 * protected String 	mbrGender;
	 * protected Date 		mbrRegDate;
	 * protected Date 		lastLoginDate;
	 * protected Date 		mbrUpdateDate;
	 */
	
	// protected int 		추가되는 변수;
	
	public Mbr setMbrNo(int mbrNo) {
		return (Mbr) super.setMbrNo(mbrNo);
	}
	public Mbr setMbrPhoneNo(String mbrPhoneNo) {
		return (Mbr) super.setMbrPhoneNo(mbrPhoneNo);
	}
	public Mbr setMbrDeviceNo(String mbrDeviceNo) {
		return (Mbr) super.setMbrDeviceNo(mbrDeviceNo);
	}
	public Mbr setMbrName(String mbrName) {
		return (Mbr) super.setMbrName(mbrName);
	}
	public Mbr setMbrPhotoUrl(String mbrPhotoUrl) {
		return (Mbr) super.setMbrPhotoUrl(mbrPhotoUrl);
	}
	public Mbr setMbrGender(String mbrGender) {
		return (Mbr) super.setMbrGender(mbrGender);
	}
	public Mbr setMbrRegDate(Date mbrRegDate) {
		return (Mbr) super.setMbrRegDate(mbrRegDate);
	}
	public Mbr setLastLoginDate(Date lastLoginDate) {
		return (Mbr) super.setLastLoginDate(lastLoginDate);
	}
	public Mbr setMbrUpdateDate(Date mbrUpdateDate) {
		return (Mbr) super.setMbrUpdateDate(mbrUpdateDate);
	}
	

/*	//====================== AS-IS =======================//
 	
	protected String			mbrId;
	protected String 		mbrName;
	protected String 		mbrPhoneNo;
	protected String 		mbrPhotoUrl;
	protected String 		mbrGender;
	protected Date 			mbrRegDate;
	protected List<Frnd>	frndList;
	
	public List<Frnd> getFrndList() {
		return frndList;
	}
	public Mbr setFrndList(List<Frnd> frndList) {
		this.frndList = frndList;
		return this;
	}
	
	public String getMbrId() {
		return mbrId;
	}
	public Mbr setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getMbrName() {
		return mbrName;
	}
	public Mbr setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public Mbr setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public Mbr setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	public String getMbrGender() {
		return mbrGender;
	}
	public Mbr setMbrGender(String mbrGender) {
		this.mbrGender = mbrGender;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getMbrRegDate() {
		return mbrRegDate;
	}
	public Mbr setMbrRegDate(Date mbrRegDate) {
		this.mbrRegDate = mbrRegDate;
		return this;
	}
*/
	
}
