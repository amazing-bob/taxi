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
	 * 설  명: 계정 로그인하고 mbrNo 리턴
	 * 작성자: 김상헌 
	 */
	int loginAccountReturnMyInfo(Account presentAccount) throws Exception;

	/**
	 * 설  명: 계정 유효성 검사
	 * 작성자: 김상헌
	 */
	boolean validAccount(Account account) throws Exception;

	/**
	 * 설  명: 비밀번호 찾기 위한 메일 보내기 
	 * 작성자: 김상헌 
	 */
	Account sendEmailForFindPassword(String accountEmail) throws Exception;
	
	/**
	 * 설  명: 임시 비밀번호 생성
	 * 작성자: 김상헌 
	 */
	String generateTempPassword(int length) throws Exception;
	/**
	 * 설  명: 계정비밀번호 변경 
	 * 작성자 : 김태경
	 */
	boolean updatePassword(Account account);
	
	
}
