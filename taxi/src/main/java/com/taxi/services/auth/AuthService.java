package com.taxi.services.auth;

import java.util.List;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


public interface AuthService {
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	MyInfo hasMember(Mbr mbr) throws Exception;
	
}
