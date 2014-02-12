package com.taxi.dao.location;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;




public interface FvrtLocDao {
	
	List<FvrtLoc> getFvrtLoc(int mbrNo)throws Exception;
	
	int getFvrtLocRank(int mbrNo)throws Exception;
	
	void addFvrtLoc(FvrtLoc fvrtLoc)throws Exception;
	
	void deleteAllFvrtLoc(int mbrNo)throws Exception;
	
	void deleteFvrtLoc(int fvrtLocNo)throws Exception;
	
	void updateFvrtLocRank(FvrtLoc fvrtLocList) throws Exception;
	
	void deleteFvrtLocItem(int fvrtLocNo) throws Exception;
	
/*	//====================== AS-IS =======================//
 	
    int addFvrtLoc(FvrtLoc fvrtLoc);
    
    int deleteFvrtLoc(String mbrId) throws Exception;

    int getFvrtLocRank(String mbrId) throws Exception;
    
    void updateFvrtLocRank(FvrtLoc fvrtLocList) throws Exception;

	void deleteFvrtLocItem(int fvrtLocNo) throws Exception;
	
	int deleteAllFvrtLoc(String mbrId) throws Exception;
*/	

}
