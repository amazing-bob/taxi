package com.taxi.vo.friend;

import java.io.Serializable;
import java.util.Date;

import com.taxi.vo.friend.base.BaseFrnd;

public class Frnd extends BaseFrnd implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected String 	frndPhoneNo;
	 * protected String 	frndName;
	 * protected Date 		frndRegDate;
	 */
	
	// protected int 		추가되는 변수;
	
	public Frnd setMbrNo(int mbrNo) {
		return (Frnd) super.setMbrNo(mbrNo);
	}
	public Frnd setFrndPhoneNo(String frndPhoneNo) {
		return (Frnd) super.setFrndPhoneNo(frndPhoneNo);
	}
	public Frnd setFrndName(String frndName) {
		return (Frnd) super.setFrndName(frndName);
	}
	public Frnd setFrndRegDate(Date frndRegDate) {
		return (Frnd) super.setFrndRegDate(frndRegDate);
	}
	
	
/*	//====================== AS-IS =======================//
 	
	protected String 	mbrId;
	protected String	frndId;
	protected String 	frndName;
	protected String 	frndPhotoUrl;
	
	public String getMbrId() {
		return mbrId;
	}
	public Frnd setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getFrndId() {
		return frndId;
	}
	public Frnd setFrndId(String frndId) {
		this.frndId = frndId;
		return this;
	}
	public String getFrndName() {
		return frndName;
	}
	public Frnd setFrndName(String frndName) {
		this.frndName = frndName;
		return this;
	}
	public String getFrndPhotoUrl() {
		return frndPhotoUrl;
	}
	public Frnd setFrndPhotoUrl(String frndPhotoUrl) {
		this.frndPhotoUrl = frndPhotoUrl;
		return this;
	}
*/
	
}
