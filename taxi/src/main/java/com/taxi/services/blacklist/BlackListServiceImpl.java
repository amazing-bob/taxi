package com.taxi.services.blacklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.blacklist.BlackDao;
import com.taxi.vo.blacklist.Black;


@Service
public class BlackListServiceImpl implements BlackListService {
	@Autowired BlackDao blackDao;

	
	/**
	 * 설  명: 블랙리스트 조회 
	 * 작성자: 김상헌
	 */
	@Override
	public List<Black> getBlackList(int mbrNo) throws Exception {
		
		return blackDao.getBlackList(mbrNo);
	}
	
}
