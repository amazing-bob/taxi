package com.taxi.services.black;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.black.BlackDao;
import com.taxi.vo.black.Black;


@Service
public class BlackServiceImpl implements BlackService {
	@Autowired BlackDao blackDao;

	
	/**
	 * 설  명: 블랙리스트 조회 
	 * 작성자: 김상헌
	 */
	@Override
	public List<Black> getBlackList( int mbrNo, int blackMbrNo ) throws Exception {
		Black black = new Black()
							.setMbrNo(mbrNo)
							.setBlackMbrNo(blackMbrNo);
							
		
		return blackDao.getBlackList(black);
	}
	
	
	/**
	 * 설  명: 블랙리스트 등록
	 * 작성자: 김상헌
	 */
	@Override
	public boolean registerBlacklist(Black black) throws Exception {
		int count = blackDao.insertBlack(black);
		
		if ( count > 0 )
			return true;
		else 
			return false;
	}

	
}
