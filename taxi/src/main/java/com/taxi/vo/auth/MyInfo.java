package com.taxi.vo.auth;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;
import com.taxi.vo.member.base.BaseMbr;
import com.taxi.vo.room.Room;


public class MyInfo extends Mbr implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int		mbrNo;
	 * protected String 	mbrPhoneNo;
	 * protected String 	mbrUuid;
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
	// Account 관련
	protected int 		accountNo;
	protected String 	accountEmail;
	protected String 	accountSt;
	// Room 관련
	protected boolean 	isRoomMbr;
	protected Room 		myRoom;
	//  keyWord 관련
	protected int 		keywordNo;
	protected String  	keywordName;
	protected String 	keywordSt;
	
	
	public MyInfo setMbrNo(int mbrNo) {
		return (MyInfo) super.setMbrNo(mbrNo);
	}
	public MyInfo setMbrPhoneNo(String mbrPhoneNo) {
		return (MyInfo) super.setMbrPhoneNo(mbrPhoneNo);
	}
	public MyInfo setMbrUuid(String mbrUuid) {
		return (MyInfo) super.setMbrUuid(mbrUuid);
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
	public int getAccountNo() {
		return accountNo;
	}
	public MyInfo setAccountNo(int accountNo) {
		this.accountNo = accountNo;
		return this;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public MyInfo setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
		return this;
	}
	public String getAccountSt() {
		return accountSt;
	}
	public MyInfo setAccountSt(String accountSt) {
		this.accountSt = accountSt;
		return this;
	}
	public boolean isRoomMbr() {
		return isRoomMbr;
	}
	public MyInfo setRoomMbr(boolean isRoomMbr) {
		this.isRoomMbr = isRoomMbr;
		return this;
	}
	public Room getMyRoom() {
		return myRoom;
	}
	public MyInfo setMyRoom(Room myRoom) {
		this.myRoom = myRoom;
		return this;
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public MyInfo setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
	public String getKeywordName() {
		return keywordName;
	}
	public MyInfo setKeywordName(String keywordName) {
		this.keywordName = keywordName;
		return this;
	}
	public String getKeywordSt() {
		return keywordSt;
	}
	public MyInfo setKeywordSt(String keywordSt) {
		this.keywordSt = keywordSt;
		return this;
	}
	
	
	
}
