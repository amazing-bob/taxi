package com.taxi.services.location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.location.FvrtLocDao;
import com.taxi.dao.location.RcntLocDao;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;


@Service
public class LocationServiceImpl implements LocationService {
	@Autowired FvrtLocDao fvrtLocDao;
	@Autowired RcntLocDao rcntLocDao;
	
	public List<FvrtLoc> getFavoriteList(int mbrNo) throws Exception {
		return fvrtLocDao.getFvrtLoc(mbrNo);
	}
	
	public void addFvrtLoc(FvrtLoc fvrtLoc) throws Exception {
		int rank = 0;
		
		rank = fvrtLocDao.getFvrtLocRank(fvrtLoc.getMbrNo());
		
		fvrtLoc.setFvrtLocRank(rank);
		
		fvrtLocDao.addFvrtLoc(fvrtLoc);
	}

	public void deleteAllFvrtLoc(int mbrNo) throws Exception {
		fvrtLocDao.deleteAllFvrtLoc(mbrNo);
	}

	public void deleteFvrtLoc(int fvrtLocNo) throws Exception {
		fvrtLocDao.deleteFvrtLoc(fvrtLocNo);
	}
	
	/**
	 * 설  명: 최근 목적지 가져오기
     * 작성자: 김상헌 
	 */
	public List<RcntLoc> getRecentDestination(int mbrNo) throws Exception {
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
    	paramsMap.put("mbrNo", mbrNo);
    	
    	return rcntLocDao.getRecentDestination(paramsMap); 
    } 
	
}
