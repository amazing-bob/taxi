package com.taxi.dao.auth;

import com.taxi.vo.auth.Account;


public interface AccountDao {

	void deleteAccount(int mbrNo);

	/**
	 * 설   명: 계정 추가하기
	 * 작성자: 김상헌
	 */
	int insertAccount(Account account) throws Exception;
	
	/**
	 * 설   명: 사용중인 계정 정보 가져오기
	 * 작성자: 김상헌
	 */
	Account getUsedAccount(String accountEmail) throws Exception;
	
	/**
	 * 설  명: 나의 계정 정보 가져오기
	 * 작성자: 김상헌
	 */
	Account getMyAccount(int mbrNo) throws Exception;

	/**
	 * 설  명: 계정 로그인 확인
	 * 작성자: 김상헌
	 */
	Account loginAccount(Account account) throws Exception;

	/**
	 * 설  명: 비밀번호 변경
	 * 작성자: 김상헌 
	 */
	int changePassword(Account account) throws Exception;

	

	
}

