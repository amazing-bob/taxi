package com.taxi.services.sharedlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.sharedlist.SharedDao;


@Service
public class SharedListServiceImpl implements SharedListService {
	@Autowired SharedDao sharedDao;
	
}
