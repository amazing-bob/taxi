package com.taxi.vo.setting.base;

import java.io.Serializable;


public class BaseSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		mbrNo;
	protected int 		startRange;
	protected int 		endRange;
	protected String 	pushYn;
	protected int 		roomMbrNumLimit;
	protected String 	safeGuardPhoneNo;
	protected String 	safeGuardName;
	protected int 		safeTimeInterval;
	
	
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseSetting setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public int getStartRange() {
		return startRange;
	}
	public BaseSetting setStartRange(int startRange) {
		this.startRange = startRange;
		return this;
	}
	public int getEndRange() {
		return endRange;
	}
	public BaseSetting setEndRange(int endRange) {
		this.endRange = endRange;
		return this;
	}
	public String getPushYn() {
		return pushYn;
	}
	public BaseSetting setPushYn(String pushYn) {
		this.pushYn = pushYn;
		return this;
	}
	public int getRoomMbrNumLimit() {
		return roomMbrNumLimit;
	}
	public BaseSetting setRoomMbrNumLimit(int roomMbrNumLimit) {
		this.roomMbrNumLimit = roomMbrNumLimit;
		return this;
	}
	public String getSafeGuardPhoneNo() {
		return safeGuardPhoneNo;
	}
	public BaseSetting setSafeGuardPhoneNo(String safeGuardPhoneNo) {
		this.safeGuardPhoneNo = safeGuardPhoneNo;
		return this;
	}
	public String getSafeGuardName() {
		return safeGuardName;
	}
	public BaseSetting setSafeGuardName(String safeGuardName) {
		this.safeGuardName = safeGuardName;
		return this;
	}
	public int getSafeTimeInterval() {
		return safeTimeInterval;
	}
	public BaseSetting setSafeTimeInterval(int safeTimeInterval) {
		this.safeTimeInterval = safeTimeInterval;
		return this;
	}

}
