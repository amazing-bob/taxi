package com.taxi.services.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.location.FvrtLocDao;
import com.taxi.dao.location.RcntLocDao;


@Service
public class LocationServiceImpl implements LocationService {
	@Autowired FvrtLocDao fvrtLocDao;
	@Autowired RcntLocDao rcntLocDao;
	
}
