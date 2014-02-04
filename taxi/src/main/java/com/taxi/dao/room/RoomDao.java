package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.Room;


public interface RoomDao {
	
	
/*	//====================== AS-IS =======================//

	List<Room> getRoomList(Map<String, Object> paramMap) throws Exception;

	int addRoom(Room room) throws Exception;

	Room getRoomInfo(int roomNo) throws Exception ;

	Room getMyRoom(String mbrId) throws Exception ;

	List<Room> getAlramGcmTargetRoomList(String criteriaTime) throws Exception;
	
	List<Room> getLastedRoomList() throws Exception;

	void deleteRoom(Map<String, Object> paramMap) throws Exception;
*/
	Room getRoomInfo(int roomNo) throws Exception ;
	
}
