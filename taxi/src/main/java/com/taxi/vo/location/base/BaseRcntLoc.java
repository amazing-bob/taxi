package com.taxi.vo.location.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;


public class BaseRcntLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		rcntLocNo;
	protected int 		mbrNo;
	protected String 	rcntLocName;
	protected String 	rcntLocSt;
	protected double 	rcntLocLat;
	protected double 	rcntLocLng;
	protected Date 		rcntLocRegDate;
	
	public int getRcntlocNo() {
		return rcntLocNo;
	}
	public BaseRcntLoc setRcntlocNo(int rcntlocNo) {
		this.rcntLocNo = rcntlocNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseRcntLoc setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getRcntLocName() {
		return rcntLocName;
	}
	public BaseRcntLoc setRcntLocName(String rcntLocName) {
		this.rcntLocName = rcntLocName;
		return this;
	}
	public String getRcntLocSt() {
		return rcntLocSt;
	}
	public BaseRcntLoc setRcntLocSt(String rcntLocSt) {
		this.rcntLocSt = rcntLocSt;
		return this;
	}
	public double getRcntLocLat() {
		return rcntLocLat;
	}
	public BaseRcntLoc setRcntLocLat(double rcntLocLat) {
		this.rcntLocLat = rcntLocLat;
		return this;
	}
	public double getRcntLocLng() {
		return rcntLocLng;
	}
	public BaseRcntLoc setRcntLocLng(double rcntLocLng) {
		this.rcntLocLng = rcntLocLng;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getRcntLocRegDate() {
		return rcntLocRegDate;
	}
	public BaseRcntLoc setRcntLocRegDate(Date rcntLocRegDate) {
		this.rcntLocRegDate = rcntLocRegDate;
		return this;
	}
	
	
	
}
