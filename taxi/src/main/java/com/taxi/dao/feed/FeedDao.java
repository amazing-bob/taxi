package com.taxi.dao.feed;

import java.util.List;
import java.util.Map;

import com.taxi.vo.feed.Feed;


public interface FeedDao {

	List<Feed> getFeedList(int roomNo) throws Exception;

	int addFeed(Feed feed) throws Exception;
	
	Feed getFeedInfo(Feed feed) throws Exception;
	
	int deleteFeed(Map<String, Object> paramMap) throws Exception;

	/**
	 * 설  명: 해당 피드의 mbrNo를 변경 
	 * 작성자: 김상헌
	 */
	void changeMbrNoInFeed(Map<String, Object> paramMap);
	
	
}

