package com.taxi.vo.auth.base;

import java.io.Serializable;
import java.util.List;


public class BaseAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		accountNo;
	protected String 	accountEmail;
	protected String 	accountPassword;
	protected int 		mbrNo;
	protected String 	accountSt;
	
	
	public int getAccountNo() {
		return accountNo;
	}
	public BaseAccount setAccountNo(int accountNo) {
		this.accountNo = accountNo;
		return this;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public BaseAccount setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
		return this;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public BaseAccount setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseAccount setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getAccountSt() {
		return accountSt;
	}
	public BaseAccount setAccountSt(String accountSt) {
		this.accountSt = accountSt;
		return this;
	}
	
}
