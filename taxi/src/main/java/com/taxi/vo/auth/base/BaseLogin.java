package com.taxi.vo.auth.base;

import java.io.Serializable;
import java.util.List;


public class BaseLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		loginNo;
	protected int 		mbrNo;
	protected String 	loginEmail;
	protected String 	loginSt;
	protected String 	loginPassword;
	
	
	public int getLoginNo() {
		return loginNo;
	}
	public BaseLogin setLoginNo(int loginNo) {
		this.loginNo = loginNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseLogin setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public BaseLogin setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
		return this;
	}
	public String getLoginSt() {
		return loginSt;
	}
	public BaseLogin setLoginSt(String loginSt) {
		this.loginSt = loginSt;
		return this;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public BaseLogin setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
		return this;
	}
	
	
}
