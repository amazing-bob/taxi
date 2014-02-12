package com.taxi.services.location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<FvrtLoc> addFvrtLoc(FvrtLoc fvrtLoc) throws Exception {
		int rank = 0;
			
		rank = (int)fvrtLocDao.getFvrtLocRank(fvrtLoc.getMbrNo());
		
		fvrtLoc.setFvrtLocRank(rank);
		
		fvrtLocDao.addFvrtLoc(fvrtLoc);
		
		return fvrtLocDao.getFvrtLoc(fvrtLoc.getMbrNo());		
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
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void changeFavoritePlaces(int mbrNo , FvrtLoc fvrtLocList) throws Exception {
		fvrtLocList.setMbrNo(mbrNo);
		fvrtLocDao.updateFvrtLocRank(fvrtLocList);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public List<FvrtLoc> removeFavoritePlace(int fvrtLocNo , int mbrNo)throws Exception {
	
    	fvrtLocDao.deleteFvrtLocItem(fvrtLocNo);
    	
    	return fvrtLocDao.getFvrtLoc(mbrNo);
	}	
	
}
