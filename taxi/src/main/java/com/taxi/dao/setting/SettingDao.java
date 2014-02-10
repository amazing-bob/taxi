package com.taxi.dao.setting;

import com.taxi.vo.auth.MyInfo;


public interface SettingDao {

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
