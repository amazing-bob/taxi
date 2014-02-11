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
	 * 설  명: 내방 가져오기
	 * 작성자: 김상헌 
	 */
	Room getMyRoom(int mbrNo) throws Exception ;
	
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
	
	
	/**
	 * 설  명: 방 삭제
	 * 작성자: 장종혁
	 */
	int deleteRoom(int roomNo)throws Exception;
	
	/**
	 * 설  명: 지난방 리스트 가져오기(AS-IS)
	 * 작성자: 장종혁
	 */
	List<Room> getLastedRoomList() throws Exception;
	
	
	/**
	 * 설  명: 지난방 삭제하기(AS-IS)(쿼츠)
	 * 작성자: 장종혁
	 */
	void deleteLastRoom(Map<String, Object> paramMap) throws Exception;
	
/*	//====================== AS-IS =======================//

	Room getRoomInfo(int roomNo) throws Exception ;

	List<Room> getAlramGcmTargetRoomList(String criteriaTime) throws Exception;
	

*/
	
}
