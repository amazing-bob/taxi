package com.taxi.services.location;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;


public interface LocationService {
	
	/**
	 * 설  명: 최근 목적지 가져오기
     * 작성자: 김상헌 
	 */
	public List<RcntLoc> getRecentDestination(int mbrNo) throws Exception;
	
	List<FvrtLoc> getFavoriteList(int mbrNo) throws Exception;
	
	void addFvrtLoc(FvrtLoc fvrtLoc)throws Exception;
	
	void deleteAllFvrtLoc(int mbrNo)throws Exception;
	
	void deleteFvrtLoc(int fvrtLocNo)throws Exception;
	
	
}
