package com.taxi.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.auth.AccountDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired AccountDao 	accountDao;
	@Autowired MbrDao 		mbrDao;
	
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@Override
	public MyInfo hasMember(Mbr mbr) throws Exception {
		MyInfo myInfo = mbrDao.getMyInfo(mbr);
		
		return myInfo;
	}


}
