package com.taxi.vo.auth;

import java.io.Serializable;
import java.util.List;

import com.taxi.vo.auth.base.BaseLogin;



public class Login extends BaseLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		loginNo;
	 * protected int 		mbrNo;
	 * protected String 	loginEmail;
	 * protected String 	loginEmail;
	 * protected String 	loginSt;
	 * protected String 	loginPassword;
	 */
	
	// protected int 		추가되는 변수;
	
	
	public Login setLoginNo(int loginNo) {
		return (Login) super.setLoginNo(loginNo);
	}
	public Login setMbrNo(int mbrNo) {
		return (Login) super.setMbrNo(mbrNo);
	}
	public Login setLoginEmail(String loginEmail) {
		return (Login) super.setLoginEmail(loginEmail);
	}
	public Login setLoginSt(String loginSt) {
		return (Login) super.setLoginSt(loginSt);
	}
	public Login setLoginPassword(String loginPassword) {
		return (Login) super.setLoginPassword(loginPassword);
	}
	
	
}
