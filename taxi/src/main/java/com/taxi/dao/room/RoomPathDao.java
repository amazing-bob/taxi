package com.taxi.dao.room;

import java.util.List;
import java.util.Map;

import com.taxi.vo.room.RoomPath;


public interface RoomPathDao {

	/**
	 * 설  명: 방의 출발지&목적지 조회
	 * 작성자: 김상헌
	 */
	List<RoomPath> getRoomPathList(int roomNo) throws Exception;
	
	/**
	 * 설  명: 출발지 & 목적지 추가
	 * 작성자: 김상헌
	 */
	void addRoomPathList(List<RoomPath> roomPathList) throws Exception;
	
	/**
	 * 설  명: 출발지&목적지 삭제
	 * 작성자: 장종혁
	 */
	void deleteRoomPath(int roomNo)throws Exception;
	
	/**
	 *설  명:시간이 지난 방의 출발지 & 목적지 삭제(쿼츠) - AS-IS
	 *작성자:장종혁
	 */
	void deleteLastRoomPath(Map<String, Object> paramMap) throws Exception;

	/*	//====================== AS-IS =======================//
 	

*/
	
}
