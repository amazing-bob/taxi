package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.Room;


public interface RoomDao {

	/**
	 *  설  명: 참여하고 있는 방 조회
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
	Room hasRooom(int mbrNo) throws Exception;
	
	/**
	 *  설  명: 방 추가
	 *  작성자: 김상헌
	 */
	int addRoom(Room room) throws Exception;
	
/*	//====================== AS-IS =======================//

	Room getRoomInfo(int roomNo) throws Exception ;

	Room getMyRoom(String mbrId) throws Exception ;

	List<Room> getAlramGcmTargetRoomList(String criteriaTime) throws Exception;
	
	List<Room> getLastedRoomList() throws Exception;

	void deleteRoom(Map<String, Object> paramMap) throws Exception;
*/
	
}
