package com.taxi.vo.blacklist.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;


public class BaseBlack implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		mbrNo;
	protected int 		blackMbrNo;
	protected Date 		blackMbrRegDate;
	
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseBlack setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public int getBlackMbrNo() {
		return blackMbrNo;
	}
	public BaseBlack setBlackMbrNo(int blackMbrNo) {
		this.blackMbrNo = blackMbrNo;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getBlackMbrRegDate() {
		return blackMbrRegDate;
	}
	public BaseBlack setBlackMbrRegDate(Date blackMbrRegDate) {
		this.blackMbrRegDate = blackMbrRegDate;
		return this;
	}
	
}
