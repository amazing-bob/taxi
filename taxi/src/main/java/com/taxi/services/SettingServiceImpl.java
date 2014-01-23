package com.taxi.services;

import org.springframework.stereotype.Service;


@Service
public class SettingServiceImpl implements SettingService {
	
	
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
