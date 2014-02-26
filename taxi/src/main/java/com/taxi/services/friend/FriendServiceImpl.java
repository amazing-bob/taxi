package com.taxi.services.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.friend.FrndDao;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;


@Service
public class FriendServiceImpl implements FriendService {
	@Autowired FrndDao FrndDao;
	
	/**
	 * 설  명 : 친구목록 등록
	 * 작성자 : 장종혁
	 */
	public void insertFrndList(List<Frnd> frndList)throws Exception{
		
		FrndDao.addFrndList(frndList);
		
	}
	
}
