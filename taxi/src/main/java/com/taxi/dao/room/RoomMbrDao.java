package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.RoomMbr;


public interface RoomMbrDao {

	/**
	 * 설  명: 방 회원 리스트 조회
	 * 작성자: 김상헌 
	 */
	List<RoomMbr> getRoomMbrDetailList(int roomNo) throws Exception;
	
	/**
	 * 설  명: 방 나가기
	 * 작성자: 김상헌 
	 */
	int outRoom(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 설  명: 방 멤버 삭제
	 * 작성자: 김상헌 
	 */
	void deleteRoomMbr(int mbrNo);
	
	/**
	 * 설  명: 방 멤버 추가
	 * 작성자: 김상헌 
	 */
	int addRoomMbr(RoomMbr roomDtl) throws Exception;
	
	/**
	 * 설  명: 방 맴버수 조회
	 * 작성자: 장종혁
	 */
	int roomMemberCount(int roomNo)throws Exception;
	
	/**
	 * 설  명: 방 멤버 삭제(방 삭제시)
	 * 작성자: 장종혁
	 */
	int deleteRoomMbr2(int roomNo)throws Exception;
	
/*	//====================== AS-IS =======================//
 

	int deleteRoomMbr(String mbrId) throws Exception;

	RoomMbr getRoomMbrInfo(Map<String, Object> paramMap) throws Exception;
	
	List<RoomMbr> getRoomMbrDetailList(int roomNo) throws Exception;

	RoomMbr getVirtualRoomMbr(RoomMbr roomMbr) throws Exception;

	int outRoom(Map<String, Object> paramMap) throws Exception;
	
	List<Map<String, String>> getGcmTargetMapList(Map<String, Object> paramMap) throws Exception;
	
	List<RoomMbr> getAlramGcmTargetRoomMbrList(int roomNo) throws Exception;
*/
}
