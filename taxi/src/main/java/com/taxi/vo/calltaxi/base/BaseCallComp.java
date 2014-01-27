package com.taxi.vo.calltaxi.base;

import java.io.Serializable;



public class BaseCallComp implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		callCompNo;
	protected String 	callCompName;
	protected String 	callCompTelNo;
	protected String 	callCompRegion;
	
	public int getCallCompNo() {
		return callCompNo;
	}
	public BaseCallComp setCallCompNo(int callCompNo) {
		this.callCompNo = callCompNo;
		return this;
	}
	public String getCallCompName() {
		return callCompName;
	}
	public BaseCallComp setCallCompName(String callCompName) {
		this.callCompName = callCompName;
		return this;
	}
	public String getCallCompTelNo() {
		return callCompTelNo;
	}
	public BaseCallComp setCallCompTelNo(String callCompTelNo) {
		this.callCompTelNo = callCompTelNo;
		return this;
	}
	public String getCallCompRegion() {
		return callCompRegion;
	}
	public BaseCallComp setCallCompRegion(String callCompRegion) {
		this.callCompRegion = callCompRegion;
		return this;
	}
	
		
}
