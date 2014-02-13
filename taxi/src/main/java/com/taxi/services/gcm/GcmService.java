package com.taxi.services.gcm;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface GcmService {
	/**
	 * 설  명: 방 출발전 알람 푸시
	 * 작성자: 김상헌
	 */
	void performService() throws Exception;

	/**
	 * 설  명: google 푸시 서버로 전송할 값 설정 부분
	 * 작성자: 김상헌  
	 */
	void asyncSend(List<Map<String, Object>> gcmTargetMapList, Class<?> clazz) throws IOException, EOFException;
/*	//====================== AS-IS =======================//
 	

    void asyncSend(List<Map<String, String>> gcmTargetMapList, Class<?> clazz) throws IOException, EOFException;
*/
	
}