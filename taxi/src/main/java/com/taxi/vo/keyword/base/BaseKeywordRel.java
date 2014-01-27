package com.taxi.vo.keyword.base;

import java.io.Serializable;


public class BaseKeywordRel implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		mbrNo;
	protected int 		keywordNo;
	
	
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseKeywordRel setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public BaseKeywordRel setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
	
	
	
		
}
