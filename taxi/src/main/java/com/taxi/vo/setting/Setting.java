package com.taxi.vo.setting;

import java.io.Serializable;

import com.taxi.vo.setting.base.BaseSetting;


public class Setting extends BaseSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		startRange;
	 * protected int 		endRange;
	 * protected String 	pushYn;
	 * protected int 		roomMbrNumLimit;
	 * protected String 	safeGuardPhoneNo;
	 * protected String 	safeGuardName;
	 * protected int 		safeTimeInterval;
	 */
	
	// protected int 		추가되는 변수;
	
	public Setting setMbrNo(int mbrNo) {
		return (Setting) super.setMbrNo(mbrNo);
	}
	public Setting setStartRange(int startRange) {
		return (Setting) super.setStartRange(startRange);
	}
	public Setting setEndRange(int endRange) {
		return (Setting) super.setEndRange(endRange);
	}
	public Setting setPushYn(String pushYn) {
		return (Setting) super.setPushYn(pushYn);
	}
	public Setting setRoomMbrNumLimit(int roomMbrNumLimit) {
		return (Setting) super.setRoomMbrNumLimit(roomMbrNumLimit);
	}
	public Setting setSafeGuardPhoneNo(String safeGuardPhoneNo) {
		return (Setting) super.setSafeGuardPhoneNo(safeGuardPhoneNo);
	}
	public Setting setSafeGuardName(String safeGuardName) {
		return (Setting) super.setSafeGuardName(safeGuardName);
	}
	public Setting setSafeTimeInterval(int safeTimeInterval) {
		return (Setting) super.setSafeTimeInterval(safeTimeInterval);
	}
	
	
/*	//====================== AS-IS =======================//
 	
	protected String			mbrId;
	protected int		 		startRange;
	protected int		 		endRange;
	
	public String getMbrId() {
		return mbrId;
	}
	public Setting setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public int getStartRange() {
		return startRange;
	}
	public Setting setStartRange(int startRange) {
		this.startRange = startRange;
		return this;
	}
	public int getEndRange() {
		return endRange;
	}
	public Setting setEndRange(int endRange) {
		this.endRange = endRange;
		return this;
	}
*/	

}
