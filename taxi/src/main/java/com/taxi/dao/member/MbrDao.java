package com.taxi.dao.member;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;




public interface MbrDao {

	/**
	 * 설  명: myInfo 조회하기
	 * 작성자: 이용준 
	 */
	MyInfo getMyInfo(int mbrNo) throws Exception;
	
	/**
	 * 설  명: 회원추가
	 * 작성자: 이용준 
	 */
	int addMbr(Mbr mbr) throws Exception;
	
	void deleteMbr(int mbrNo);
	
	
/*	//====================== AS-IS =======================//
 	
	LoginInfo getLoginInfo(String mbrId) throws Exception;

	int signUp(Mbr mbr) throws Exception;

	int deleteMbr(String mbrId) throws Exception;
*/
	
}
