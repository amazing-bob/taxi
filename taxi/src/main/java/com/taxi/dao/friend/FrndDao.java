package com.taxi.dao.friend;

import java.util.List;

import com.taxi.vo.friend.Frnd;


public interface FrndDao {

	void deleteFrnd(int mbrNo);

	void addFrndList(List<Frnd> list);
	
	Frnd serchFrnd(String frndPhoneNo);
	
	List<Frnd> getFrnd(int mbrNo);
	
/*	//====================== AS-IS =======================//
 
	
	int deleteFrnd(String mbrId) throws Exception;
*/
	
}
