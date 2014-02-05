package com.taxi.services.feed;

import java.util.List;

import com.taxi.vo.feed.Feed;


public interface FeedService {

	List<Feed> getFeedList(int roomNo) throws Exception;
	
	int addFeed(Feed feed) throws Exception;
	
	void deleteFeed(Feed feed) throws Exception;
	
/*	//====================== AS-IS =======================//
 	
	List<Feed> getFeedList(int roomNo) throws Exception;

	int addFeed(Feed feed) throws Exception;

	void deleteFeed(Feed feed) throws Exception;
*/
	
}
