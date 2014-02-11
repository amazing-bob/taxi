package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.Room;


public interface RoomDao {

	/**
	 *  설  명: 방 목록 조회
	 *  작성자: 김상헌
	 */
	List<Room> getRoomList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 설  명: 방 정보 조회
	 * 작성자: 김상헌
	 */
	Room getRoomInfo(int roomNo) throws Exception ;
	
	/**
	 *  설  명: 참여하고 있는 방 조회
	 *  작성자: 김상헌
	 */
	Room hasRoom(int mbrNo) throws Exception;
	
	/**
	 *  설  명: 방 추가
	 *  작성자: 김상헌
	 */
	int addRoom(Room room) throws Exception;
	
	
	/**
	 * 설  명: 방 삭제
	 * 작성자: 장종혁
	 */
	int deleteRoom(Map<String, Object> paramMap)throws Exception;
	
	
/*	//====================== AS-IS =======================//

	List<Room> getAlramGcmTargetRoomList(String criteriaTime) throws Exception;
	
	List<Room> getLastedRoomList() throws Exception;

	void deleteRoom(Map<String, Object> paramMap) throws Exception;
*/
	
}
