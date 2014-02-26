package com.taxi.dao.keyword;

import java.util.Map;


public interface KeywordRelDao {

	void deleteKeywordRelData(int mbrNo);

	void setKeywordRelData(Map<String, Object> paramMap);

	

}

