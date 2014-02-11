package com.taxi.services.quartz;


public interface QuartzService {

	/**
	 * 설  명:쿼츠 아침 11시가 되면 시간이 지난 방 정리(AS-IS 사용)
	 * 작성자:장종혁
	 */
	abstract void roomCheckService() throws Exception;
	
/*	//====================== AS-IS =======================//
 
	abstract void performService() throws Exception;

*/
	
}
