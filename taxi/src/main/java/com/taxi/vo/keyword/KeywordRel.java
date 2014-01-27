package com.taxi.vo.keyword;

import java.io.Serializable;
import java.util.List;

import com.taxi.vo.keyword.base.BaseKeywordRel;



public class KeywordRel extends BaseKeywordRel implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		mbrNo;
	 * protected int 		KeywordRelNo;
	 */
	
	// protected int 		추가되는 변수;
	
	public KeywordRel setMbrNo(int mbrNo) {
		return (KeywordRel) super.setMbrNo(mbrNo);
	}
	public KeywordRel setKeywordRelNo(int KeywordRelNo) {
		return (KeywordRel) super.setKeywordNo(KeywordRelNo);
	}
	
}
