package com.taxi.services.auth;

import com.taxi.vo.auth.MyInfo;


public interface AuthService {
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	MyInfo hasMember(int mbrNo) throws Exception;
	
/*	//====================== AS-IS =======================//
 	
	LoginInfo getLoginInfo(String mbrId) throws Exception ;;
*/
	
}
