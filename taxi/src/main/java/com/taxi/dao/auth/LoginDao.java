package com.taxi.dao.auth;

import java.util.List;

import com.taxi.vo.auth.MyInfo;





public interface LoginDao {

	void deleteLoginData(int mbrNo);

	List<MyInfo> getKeyWordList();

	/*List<MyInfo> serchKeyWordList(String serchKeyWord);*/

	

}

