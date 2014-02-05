package com.taxi.vo.auth;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;
import com.taxi.vo.member.base.BaseMbr;


public class MyInfo extends Mbr implements Serializable {
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
	// Setting 관련
	protected int 		startRange;
	protected int 		endRange;
	protected String 	pushYn;
	protected int 		roomMbrNumLimit;
	protected String 	safeGuardPhoneNo;
	protected String 	safeGuardName;
	protected int 		safeTimeInterval;
	// Login 관련
	protected int 		loginNo;
	protected String 	loginEmail;
	protected String 	loginSt;
	protected String 	loginPassword;
	// Room 관련
	protected int 		roomNo;
	
	
	public MyInfo setMbrNo(int mbrNo) {
		return (MyInfo) super.setMbrNo(mbrNo);
	}
	public MyInfo setMbrPhoneNo(String mbrPhoneNo) {
		return (MyInfo) super.setMbrPhoneNo(mbrPhoneNo);
	}
	public MyInfo setMbrDeviceNo(String mbrDeviceNo) {
		return (MyInfo) super.setMbrDeviceNo(mbrDeviceNo);
	}
	public MyInfo setMbrName(String mbrName) {
		return (MyInfo) super.setMbrName(mbrName);
	}
	public MyInfo setMbrPhotoUrl(String mbrPhotoUrl) {
		return (MyInfo) super.setMbrPhotoUrl(mbrPhotoUrl);
	}
	public MyInfo setMbrGender(String mbrGender) {
		return (MyInfo) super.setMbrGender(mbrGender);
	}
	public MyInfo setMbrRegDate(Date mbrRegDate) {
		return (MyInfo) super.setMbrRegDate(mbrRegDate);
	}
	public MyInfo setLastLoginDate(Date lastLoginDate) {
		return (MyInfo) super.setLastLoginDate(lastLoginDate);
	}
	public MyInfo setMbrUpdateDate(Date mbrUpdateDate) {
		return (MyInfo) super.setMbrUpdateDate(mbrUpdateDate);
	}
	
	
	public int getStartRange() {
		return startRange;
	}
	public MyInfo setStartRange(int startRange) {
		this.startRange = startRange;
		return this;
	}
	public int getEndRange() {
		return endRange;
	}
	public MyInfo setEndRange(int endRange) {
		this.endRange = endRange;
		return this;
	}
	public String getPushYn() {
		return pushYn;
	}
	public MyInfo setPushYn(String pushYn) {
		this.pushYn = pushYn;
		return this;
	}
	public int getRoomMbrNumLimit() {
		return roomMbrNumLimit;
	}
	public MyInfo setRoomMbrNumLimit(int roomMbrNumLimit) {
		this.roomMbrNumLimit = roomMbrNumLimit;
		return this;
	}
	public String getSafeGuardPhoneNo() {
		return safeGuardPhoneNo;
	}
	public MyInfo setSafeGuardPhoneNo(String safeGuardPhoneNo) {
		this.safeGuardPhoneNo = safeGuardPhoneNo;
		return this;
	}
	public String getSafeGuardName() {
		return safeGuardName;
	}
	public MyInfo setSafeGuardName(String safeGuardName) {
		this.safeGuardName = safeGuardName;
		return this;
	}
	public int getSafeTimeInterval() {
		return safeTimeInterval;
	}
	public MyInfo setSafeTimeInterval(int safeTimeInterval) {
		this.safeTimeInterval = safeTimeInterval;
		return this;
	}
	public int getLoginNo() {
		return loginNo;
	}
	public MyInfo setLoginNo(int loginNo) {
		this.loginNo = loginNo;
		return this;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public MyInfo setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
		return this;
	}
	public String getLoginSt() {
		return loginSt;
	}
	public MyInfo setLoginSt(String loginSt) {
		this.loginSt = loginSt;
		return this;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public MyInfo setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
		return this;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public MyInfo setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	
	
}
