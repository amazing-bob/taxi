package com.taxi.vo.keyword;

import java.io.Serializable;
import java.util.List;

import com.taxi.vo.keyword.base.BaseKeyword;



public class Keyword extends BaseKeyword implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		keywordNo;
	 * protected String 	keywordName;
	 * protected String 	keywordSt;
	 */
	
	// protected int 		추가되는 변수;
	
	public Keyword setKeywordNo(int keywordNo) {
		return (Keyword) super.setKeywordNo(keywordNo);
	}
	public Keyword setKeywordName(String keywordName) {
		return (Keyword) super.setKeywordName(keywordName);
	}
	public Keyword setKeywordSt(String keywordSt) {
		return (Keyword) super.setKeywordSt(keywordSt);
	}
		
}
