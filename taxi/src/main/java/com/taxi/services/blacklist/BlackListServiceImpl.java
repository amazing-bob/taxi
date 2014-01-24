package com.taxi.services.blacklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.blacklist.BlackDao;


@Service
public class BlackListServiceImpl implements BlackListService {
	@Autowired BlackDao blackDao;
	
}
