package com.taxi.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.auth.LoginDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.vo.auth.MyInfo;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired LoginDao loginDao;
	@Autowired MbrDao mbrDao;
	
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@Override
	public MyInfo hasMember(int mbrNo) throws Exception {
		MyInfo myInfo = mbrDao.getMyInfo(mbrNo);
		
		return myInfo;
	}
	
	
/*	//====================== AS-IS =======================//
 
	@Autowired MemberService memberService;

	public LoginInfo getLoginInfo(String mbrId) throws Exception {
		
		LoginInfo loginInfo = mbrDao.getLoginInfo(mbrId);
		return loginInfo;
	}
*/
	
}
