package com.taxi.services.room;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


public interface RoomService {

	List<Room> searchRooms(int mbrNo, double startLat, double startLng, int startRange, double endLat, double endLng, int endRange) throws Exception;
	
	Room getRoomInfo(int roomNo) throws Exception;
	
/*	//====================== AS-IS =======================//
 
	int addRoom(Room room, RoomPath startPath, RoomPath endPath, RoomMbr roomMbr, FvrtLoc fvrtLoc) throws Exception;
	
	boolean isRoomMbr(String memberId) throws Exception;
	
	void joinRoom(RoomMbr roomMbr, FvrtLoc fvrtLoc) throws Exception; 
	
	Room getRoomInfo(int roomNo) throws Exception;

	Room getMyRoom(String mbrId) throws Exception;

	void outRoom(String mbrId, int roomNo) throws Exception;
	
	void removeRoom() throws Exception;
*/
	
}
