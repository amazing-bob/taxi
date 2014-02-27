package com.taxi.services.friend;

import java.util.List;

import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;


public interface FriendService {
	
	public void insertFrndList(List<Frnd> frndList)throws Exception;
	
	/**
	 * 설  명: 친구목록 가져오기
	 * 작성자: 김상헌
	 */
	public List<Frnd> getFrndList(int mbrNo)throws Exception;

}
