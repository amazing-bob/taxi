package com.taxi.vo.safe;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.taxi.vo.safe.base.BaseSafe;


public class Safe extends BaseSafe implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		safeNo;
	 * protected int 		mbrNo;
	 * protected String 	safeGuardPhoneNo;
	 * protected String 	safeGuardName;
	 * protected int 		safeGuardTimeInterval;
	 * protected Date 		safeStartDate;
	 * protected Date 		safeEndDate;
	 */
	
	// protected int 		추가되는 변수;
	
	public Safe setSafeNo(int safeNo) {
		return (Safe) super.setSafeNo(safeNo); 
	}
	public Safe setMbrNo(int mbrNo) {
		return (Safe) super.setMbrNo(mbrNo);
	}
	public Safe setSafeGuardPhoneNo(String safeGuardPhoneNo) {
		return (Safe) super.setSafeGuardPhoneNo(safeGuardPhoneNo);
	}
	public Safe setSafeGuardName(String safeGuardName) {
		return (Safe) super.setSafeGuardName(safeGuardName);
	}
	public Safe setSafeGuardTimeInterval(int safeGuardTimeInterval) {
		return (Safe) super.setSafeGuardTimeInterval(safeGuardTimeInterval);
	}
	public Safe setSafeStartDate(Date safeStartDate) {
		return (Safe) super.setSafeStartDate(safeStartDate);
	}
	public Safe setSafeEndDate(Date safeEndDate) {
		return (Safe) super.setSafeEndDate(safeEndDate);
	}
		
}
