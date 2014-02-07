package com.taxi.services.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.setting.SettingDao;
import com.taxi.vo.auth.MyInfo;


@Service
public class SettingServiceImpl implements SettingService {
	
	@Autowired SettingDao settingDao;

	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public MyInfo updateRange(MyInfo myInfo) throws Exception {
		
		/*Map<String, Object> paramsMap = new HashMap<String, Object>();
    	paramsMap.put("mbrNo", myInfo.getMbrNo());
    	paramsMap.put("startRange", myInfo.getStartRange());
    	paramsMap.put("endRange", myInfo.getEndRange());*/
    	
    	
		settingDao.updateRange(myInfo);
		
		return settingDao.getRange(myInfo.getMbrNo());
	}
	
	
/*	//====================== AS-IS =======================//
 
	@Autowired FvrtLocDao fvrtLocDao;
	@Autowired SettingDao settingDao;
	
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void addRange(Setting setting) throws Exception {
		try{
			settingDao.addRange(setting);	
		}catch(Throwable e){
			throw e;
		}
	}

	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void updateRange(Setting setting) throws Exception {
		settingDao.updateRange(setting);
	}


	@Override
	public List<FvrtLoc> getMyFvrtLoc(String mbrId) throws Exception {
		Map<String, String> paramsMap = new HashMap<String, String>();
    	paramsMap.put("mbrId", mbrId);
    	paramsMap.put("fvrtLocStatus", "F");
    	
		return fvrtLocDao.getFvrtLoc(paramsMap);
	}
	@Override
	public Setting getRange(String mbrId) throws Exception {
		
		return settingDao.getRange(mbrId);
	}
*/
	
}
