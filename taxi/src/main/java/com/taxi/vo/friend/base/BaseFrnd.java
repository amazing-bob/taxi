package com.taxi.vo.friend.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;

public class BaseFrnd implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		mbrNo;
	protected String 	frndPhoneNo;
	protected String 	frndName;
	protected Date 		frndRegDate;
	
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseFrnd setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getFrndPhoneNo() {
		return frndPhoneNo;
	}
	public BaseFrnd setFrndPhoneNo(String frndPhoneNo) {
		this.frndPhoneNo = frndPhoneNo;
		return this;
	}
	public String getFrndName() {
		return frndName;
	}
	public BaseFrnd setFrndName(String frndName) {
		this.frndName = frndName;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getFrndRegDate() {
		return frndRegDate;
	}
	public BaseFrnd setFrndRegDate(Date frndRegDate) {
		this.frndRegDate = frndRegDate;
		return this;
	}
	
	
}
