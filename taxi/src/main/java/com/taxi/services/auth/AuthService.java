package com.taxi.services.auth;

import com.taxi.vo.auth.Account;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


public interface AuthService {
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	MyInfo hasMember(Mbr mbr) throws Exception;
	
	/**
	 * 설  명: 추가 계정 만들기
	 * 작성자: 김상헌 
	 */
	void createAccount(Account account) throws Exception;

	/**
	 * 설  명: 계정 로그인하고 MyInfo 리턴
	 * 작성자: 김상헌 
	 */
	MyInfo loginAccountReturnMyInfo(Account presentAccount) throws Exception;

	/**
	 * 설  명: 계정 유효성 검사
	 * 작성자: 김상헌
	 */
	boolean validAccount(Account account) throws Exception;
}
