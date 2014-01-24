package com.taxi.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.auth.LoginDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.services.member.MemberService;
import com.taxi.vo.auth.LoginInfo;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired LoginDao loginDao;
	@Autowired MbrDao mbrDao;
	
/*	//====================== AS-IS =======================//
 
	@Autowired MemberService memberService;

	public LoginInfo getLoginInfo(String mbrId) throws Exception {
		
		LoginInfo loginInfo = mbrDao.getLoginInfo(mbrId);
		return loginInfo;
	}
*/
	
}
