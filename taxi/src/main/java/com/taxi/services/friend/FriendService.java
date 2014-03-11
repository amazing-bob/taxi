package com.taxi.services.friend;

import java.util.List;

import com.taxi.vo.friend.Frnd;


public interface FriendService {
	
	public void insertFrndList(List<Frnd> frndList)throws Exception;
	
	/**
	 * 설  명: 친구목록 가져오기
	 * 작성자: 김상헌
	 */
	public List<Frnd> getFrndList(int mbrNo)throws Exception;
	
	/**
	 * 설 명:친구목록 업데이트
	 * 작성자:김태경
	 */
	public List<Frnd> updateFrndList(List<Frnd> frndList , int mbrNo)throws Exception;

}
