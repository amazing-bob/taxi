package com.taxi.vo.shared.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;



public class BaseShared implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		mbrNo;
	protected int 		sharedNo;
	protected Date 		lastSharedDate;
	
	
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseShared setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public int getSharedNo() {
		return sharedNo;
	}
	public BaseShared setSharedNo(int sharedNo) {
		this.sharedNo = sharedNo;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getLastSharedDate() {
		return lastSharedDate;
	}
	public BaseShared setLastSharedDate(Date lastSharedDate) {
		this.lastSharedDate = lastSharedDate;
		return this;
	}
	
	
	
}
