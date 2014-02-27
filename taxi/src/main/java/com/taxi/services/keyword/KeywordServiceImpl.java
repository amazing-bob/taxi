package com.taxi.services.keyword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.keyword.KeywordDao;
import com.taxi.dao.keyword.KeywordRelDao;
import com.taxi.vo.auth.MyInfo;


@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired KeywordDao 		keywordDao;
	@Autowired KeywordRelDao 	keywordRelDao;
	
	
	/**
	 * 설명: 전체 키워드 리스트 목록 가져오기
	 * 작성자:김태경
	 */
	@Override
	public List<MyInfo> getKeywordList() throws Exception {
		
		List<MyInfo> keyWordList = keywordDao.getKeywordList();
		return keyWordList;
		
	}
	
}
