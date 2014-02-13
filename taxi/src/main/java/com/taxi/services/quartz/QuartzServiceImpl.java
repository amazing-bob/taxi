package com.taxi.services.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.services.gcm.GcmService;
import com.taxi.services.room.RoomService;


@Service
public  class QuartzServiceImpl implements QuartzService {
	@Autowired GcmService 	gcmService;
	@Autowired RoomService 	roomService;

	/**
	 * 설  명:쿼츠 아침 11시가 되면 시간이 지난 방 정리(AS-IS 사용)
	 * 작성자:장종혁
	 */
	public void roomCheckService() throws Exception {
		roomService.removeRoom();
	}
	
	/**
	 * 설  명: 방출발전 알람 쿼츠
	 * 작성자: 김상헌
	 */
	public void performService() throws Exception {
		gcmService.performService();
	}

	/*	//====================== AS-IS =======================//
 

	public QuartzServiceImpl(){}


*/
	
}
