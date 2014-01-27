package com.taxi.vo.safe.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;



public class BaseSafe implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		safeNo;
	protected int 		mbrNo;
	protected String 	safeGuardPhoneNo;
	protected String 	safeGuardName;
	protected int 		safeGuardTimeInterval;
	protected Date 		safeStartDate;
	protected Date 		safeEndDate;
	
	
	public int getSafeNo() {
		return safeNo;
	}
	public BaseSafe setSafeNo(int safeNo) {
		this.safeNo = safeNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseSafe setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getSafeGuardPhoneNo() {
		return safeGuardPhoneNo;
	}
	public BaseSafe setSafeGuardPhoneNo(String safeGuardPhoneNo) {
		this.safeGuardPhoneNo = safeGuardPhoneNo;
		return this;
	}
	public String getSafeGuardName() {
		return safeGuardName;
	}
	public BaseSafe setSafeGuardName(String safeGuardName) {
		this.safeGuardName = safeGuardName;
		return this;
	}
	public int getSafeGuardTimeInterval() {
		return safeGuardTimeInterval;
	}
	public BaseSafe setSafeGuardTimeInterval(int safeGuardTimeInterval) {
		this.safeGuardTimeInterval = safeGuardTimeInterval;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getSafeStartDate() {
		return safeStartDate;
	}
	public BaseSafe setSafeStartDate(Date safeStartDate) {
		this.safeStartDate = safeStartDate;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getSafeEndDate() {
		return safeEndDate;
	}
	public BaseSafe setSafeEndDate(Date safeEndDate) {
		this.safeEndDate = safeEndDate;
		return this;
	}
	
	
}
