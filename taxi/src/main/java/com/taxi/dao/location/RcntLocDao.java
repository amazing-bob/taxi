package com.taxi.dao.location;

import java.util.List;
import java.util.Map;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;


public interface RcntLocDao {

	/**
	 * 설  명: 최근 목적지 가져오기
     * 작성자: 김상헌 
	 */
	List<RcntLoc> getRecentDestination(Map<String, Object> paramsMap) throws Exception;

	void deleteRcntLocList(int mbrNo);
	
	/**
	 * 설  명: 최근목적지 추가
	 * 작성자: 김상헌
	 */
	int addRcntLoc(RcntLoc rcntLoc);
	
	/**
	 * 설  명 : 최근목적지 중복 검사
	 * 작성자 : 장종혁
	 */
	int cntRcntLoc(RcntLoc rcntLoc);
	
	/**
	* 설  명 : 최근 목적지 중복 데이터 업데이트
	* 작성자 : 장종혁
	 */
	int updateRcntLoc(RcntLoc rcntLoc);
	
/*	//====================== AS-IS =======================//
 	
    
    int deleteFvrtLoc(String mbrId) throws Exception;

    int getFvrtLocRank(String mbrId) throws Exception;
    
    void updateFvrtLocRank(FvrtLoc fvrtLocList) throws Exception;

	void deleteFvrtLocItem(int fvrtLocNo) throws Exception;
	
	int deleteAllFvrtLoc(String mbrId) throws Exception;
*/	

}
