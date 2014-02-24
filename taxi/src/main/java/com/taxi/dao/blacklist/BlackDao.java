package com.taxi.dao.blacklist;

import java.util.List;

import com.taxi.vo.blacklist.Black;


public interface BlackDao {

	void deleteBlackList(int mbrNo);

	/**
	 * 설  명: 블랙리스트 조회
	 * 작상자: 김상헌 
	 */
	List<Black> getBlackList(int mbrNo);

	

}

