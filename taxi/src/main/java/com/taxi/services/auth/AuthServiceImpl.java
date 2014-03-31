package com.taxi.services.auth;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.auth.AccountDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.services.member.MemberService;
import com.taxi.services.room.RoomService;
import com.taxi.vo.auth.Account;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;
import com.taxi.vo.room.Room;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired MemberService 	memberService; 	
	@Autowired RoomService 		roomService;
	@Autowired AccountDao 		accountDao;
	@Autowired MbrDao 			mbrDao;
	
	
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@Override
	public MyInfo hasMember(Mbr mbr) throws Exception {
		MyInfo myInfo = mbrDao.getMyInfo(mbr);
		
		return myInfo;
	}

	
	/**
	 * 설   명: 추가 계정 만들기
	 * 작성자: 김상헌 
	 */
	@Override
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public void createAccount(Account account) throws Exception {
		Account usedAccount = accountDao.getUsedAccount( account.getAccountEmail() );
		Account myAccount = accountDao.getMyAccount( account.getMbrNo() );

		if ( myAccount != null) {
			throw new Exception("회원님은 이미 계정이 있습니다.");
		
		} else if ( usedAccount != null ) {
			throw new Exception("이미 사용중인 계정 입니다.");
			
		} else {
			accountDao.insertAccount(account);
			
		}
		
	}


	/**
	 * 설  명: 계정 로그인하고 MyInfo 리턴
	 * 작성자: 김상헌 
	 */
	@Override
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public MyInfo loginAccountReturnMyInfo(Account presentAccount) throws Exception {
		Account previousAccount = accountDao.loginAccount(presentAccount);
		
		if ( previousAccount != null ) {
			int presentMbrNo = presentAccount.getMbrNo();
			int previousMbrNo = previousAccount.getMbrNo();
			
			if ( presentMbrNo == previousMbrNo ) {
				throw new Exception("이미 계정이 연결되 있습니다.");
			}

			// 현재 회원 정보 가져오기
			MyInfo presentMyInfo = memberService.getMyInfo( presentMbrNo );
			
			
			// 참여하고 있던 방멤버와 피드의 mbrNo 기존 회원의  mbrNo로 변경
			Room room = roomService.getMyRoom( presentMbrNo );
			if ( room != null ) {
				roomService.changeMbrNoInRoomMbrFeed( 	/* roomNo */ room.getRoomNo(), 
														/* originMbrNo */ presentMbrNo, 
														/* changeMbrNo */ previousMbrNo );
			}
			
			// 현재 회원 정보 삭제하고
			memberService.leaveMember( presentMyInfo.getMbrNo() );
			
			// 기존 회원 정보에서 전화번호, UUID 업데이트 (이전의 데이터 동기화)
			memberService.updatePhoneNoUuid( /* previousMbrNo */ previousMbrNo, 
											/* presentPhoneNo */presentMyInfo.getMbrPhoneNo(), 
											/* presentUuid */ 	presentMyInfo.getMbrUuid() );
			
			// 변경된 MyInfo 조회 하고 리턴
			MyInfo changedMyInfo = memberService.getMyInfo(previousMbrNo);
			
			return changedMyInfo;
			
		} else {
			throw new Exception("계정 이메일 혹은 비밀번호가 맞지 않습니다.");
			
		}
		
	}


	/**
	 * 설  명: 계정 유효성 검사
	 * 작성자: 김상헌
	 */
	@Override
	public boolean validAccount(Account account) throws Exception {
		String accountEmail = account.getAccountEmail();
		
		boolean isVaildEmail = Pattern.matches("^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", accountEmail);
		if ( isVaildEmail ) {
			Account usedAccount = accountDao.getUsedAccount(accountEmail);
			
			if ( usedAccount == null ) {
				return true;
				
			} else {
				return false;
				
			}
			
		} else {
			return false;
			
		}
		
	}

}
