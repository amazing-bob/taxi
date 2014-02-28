package com.taxi.vo.blacklist;

import java.io.Serializable;
import java.util.Date;

import com.taxi.vo.blacklist.base.BaseBlack;



public class Black extends BaseBlack implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		blackMbrNo;
	 * protected Date 		blackMbrRegDate;
	 */
	protected String 		blackMbrName;
	protected String 		blackMbrPhoneNo;
	protected String 		blackMbrPhotoUrl;
	
	public Black setMbrNo(int mbrNo) {
		return (Black) super.setMbrNo(mbrNo);
	}
	public Black setBlackMbrNo(int blackMbrNo) {
		return (Black) super.setBlackMbrNo(blackMbrNo);
	}
	public Black setBlackMbrRegDate(Date blackMbrRegDate) {
		return (Black) super.setBlackMbrRegDate(blackMbrRegDate);
	}
	
	
	public String getBlackMbrName() {
		return blackMbrName;
	}
	public Black setBlackMbrName(String blackMbrName) {
		this.blackMbrName = blackMbrName;
		return this;
	}
	public String getBlackMbrPhoneNo() {
		return blackMbrPhoneNo;
	}
	public Black setBlackMbrPhoneNo(String blackMbrPhoneNo) {
		this.blackMbrPhoneNo = blackMbrPhoneNo;
		return this;
	}
	public String getBlackMbrPhotoUrl() {
		return blackMbrPhotoUrl;
	}
	public Black setBlackMbrPhotoUrl(String blackMbrPhotoUrl) {
		this.blackMbrPhotoUrl = blackMbrPhotoUrl;
		return this;
	}
	
		
}
