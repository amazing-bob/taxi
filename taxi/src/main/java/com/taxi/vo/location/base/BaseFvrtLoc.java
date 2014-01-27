package com.taxi.vo.location.base;

import java.io.Serializable;


public class BaseFvrtLoc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		fvrtLocNo;
	protected int 		mbrNo;
	protected String 	fvrtLocName;
	protected double 	fvrtLocLat;
	protected double 	fvrtLocLng;
	protected int 		fvrtLocRank;
	
	
	public int getFvrtLocNo() {
		return fvrtLocNo;
	}
	public BaseFvrtLoc setFvrtLocNo(int fvrtLocNo) {
		this.fvrtLocNo = fvrtLocNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseFvrtLoc setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getFvrtLocName() {
		return fvrtLocName;
	}
	public BaseFvrtLoc setFvrtLocName(String fvrtLocName) {
		this.fvrtLocName = fvrtLocName;
		return this;
	}
	public double getFvrtLocLat() {
		return fvrtLocLat;
	}
	public BaseFvrtLoc setFvrtLocLat(double fvrtLocLat) {
		this.fvrtLocLat = fvrtLocLat;
		return this;
	}
	public double getFvrtLocLng() {
		return fvrtLocLng;
	}
	public BaseFvrtLoc setFvrtLocLng(double fvrtLocLng) {
		this.fvrtLocLng = fvrtLocLng;
		return this;
	}
	public int getFvrtLocRank() {
		return fvrtLocRank;
	}
	public BaseFvrtLoc setFvrtLocRank(int fvrtLocRank) {
		this.fvrtLocRank = fvrtLocRank;
		return this;
	}
	
}
