package com.taxi.vo.blacklist;

import java.io.Serializable;
import java.util.Date;

import com.taxi.vo.blacklist.base.BaseBlack;



public class Black extends BaseBlack implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		blackNo;
	 * protected Date 		blackMbrRegDate;
	 */
	
	// protected int 		추가되는 변수;
	
	public Black setMbrNo(int mbrNo) {
		return (Black) super.setMbrNo(mbrNo);
	}
	public Black setBlackNo(int blackNo) {
		return (Black) super.setBlackNo(blackNo);
	}
	public Black setBlackMbrRegDate(Date blackMbrRegDate) {
		return (Black) super.setBlackMbrRegDate(blackMbrRegDate);
	}
	
		
}
