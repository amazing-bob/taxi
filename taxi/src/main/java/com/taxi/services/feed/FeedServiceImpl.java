package com.taxi.services.feed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.feed.FeedDao;
import com.taxi.dao.member.MbrDao;
import com.taxi.dao.room.RoomMbrDao;
import com.taxi.services.gcm.GcmService;
import com.taxi.services.gcm.GcmServiceImpl;
import com.taxi.vo.feed.Feed;


@Service
public class FeedServiceImpl implements FeedService {
	@Autowired FeedDao 		feedDao;
	@Autowired RoomMbrDao 	roomMbrDao;
	@Autowired MbrDao		mbrDao;
	@Autowired GcmService 	gcmService;
	
	/**
	 * 설  명: 피드 목록 가져오기
	 * 작성자: 김상헌
	 */
	public List<Feed> getFeedList(int roomNo) throws Exception {
		return feedDao.getFeedList(roomNo);
	}
	
	
	/**
	 * 설  명: 피드 등록하기 
	 * 작성자: 김상헌
	 * 수정내용 : (푸쉬 알림시  작성자 : 작성내용 의 형태로 발송하기 위함)
	 * 수정자 : 장종혁
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int addFeed(Feed feed) throws Exception {
		int feeNo = feedDao.addFeed(feed);
		
		feed.setMbrName(mbrDao.getUserName(feed.getMbrNo()));

		if(feeNo > 0){
			Map <String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roomNo", feed.getRoomNo());
			paramMap.put("mbrNo", feed.getMbrNo());
			
			// 푸쉬 보낼 준비하기
			List<Map<String, Object>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
			for (Map<String, Object> map : gcmTargetMapList) {
				map.put("feedAction"	, "addFeed" );
				map.put("roomNo"		, feed.getRoomNo() );
				map.put("mbrNo"			, feed.getMbrNo() );
				map.put("mbrName"		, feed.getMbrName());
				map.put("feedContent"	, feed.getFeedContent() );
			}
			
			gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.FeedRunnable.class);
		}
		return feeNo;
		
	}
	
	
	/**
	 * 설  명: 피드 삭제하기 (수정 : 피드 삭제 시 푸쉬 보낼 GCM ID를 안가져 오므로.. 수정함)
	 * 작성자: 김상헌
	 * 수정자: 장종혁
	 */
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int deleteFeed(Feed feed) throws Exception {
		
		feed.setMbrName(mbrDao.getUserName(feed.getMbrNo()));

		Feed deleteFeedData = feedDao.getFeedInfo(feed);
		feed.setRoomNo(deleteFeedData.getRoomNo());
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("feedNo", feed.getFeedNo());
		paramMap.put("mbrNo", feed.getMbrNo());
		paramMap.put("roomNo", feed.getRoomNo());
		
		int count = feedDao.deleteFeed(paramMap);
		
		if(count > 0){
			// 푸쉬 보낼 준비하기
			List<Map<String, Object>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
			for (Map<String, Object> map : gcmTargetMapList) {
				map.put("feedAction"	, "deleteFeed" );
				map.put("roomNo"		, feed.getRoomNo() );
				map.put("mbrNo"			, feed.getMbrNo() );
				map.put("mbrName"		, feed.getMbrName());
				map.put("feedContent"	, feed.getFeedContent() );
			}
			
			gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.FeedRunnable.class);
		}
		return count;
	}

/*	//====================== AS-IS =======================//
 	
	@Autowired GcmService gcmService;
	@Autowired RoomMbrDao roomMbrDao;
	@Autowired PlatformTransactionManager txManager;

	public List<Feed> getFeedList(int roomNo) throws Exception {
		return feedDao.getFeedList(roomNo);
	}

	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int addFeed(Feed feed) throws Exception {
		int feeNo = feedDao.addFeed(feed);

		if(feeNo > 0){
			Map <String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roomNo", feed.getRoomNo());
			paramMap.put("mbrId", feed.getMbrId());
			
			List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
			for (Map<String, String> map : gcmTargetMapList) {
				map.put("feedAction", "addFeed" );
				map.put("roomNo", feed.getRoomNo()+"" );
				map.put("mbrId", feed.getMbrId() );
				map.put("feedContent", feed.getFeedContent() );
			}
			
			gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.FeedRunnable.class);
		}
		return feeNo;
		
	}

	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void deleteFeed(Feed feed) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("feedNo", feed.getFeedNo());
		paramMap.put("mbrId", feed.getMbrId());
		
		feed = feedDao.getFeedInfo(feed);
		int count = feedDao.deleteFeed(paramMap);
		
		if(count > 0){
			paramMap.put("roomNo", feed.getRoomNo());
			paramMap.put("mbrId", feed.getMbrId());
			
			List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
			for (Map<String, String> map : gcmTargetMapList) {
				map.put("feedAction", "deleteFeed" );
				map.put("roomNo", feed.getRoomNo()+"" );
				map.put("mbrId", feed.getMbrId() );
				map.put("feedContent", feed.getFeedContent() );
			}
			
			gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.FeedRunnable.class);
		}
	}
*/
	
}
