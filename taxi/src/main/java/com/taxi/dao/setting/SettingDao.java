package com.taxi.dao.setting;

import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.setting.Setting;


public interface SettingDao {
	
	/**
	 * 설  명: 세팅 추가
	 * 작성자: 이용준 
	 */
	void addSetting(Setting setting) throws Exception;

	void deleteSetting(int mbrNo);

	void updateRange(MyInfo myInfo);

	MyInfo getRange(int mbrNo);
	
	
/*	//====================== AS-IS =======================//
 	
	void addSetting(Setting setting) throws Exception;
	
	void addRange(Setting setting) throws Exception;
	
	void updateRange(Setting setting) throws Exception;
	
	int deleteFvrtLoc(int fvrtLocNo) throws Exception;
	
	int deleteSetting(String mbrId) throws Exception;
	
	Setting getRange(String mbrId) throws Exception;
*/
	
}
