package com.taxi.vo.calltaxi;

import java.io.Serializable;
import java.util.List;

import com.taxi.vo.calltaxi.base.BaseCallComp;



public class CallComp extends BaseCallComp implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		callCompNo;
	 * protected String 	callCompName;
	 * protected String 	callCompTelNo;
	 * protected String 	callCompRegion;
	 */
	
	// protected int 		추가되는 변수;
	
	public CallComp setCallCompNo(int callCompNo) {
		return (CallComp) super.setCallCompNo(callCompNo);
	}
	public CallComp setCallCompName(String callCompName) {
		return (CallComp) super.setCallCompName(callCompName);
	}
	public CallComp setCallCompTelNo(String callCompTelNo) {
		return (CallComp) super.setCallCompTelNo(callCompTelNo);
	}
	public CallComp setCallCompRegion(String callCompRegion) {
		return (CallComp) super.setCallCompRegion(callCompRegion);
	}
	
		
}
