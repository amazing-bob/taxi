package com.taxi.vo.keyword.base;

import java.io.Serializable;


public class BaseKeyword implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		keywordNo;
	protected String 	keywordName;
	protected String 	keywordSt;
	
	
	public int getKeywordNo() {
		return keywordNo;
	}
	public BaseKeyword setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
	public String getKeywordName() {
		return keywordName;
	}
	public BaseKeyword setKeywordName(String keywordName) {
		this.keywordName = keywordName;
		return this;
	}
	public String getKeywordSt() {
		return keywordSt;
	}
	public BaseKeyword setKeywordSt(String keywordSt) {
		this.keywordSt = keywordSt;
		return this;
	}
	
		
}
