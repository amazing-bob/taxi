package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.RoomMbr;


public interface RoomMbrDao {

	List<RoomMbr> getRoomMbrDetailList(int roomNo) throws Exception;
	
	List<Map<String, Object>> getGcmTargetMapList(Map<String, Object> paramMap) throws Exception;
	
	int outRoom(Map<String, Object> paramMap) throws Exception;
	
	void deleteRoomMbr(int mbrNo);
	
/*	//====================== AS-IS =======================//
 
	int addRoomMbr(RoomMbr roomDtl) throws Exception;

	int deleteRoomMbr(String mbrId) throws Exception;

	RoomMbr getRoomMbrInfo(Map<String, Object> paramMap) throws Exception;
	
	List<RoomMbr> getRoomMbrDetailList(int roomNo) throws Exception;

	RoomMbr getVirtualRoomMbr(RoomMbr roomMbr) throws Exception;

	int outRoom(Map<String, Object> paramMap) throws Exception;
	
	List<Map<String, String>> getGcmTargetMapList(Map<String, Object> paramMap) throws Exception;
	
	List<RoomMbr> getAlramGcmTargetRoomMbrList(int roomNo) throws Exception;
*/
}
