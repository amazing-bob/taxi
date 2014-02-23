package com.taxi.services.auth;

import java.util.List;

import com.taxi.vo.auth.MyInfo;


public interface AuthService {
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	MyInfo hasMember(int mbrNo) throws Exception;
	
	/**
	 * 설 명: 키워드 목록 가져오기 
	 * 작성자:김태경
	 */
	List<MyInfo> getKeyWordlist()throws Exception;
/*	//====================== AS-IS =======================//
 	
	LoginInfo getLoginInfo(String mbrId) throws Exception ;;
*/

	/*List<MyInfo> serchKeyWordList(String serchKeyWord);*/
	
}
