package com.taxi.services.member;

import java.util.List;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;


public interface MemberService {
	
	/**
	 * 설  명: myInfo 가져오기
	 * 작성자: 김상헌
	 */
	MyInfo getMyInfo( int mbrNo ) throws Exception; 
	
	/**
	 * 설  명: 회원가입(mbrNo 리턴)
	 * 작성자: 이용준 
	 */
	int signUp(Mbr mbr, int keywordNo, List<Frnd> frndList) throws Exception ;

	void leaveMember(int mbrNo)throws Exception;

	/**
	 * 설  명: 회원 정보 변경 (전화번호, UUID) 
	 * 작성자: 김상헌 
	 */
	void updatePhoneNoUuid(int previousMbrNo, String presentPhoneNo, String presentUuid) throws Exception;
	
	/**
	 * 설  명 : 회원 사진 주소 업데이트
	 * 작성자 : 장종혁
	 */
	int updateMbrPhotoUrl(Mbr mbr)throws Exception;
	
}
