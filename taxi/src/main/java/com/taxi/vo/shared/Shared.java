package com.taxi.vo.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.taxi.vo.shared.base.BaseShared;


public class Shared extends BaseShared implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		sharedNo;
	 * protected Date 		lastSharedDate;
	 */
	
	// protected int 		추가되는 변수;
	
	public Shared setMbrNo(int mbrNo) {
		return (Shared) super.setMbrNo(mbrNo);
	}
	public Shared setSharedNo(int sharedNo) {
		return (Shared) super.setSharedNo(sharedNo);
	}
	public Shared setLastSharedDate(Date lastSharedDate) {
		return (Shared) super.setLastSharedDate(lastSharedDate);
	}
		
}
