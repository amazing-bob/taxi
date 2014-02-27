package com.taxi.services.member;

import java.util.List;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.location.FvrtLoc;
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

	
/*	//====================== AS-IS =======================//
 
	void signUp(Mbr mbr) throws Exception ;
	  
    void addFavoritePlace(FvrtLoc fvrtLoc) throws Exception;
    
    List<FvrtLoc> getFavoritePlaces(String mbrId) throws Exception;
    
    void changeFavoritePlaces(FvrtLoc fvrtLocList) throws Exception;	
    
    void removeFavoritePlace(int fvrtLocNo) throws Exception;
	
    void leaveMember(String mbrId) throws Exception;

	void frndRefresh(Mbr mbr) throws Exception ;
*/
	
}
