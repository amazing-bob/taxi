package com.taxi.vo.auth;

import java.io.Serializable;
import java.util.List;

import com.taxi.vo.friend.Frnd;


public class LoginInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//////////////////////////////////////////////////////////
	// # LoginInfo 는 사용 하지 않는다!!!
	// # LoginInfo 대신에 MyInfo를 사용한다!!
	// # LoginInfo는 As-Is 버전에서 사용하던 Session 객체이이고
	// # To-Be 버전에서는 로그인을 Session으로 관리 하지 않고, 
	// # 나중에 Login VO객체와 혼동이 있을 것 같아서 
	// # LoginInfo 대신 MyInfo로 대신 사용한다.
	//
	// ## 1차개발 끝나면 지울 VO객체임!!
	//////////////////////////////////////////////////////////
	
	
	
/*	//====================== AS-IS =======================//
 	
	protected String		mbrId;
	protected String 		mbrName;
	protected String 		mbrPhoneNo;
	protected String 		mbrPhotoUrl;
	protected String 		mbrGender;
	protected List<Frnd>	frndList;
	protected int			startRange;
	protected int			endRange;
	
	public LoginInfo setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getMbrId() {
		return mbrId;
	}
	public LoginInfo setMbrEmail(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getMbrName() {
		return mbrName;
	}
	public LoginInfo setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public LoginInfo setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public LoginInfo setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	public String getMbrGender() {
		return mbrGender;
	}
	public LoginInfo setMbrGender(String mbrGender) {
		this.mbrGender = mbrGender;
		return this;
	}
	public LoginInfo setFrndList(List<Frnd> frndList) {
		this.frndList = frndList;
		return this;
	}
	public List<Frnd> getFrndList() {
		return frndList;
	}
	public int getStartRange() {
		return startRange;
	}
	public LoginInfo setStartRange(int startRange) {
		this.startRange = startRange;
		return this;
	}
	public int getEndRange() {
		return endRange;
	}
	public LoginInfo setEndRange(int endRange) {
		this.endRange = endRange;
		return this;
	}
*/
	
}
