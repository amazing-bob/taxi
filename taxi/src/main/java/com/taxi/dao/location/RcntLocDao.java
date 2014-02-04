package com.taxi.dao.location;

import java.util.List;
import java.util.Map;

import com.taxi.vo.location.FvrtLoc;


public interface RcntLocDao {

	List<FvrtLoc> getRecentDestination(Map<String, Object> paramsMap) throws Exception;
	
/*	//====================== AS-IS =======================//
 	
    int addFvrtLoc(FvrtLoc fvrtLoc);
    
    int deleteFvrtLoc(String mbrId) throws Exception;

    int getFvrtLocRank(String mbrId) throws Exception;
    
    void updateFvrtLocRank(FvrtLoc fvrtLocList) throws Exception;

	void deleteFvrtLocItem(int fvrtLocNo) throws Exception;
	
	int deleteAllFvrtLoc(String mbrId) throws Exception;
*/	

}
