package com.taxi.services.location;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.location.FvrtLocDao;
import com.taxi.dao.location.RcntLocDao;


@Service
public class LocationServiceImpl implements LocationService {
	@Autowired FvrtLocDao fvrtLocDao;
	@Autowired RcntLocDao rcntLocDao;
	
	
	public Object getRecentDestination(int mbrNo) throws Exception {
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
    	paramsMap.put("mbrNo", mbrNo);
    	return rcntLocDao.getRecentDestination(paramsMap); 
    } 
	
}
