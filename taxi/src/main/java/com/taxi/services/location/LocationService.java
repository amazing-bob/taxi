package com.taxi.services.location;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;


public interface LocationService {
	
	public Object getRecentDestination(int mbrNo) throws Exception;
	
	List<FvrtLoc> getFavoriteList(int mbrNo) throws Exception;
	
	void addFvrtLoc(FvrtLoc fvrtLoc)throws Exception;
	
	void deleteAllFvrtLoc(int mbrNo)throws Exception;
	
	void deleteFvrtLoc(int fvrtLocNo)throws Exception;
	
	
}
