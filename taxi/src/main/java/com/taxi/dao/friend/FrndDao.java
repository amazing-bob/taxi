package com.taxi.dao.friend;

import java.util.List;

import com.taxi.vo.friend.Frnd;


public interface FrndDao {

	void deleteFrnd(int mbrNo);

	void addFrndList(List<Frnd> list);
	
	Frnd serchFrnd(String frndPhoneNo);
	
	/**
	 * 설  명: 친구 목록 가져오기
	 * 작성자: 김상헌
	 */
	List<Frnd> getFrndList(int mbrNo);



	
}
