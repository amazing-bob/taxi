package com.taxi.services.quartz;


public interface QuartzService {


	/**
	 * 설  명:쿼츠 아침 11시가 되면 시간이 지난 방 정리(AS-IS 사용)
	 * 작성자:장종혁
	 */
	void roomCheckService() throws Exception;
	
	/**
	 * 설  명: 방출발전 알람 쿼츠
	 * 작성자: 김상헌
	 */
	void performService() throws Exception;
	
}
