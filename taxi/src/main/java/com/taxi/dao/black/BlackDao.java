package com.taxi.dao.black;

import java.util.List;

import com.taxi.vo.black.Black;


public interface BlackDao {

	void deleteBlackList(int mbrNo) throws Exception;

	/**
	 * 설  명: 블랙리스트 조회
	 * 작상자: 김상헌 
	 */
	List<Black> getBlackList(Black black) throws Exception;

	/**
	 * 설  명: 블랙리스트 등록
	 * 작성자: 김상헌
	 */
	int insertBlack(Black black) throws Exception;


}

