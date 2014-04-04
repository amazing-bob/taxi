package com.taxi.services.room;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


public interface RoomService {

	/**
	 * 설  명: 방 목록 조회
	 * 작성자: 김상헌
	 * @param roomNoArr 
	 */
	List<Room> searchRooms(int mbrNo, int page, List<Integer> roomNoList, double startLat, double startLng, int startRange, double endLat, double endLng, int endRange) throws Exception;
	
	/**
	 * 설  명: 방 정보 조회
	 * 작성자: 김상헌
	 */
	Room getRoomInfo(int roomNo) throws Exception;
	
	/**
	 * 설  명: 내방 가져오기
	 * 작성자: 김상헌 
	 */
	Room getMyRoom(int mbrNo) throws Exception;
	
	/**
	 * 설  명: 방 만들기, 방번호 리턴
	 * 작성자: 김상헌 
	 */
	int addRoom(Room room, RoomMbr roomMbr, RoomPath startPath, RoomPath endPath, RcntLoc startRcntLoc , RcntLoc endRcntLoc) throws Exception;
	
	/**
	 * 설  명: 방 참여하기, 방번호 리턴
	 * 작성자: 김상헌 
	 */
	int joinRoom(RoomMbr roomMbr, RcntLoc startRcntLoc , RcntLoc endRcntLoc) throws Exception;
	
	/**
	 * 설  명: 방 나가기
	 * 작성자: 김상헌
	 */
	void outRoom(int mbrNo, int roomNo) throws Exception;
	
	/**
	 * 설  명: 지난 방 목록 가져오기
	 * 작성자: 김상헌
	 */
	List<Room> searchPastRoomList() throws Exception;
	
	/**
	 * 설  명: 지난 방 정리(AS-IS)
	 * 작성자: 장종혁
	 */
	void removeRoom(List<Room> pastRoomList) throws Exception;

	/**
	 * 설  명: 해당 방멤버와 피드에서 mbrNo를 변경
	 * 작성자: 김상헌
	 */
	void changeMbrNoInRoomMbrFeed(int roomNo, int originMbrNo, int changeMbrNo) throws Exception;
	
	
	
}
