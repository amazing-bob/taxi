package com.taxi.vo.auth;

import java.io.Serializable;
import com.taxi.vo.auth.base.BaseAccount;



public class Account extends BaseAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		accountNo;
	 * protected String 	accountEmail;
	 * protected String 	accountPassword;
	 * protected int 		mbrNo;
	 * protected String 	accountSt;
	 */
	
	// protected int 		추가되는 변수;
	
	
	public Account setAccountNo(int accountNo) {
		return (Account) super.setAccountNo(accountNo);
	}
	public Account setAccountEmail(String accountEmail) {
		return (Account) super.setAccountEmail(accountEmail);
	}
	public Account setAccountPassword(String accountPassword) {
		return (Account) super.setAccountPassword(accountPassword);
	}
	public Account setMbrNo(int mbrNo) {
		return (Account) super.setMbrNo(mbrNo);
	}
	public Account setAccountSt(String accountSt) {
		return (Account) super.setAccountSt(accountSt);
	}
	
}
