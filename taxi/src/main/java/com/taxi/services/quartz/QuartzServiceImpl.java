package com.taxi.services.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class QuartzServiceImpl implements QuartzService {

	//////////////////////////  꼭 AS-IS를 보고 참고 해서 바꿔야만 한다
	@Override
	public void performService() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void roomCheckService() throws Exception {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////  꼭 AS-IS를 보고 참고 해서 바꿔야만 한다
	

	
/*	//====================== AS-IS =======================//
 
	@Autowired GcmService gcmService;
	@Autowired RoomService roomService;

	public QuartzServiceImpl(){}

	public void performService() throws Exception {
		gcmService.performService();
	}

	public void roomCheckService() throws Exception {
		roomService.removeRoom();
	}
*/
	
}
