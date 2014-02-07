package com.taxi.services.setting;

import com.taxi.vo.auth.MyInfo;


public interface SettingService {

	MyInfo updateRange(MyInfo myInfo) throws Exception;
		
	
/*	//====================== AS-IS =======================//
 
	void addRange(Setting setting) throws Exception;
	
	void updateRange(Setting setting)throws Exception;

	List<FvrtLoc> getMyFvrtLoc(String mbrId)throws Exception;

	Setting getRange(String mbrId) throws Exception;
*/

}
