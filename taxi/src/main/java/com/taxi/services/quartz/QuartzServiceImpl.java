package com.taxi.services.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.services.gcm.GcmService;
import com.taxi.services.room.RoomService;
import com.taxi.services.shared.SharedService;
import com.taxi.vo.room.Room;


@Service
public  class QuartzServiceImpl implements QuartzService {
	@Autowired GcmService 		gcmService;
	@Autowired RoomService 		roomService;
	@Autowired SharedService 	sharedService;

	/**
	 * 설  명:쿼츠 아침 11시가 되면 시간이 지난 방 정리(AS-IS 사용)
	 * 작성자:장종혁
	 */
	public void roomCheckService() throws Exception {
		List<Room> pastRoomList = roomService.searchPastRoomList();
		
		sharedService.registerSharedlist(pastRoomList);
		roomService.removeRoom(pastRoomList);
	}
	
	/**
	 * 설  명: 방출발전 알람 쿼츠
	 * 작성자: 김상헌
	 */
	public void performService() throws Exception {
		gcmService.performService();
	}

}
