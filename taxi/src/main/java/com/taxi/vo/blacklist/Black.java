package com.taxi.vo.blacklist;

import java.io.Serializable;
import java.util.Date;

import com.taxi.vo.blacklist.base.BaseBlack;



public class Black extends BaseBlack implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		blackNo;
	 * protected Date 		blackMbrRegDate;
	 */
	protected String 		mbrName;
	protected String 		mbrPhoneNo;
	protected String 		mbrPhotoUrl;
	
	public Black setMbrNo(int mbrNo) {
		return (Black) super.setMbrNo(mbrNo);
	}
	public Black setBlackNo(int blackNo) {
		return (Black) super.setBlackNo(blackNo);
	}
	public Black setBlackMbrRegDate(Date blackMbrRegDate) {
		return (Black) super.setBlackMbrRegDate(blackMbrRegDate);
	}
	
	public String getMbrName() {
		return mbrName;
	}
	public Black setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public Black setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public Black setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	
	
	
		
}
