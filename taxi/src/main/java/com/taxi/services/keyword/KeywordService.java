package com.taxi.services.keyword;

import java.util.List;

import com.taxi.vo.auth.MyInfo;


public interface KeywordService {
	
	/**
	 * 설 명: 키워드 목록 가져오기 
	 * 작성자:김태경
	 */
	List<MyInfo> getKeywordList()throws Exception;
	
}
