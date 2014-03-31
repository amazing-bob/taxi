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
	 * 설  명: 방 멤버 가져오기
	 * 김상헌: 김상헌 
	 */
	RoomMbr getRoomMbrInfo(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 설  명: 방 멤버 삭제
	 * 작성자: 김상헌 
	 */
	int deleteRoomMbr(Map<String, Object> paramMap) throws Exception;
	
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
	 * 설  명: 해당회원이 방에 참여한것을 가정한 정보 
	 * 작성자: 김상헌 
	 */
	RoomMbr getVirtualRoomMbr(RoomMbr roomMbr) throws Exception;
	
	/**
	 * 설  명: 푸쉬 대상자 가져오기
	 * 작성자: 김상헌 
	 */
	List<Map<String, Object>> getGcmTargetMapList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 설  명: 푸쉬 출발 대상자 가져오기
	 * 작성자: 김상헌 
	 */
	List<RoomMbr> getAlramGcmTargetRoomMbrList(int roomNo) throws Exception;

	/**
	 * 설  명: 해당 방멤버의 mbrNo를 변경 
	 * 작성자: 김상헌
	 */
	void changeMbrNoInRoomMbr(Map<String, Object> paramMap) throws Exception;
	
}
