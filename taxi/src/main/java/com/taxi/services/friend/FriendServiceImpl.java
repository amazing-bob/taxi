package com.taxi.services.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.friend.FrndDao;
import com.taxi.vo.friend.Frnd;


@Service
public class FriendServiceImpl implements FriendService {
	@Autowired FrndDao frndDao;
	
	/**
	 * 설  명 : 친구목록 등록
	 * 작성자 : 장종혁
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void insertFrndList(List<Frnd> frndList)throws Exception{
		
		frndDao.addFrndList(frndList);
		
	}

	
	/**
	 * 설  명: 친구목록 가져오기
	 * 작성자: 김상헌
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Frnd> getFrndList(int mbrNo) throws Exception {
		return frndDao.getFrndList(mbrNo);
	}
	/**
	 * 설 명: 친구목록 업데이트
	 * 작성자: 김태경
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Frnd> updateFrndList(List<Frnd> frndList , int mbrNo) throws Exception{
		
		frndDao.deleteFrnd(mbrNo);
		frndDao.addFrndList(frndList);
		return frndDao.getFrndList(mbrNo);
	}
}
