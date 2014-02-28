package com.taxi.services.blacklist;

import java.util.List;

import com.taxi.vo.blacklist.Black;


public interface BlackListService {
	
	/**
	 * 설  명: 블랙리스트 조회 
	 * 작성자: 김상헌
	 */
	List<Black> getBlackList(int mbrNom, int blackMbrNo) throws Exception;
	
	/**
	 * 설  명: 블랙리스트 등록
	 * 작성자: 김상헌
	 */
	boolean registerBlacklist(Black black) throws Exception;

	
}
