package com.taxi.services.shared;

import java.util.List;

import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.setting.Setting;


public interface SharedService {

	/**
	 * 설  명: 동승자 추가
	 * 작성자: 김상헌
	 */
	void registerSharedlist(List<Room> pastRoomList) throws Exception;

}
