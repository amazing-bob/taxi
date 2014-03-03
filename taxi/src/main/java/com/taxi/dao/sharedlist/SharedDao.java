package com.taxi.dao.sharedlist;

import java.util.Map;


public interface SharedDao {

	/**
	 * 설  명: 동승자 리스트 추가
	 * 작성자: 김상헌
	 */
	void insertSharedList(Map<String, Object> paramMap);
	
	
	void deleteSharedList(int mbrNo);


	

}

