package com.taxi.services.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.auth.AccountDao;
import com.taxi.dao.black.BlackDao;
import com.taxi.dao.feed.FeedDao;
import com.taxi.dao.friend.FrndDao;
import com.taxi.dao.keyword.KeywordRelDao;
import com.taxi.dao.location.FvrtLocDao;
import com.taxi.dao.location.RcntLocDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.dao.room.RoomMbrDao;
import com.taxi.dao.safe.SafeDao;
import com.taxi.dao.setting.SettingDao;
import com.taxi.dao.shared.SharedDao;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.member.Mbr;
import com.taxi.vo.setting.Setting;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MbrDao 		  mbrDao;
	@Autowired FrndDao 		  frndDao;  
    @Autowired FvrtLocDao 	  fvrtLocDao;  
    @Autowired FeedDao 		  feedDao; 
    @Autowired RoomMbrDao 	  roomMbrDao; 
    @Autowired SettingDao 	  settingDao; 
    @Autowired AccountDao     accountDao;
    @Autowired BlackDao       blackDao;
    @Autowired SharedDao      sharedDao;
    @Autowired KeywordRelDao  keywordRelDao;
    @Autowired SafeDao        safeDao;
    @Autowired RcntLocDao     rcntLocDao;
    
    @Autowired PlatformTransactionManager txManager; 

    
    /**
	 * 설  명: myInfo 가져오기
	 * 작성자: 김상헌
	 */
    @Override
	public MyInfo getMyInfo(int mbrNo) throws Exception {
    	Mbr mbr = new Mbr().setMbrNo(mbrNo);
    	
		return mbrDao.getMyInfo(mbr);
	}
    
    
    /**
	 * 설  명: 회원가입(mbrNo 리턴)
	 * 작성자: 이용준 
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int signUp( Mbr mbr, int keywordNo, List<Frnd> frndList ) throws Exception {
		
		mbrDao.addMbr(mbr);
		
		Setting setting = new Setting()
									.setMbrNo( mbr.getMbrNo() )
									.setStartRange( 500 )
									.setEndRange( 1000 );
		settingDao.addSetting(setting);
		
		if ( keywordNo > 0) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mbrNo"	, mbr.getMbrNo());
			paramMap.put("keywordNo", keywordNo);
			keywordRelDao.setKeywordRelData(paramMap);
		}
		
		if ( frndList != null && frndList.size() > 0) {
			// 넣기 전 frndList에  mbrNo 추가
			for(Frnd frnd : frndList){
				frnd.setMbrNo(mbr.getMbrNo());
			}
			
			frndDao.addFrndList(frndList);
		}
		
		
		return mbr.getMbrNo();
		
	}
    
    /**
     * 내용:회원탈퇴시. 모든 데이터 삭제
     * 작성자 : 김태경
     */
	@Override
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class ) 
	public void leaveMember(int mbrNo) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("feedNo", 0);
		paramMap.put("mbrNo", mbrNo);
		paramMap.put("room", null);
		
    	
		feedDao.deleteFeed(paramMap);
        roomMbrDao.deleteRoomMbr(paramMap); 
        frndDao.deleteFrnd(mbrNo);
        fvrtLocDao.deleteAllFvrtLoc(mbrNo); 
        settingDao.deleteSetting(mbrNo);
       
        
        accountDao.deleteAccount(mbrNo);
        blackDao.deleteBlackList(mbrNo);
        sharedDao.deleteSharedList(mbrNo);
        keywordRelDao.deleteKeywordRelData(mbrNo);
        safeDao.deleteSafeData(mbrNo);
        rcntLocDao.deleteRcntLocList(mbrNo);
        mbrDao.deleteMbr(mbrNo);
        
	}


	/**
	 * 설  명: 회원 정보 변경 (전화번호, UUID) 
	 * 작성자: 김상헌 
	 */
	@Override
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public void updatePhoneNoUuid(int previousMbrNo, String presentPhoneNo, String presentUuid) throws Exception {
		Mbr mbr = new Mbr().setMbrNo( previousMbrNo )
							.setMbrPhoneNo( presentPhoneNo )
							.setMbrUuid( presentUuid );
		mbrDao.updatePhoneNoUuid( mbr );
	}

	/**
	 * 설  명 : 회원 사진 주소 업데이트
	 * 작성자 : 장종혁
	 */
	@Override
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public int updateMbrPhotoUrl(Mbr mbr)throws Exception{
		return mbrDao.updateMbrPhotoUrl(mbr);
	}
	
	/**
	 *	설 명 : 회원 이름 업데이트 
	 * 	작성자 : 김태경
	 */
	@Override
	public String updateMbrName(String newName , int mbrNo) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("newName", newName);
		paramMap.put("mbrNo", mbrNo);
		mbrDao.profileNameUpdate(paramMap);
		
		return mbrDao.getUserName(mbrNo);
	};

	/**
	 *  설 명 : 회원 전화번호 업데이트
	 * 	작성자 : 김태경
	 */
	@Override
	public String updateMbrPhoneNo(String newPhoneNumber , int mbrNo) {
		
		
		int count = mbrDao.checkUserPhoneNumber(newPhoneNumber);
		String result;
		if(count == 0){
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("newPhoneNumber", newPhoneNumber);
			paramMap.put("mbrNo", mbrNo);
			mbrDao.profilePhoneNumberUpdate(paramMap);
			
			result = mbrDao.getUserPhoneNumber(mbrNo);
		}else{
			
			result = null;
		}
		
		
		return result;
	}
	
}
