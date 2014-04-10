package com.taxi.dao.member;

import java.util.Map;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;




public interface MbrDao {

	/**
	 * 설  명: myInfo 조회하기( 'mbrNo'로 조회 또는 'mbrPhoneNo','mbrUuid'로 조회 )
	 * 작성자: 이용준 
	 */
	MyInfo getMyInfo(Mbr mbr) throws Exception;
	
	/**
	 * 설  명: 회원추가
	 * 작성자: 이용준 
	 */
	int addMbr(Mbr mbr) throws Exception;
	
	void deleteMbr(int mbrNo) throws Exception;

	/**
	 * 설  명: 회원 정보 변경 (전화번호, UUID) 
	 * 작성자: 김상헌 
	 */
	void updatePhoneNoUuid(Mbr mbr) throws Exception;
	
	/**
	 * 설  명: 회원 사진 주소 업데이트
	 * 작성자:  장종혁
	 */
	int updateMbrPhotoUrl(Mbr mbr)throws Exception;
	
	/**
	 *  설  명 : 회원 번호로 이름 가져오기
	 *  작성자 : 장종혁
	 */
	String getUserName(int mbrNo);
	
	/**
	 *	설 명 : 회원 이름 변경 (이름,회원번호)
	 * 	작성자 : 김태경
	 */
	void profileNameUpdate(Map<String, Object> paramMap);
	
	/**
	 * 	설명 : 회원 전화번호 변경(전화번호,회원전호)
	 * 	작성자 : 김태경
	 */
	void profilePhoneNumberUpdate(Map<String, Object> paramMap);
	
	
	/**
	 * 	설 명 : 회원 전화번호 가져오기 (회원번호 )
	 *  작성자 : 김태경
	 */
	String getUserPhoneNumber(int mbrNo);

	
	/**
	 * 	설 명 : 회원전화번호에 따른 회원 가져오기(전화번호)
	 *  작성자 : 김태경
	 */
	
	int checkUserPhoneNumber(String newPhoneNumber);

}
