package com.taxi.services.room;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


public interface RoomService {

	/**
	 * 설  명: 방 목록 조회
	 * 작성자: 김상헌
	 */
	List<Room> searchRooms(int mbrNo, double startLat, double startLng, int startRange, double endLat, double endLng, int endRange) throws Exception;
	
	/**
	 * 설  명:  
	 * 작성자: 
	 */
	Room getRoomInfo(int roomNo) throws Exception;
	
	/**
	 * 설  명: 방에 참여 여부 조회
	 * 작성자: 김상헌
	 */
	boolean isRoomMbr(int mbrNo) throws Exception;
	
/*	//====================== AS-IS =======================//
 
	int addRoom(Room room, RoomPath startPath, RoomPath endPath, RoomMbr roomMbr, FvrtLoc fvrtLoc) throws Exception;
	
	void joinRoom(RoomMbr roomMbr, FvrtLoc fvrtLoc) throws Exception; 
	
	Room getRoomInfo(int roomNo) throws Exception;

	Room getMyRoom(String mbrId) throws Exception;

	void outRoom(String mbrId, int roomNo) throws Exception;
	
	void removeRoom() throws Exception;
*/
	
}
