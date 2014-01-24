package com.taxi.services.keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.keyword.KeywordDao;
import com.taxi.dao.keyword.KeywordRelDao;


@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired KeywordDao keywordDao;
	@Autowired KeywordRelDao keywordRelDao;
	
}
