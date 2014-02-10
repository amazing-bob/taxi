package com.taxi.services.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.feed.FeedDao;
import com.taxi.dao.location.FvrtLocDao;
import com.taxi.dao.location.RcntLocDao;
import com.taxi.dao.room.RoomDao;
import com.taxi.dao.room.RoomMbrDao;
import com.taxi.dao.room.RoomPathDao;
import com.taxi.services.gcm.GcmService;
import com.taxi.services.gcm.GcmServiceImpl;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


@Service
public class RoomServiceImpl implements RoomService {
	@Autowired RoomDao 		roomDao;
	@Autowired RoomMbrDao 	roomMbrDao;
	@Autowired RoomPathDao 	roomPathDao;
	@Autowired RcntLocDao	rcntLocDao;

	
	/**
	 * 설  명: 방 정보 조회
	 * 작성자: 김상헌
	 */
	public Room getRoomInfo( int roomNo ) throws Exception {
		Room roomInfo = roomDao.getRoomInfo(roomNo);
		List<RoomMbr> roomMbrInfo = roomMbrDao.getRoomMbrDetailList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrCount( roomMbrInfo.size() );
		List<RoomPath> roomPathInfo = roomPathDao.getRoomPathList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrList(roomMbrInfo);
		roomInfo.setRoomPathList(roomPathInfo);
		
		return roomInfo;
		
	}
	
	/**
	 * 설  명: 방 목록 조회
	 * 작성자: 김상헌
	 */
	public List<Room> searchRooms( int mbrNo,
			double startLat	, double startLng	, int startRange,
			double endLat	, double endLng		, int endRange ) throws Exception {
		
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("mbrNo"		, mbrNo);
		paramMap.put("startLat"		, startLat);
		paramMap.put("startLng"		, startLng);
		paramMap.put("startRange"	, startRange);
		paramMap.put("endLat"		, endLat);
		paramMap.put("endLng"		, endLng);
		paramMap.put("endRange"		, endRange);

		List<Room> searchRoomList = roomDao.getRoomList(paramMap);
		
		return searchRoomList;
	}
	
	
	/**
	 * 설  명: 방에 참여 여부 조회
	 * 작성자: 김상헌
	 */
	public boolean isRoomMbr(int mbrNo) throws Exception {
		
		Room myRoom = roomDao.hasRooom(mbrNo);

		if ( myRoom == null || myRoom.getRoomNo() == 0 ) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * 설  명: 방 나가기 (수정)
	 * 작성자: 김상헌 (수정 : 장종혁)
	 * 방 나갈 때 방이 삭제 안되는 경우 수정
	 */
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class )
	public void outRoom(int mbrNo, int roomNo) throws Exception {
		try{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roomNo", roomNo);
			paramMap.put("mbrNo", mbrNo);
			//RoomMbr roomMbr = roomMbrDao.getRoomMbrInfo(paramMap);
			
//			int count = roomMbrDao.outRoom(paramMap);
//		수정 부분
			
		int roomCnt = roomMbrDao.roomMemberCount(roomNo);
		
		if(roomCnt==1){ //방에 인원이 1명이므로 나가면 방도 삭제되어야 함.
			//삭제순서 : Path -> ROOMMBR -> ROOM
			roomPathDao.deleteRoomPath(roomNo);
			
			roomMbrDao.deleteRoomMbr2(roomNo);
			
			roomDao.deleteRoom(roomNo);
			
		}else{// 방에 2명 이상이므로 1명이 나가도 방은 유지가 되므로 해당 유저만 삭제하면 됨.
			
			roomMbrDao.deleteRoomMbr(mbrNo);
			
		}
			
			
			
		
			// 푸쉬 처리 할 때 아래 주석 부분 처리 해야함....!!!!
			
//			if(count > 0){
//				paramMap.put("roomNo", roomMbr.getRoomNo());
//				paramMap.put("mbrId", roomMbr.getMbrId());
//				
//				List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
//				for (Map<String, String> map : gcmTargetMapList) {
//					map.put("roomAction", "outRoom" );
//					map.put("roomNo", roomMbr.getRoomNo()+"" );
//					map.put("mbrId", roomMbr.getMbrId() );
//					map.put("mbrName", roomMbr.getMbrName() );
//					map.put("mbrPhoneNo", roomMbr.getMbrPhoneNo() );
//					map.put("mbrPhotoUrl", roomMbr.getMbrPhotoUrl() );
//				}
//				
//				gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.RoomRunnable.class);
//				
//			}
			
		} catch(Exception e ) {
			throw e;
		}
	}
	
	
	/**
	 * 설  명: 방 만들기
	 * 작성자: 김상헌 
	 */
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class ) 
	public int addRoom(
			Room room			, RoomMbr roomMbr	,
			RoomPath startPath	, RoomPath endPath	, RcntLoc rcntLoc ) throws Exception {
        
        roomDao.addRoom(room); 
        int roomNo = room.getRoomNo(); 

        roomMbr.setRoomNo(roomNo);
        roomMbrDao.addRoomMbr( roomMbr );
        
        List<RoomPath> roomPathList = new ArrayList<RoomPath>();  
        roomPathList.add( startPath.setRoomNo(roomNo) );
        roomPathList.add( endPath.setRoomNo(roomNo) );
        roomPathDao.addRoomPathList( roomPathList ); 
        
        rcntLocDao.addRcntLoc( rcntLoc );

        
        return roomNo;
            
    } 
	
	
	/**
	 * 설  명: 방 참여하기
	 * 작성자: 김상헌 
	 */
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class ) 
	public void joinRoom( RoomMbr roomMbr, RcntLoc rcntLoc ) throws Exception { 
        
		try { 
        	roomMbr = roomMbrDao.getVirtualRoomMbr(roomMbr);
        	
        	int count =  roomMbrDao.addRoomMbr(roomMbr); 
        	
        	rcntLocDao.addRcntLoc( rcntLoc );
        	
        	// 아래의 주석 코드는 푸쉬 하게 되면 작업해야 하는 부분이다!!!
        	
//        	if(count > 0){
//        		Map <String, Object> paramMap = new HashMap<String, Object>();
//				paramMap.put("roomNo", roomMbr.getRoomNo());
//				paramMap.put("mbrId", roomMbr.getMbrId());
//				
//				List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
//				for (Map<String, String> map : gcmTargetMapList) {
//					map.put("roomAction", "joinRoom" );
//					map.put("roomNo", roomMbr.getRoomNo()+"" );
//					map.put("mbrId", roomMbr.getMbrId() );
//					map.put("mbrName", roomMbr.getMbrName() );
//					map.put("mbrPhoneNo", roomMbr.getMbrPhoneNo() );
//					map.put("mbrPhotoUrl", roomMbr.getMbrPhotoUrl() );
//				}
//				
//				gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.RoomRunnable.class);
//				
//			}
              
        } catch (Exception e) { 
            throw e; 
        }  
    }
	
	
	/**
	 * 설  명: 내방 가져오기
	 * 작성자: 김상헌 
	 */
	public Room getMyRoom(int mbrNo) throws Exception {
		return roomDao.getMyRoom(mbrNo);
	}
	
/*	//====================== AS-IS =======================//
 	
	@Autowired GcmService gcmService;
	@Autowired FvrtLocDao fvrtLocDao;  
	@Autowired FeedDao feedDao;
	@Autowired PlatformTransactionManager txManager;
	
	
	
	
	public Room getRoomInfo( int roomNo ) throws Exception {
		Room roomInfo = roomDao.getRoomInfo(roomNo);
		List<RoomMbr> roomMbrInfo = roomMbrDao.getRoomMbrDetailList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrCount( roomMbrInfo.size() );
		List<RoomPath> roomPathInfo = roomPathDao.getRoomPathList( roomInfo.getRoomNo() );
		
		roomInfo.setRoomMbrList(roomMbrInfo);
		roomInfo.setRoomPathList(roomPathInfo);
		
		return roomInfo;
		
	}


	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void outRoom(String mbrId, int roomNo) throws Exception {
		try{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roomNo", roomNo);
			paramMap.put("mbrId", mbrId);
			RoomMbr roomMbr = roomMbrDao.getRoomMbrInfo(paramMap);
			
			int count = roomMbrDao.outRoom(paramMap);
			
			if(count > 0){
				paramMap.put("roomNo", roomMbr.getRoomNo());
				paramMap.put("mbrId", roomMbr.getMbrId());
				
				List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
				for (Map<String, String> map : gcmTargetMapList) {
					map.put("roomAction", "outRoom" );
					map.put("roomNo", roomMbr.getRoomNo()+"" );
					map.put("mbrId", roomMbr.getMbrId() );
					map.put("mbrName", roomMbr.getMbrName() );
					map.put("mbrPhoneNo", roomMbr.getMbrPhoneNo() );
					map.put("mbrPhotoUrl", roomMbr.getMbrPhotoUrl() );
				}
				
				gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.RoomRunnable.class);
				
			}
			
		} catch(Exception e ) {
			throw e;
		}
	}
	
	
	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void removeRoom() throws Exception {
		System.out.println("Quartz Remove Rooms.........");
		
		List<Room> lastedRoomList = roomDao.getLastedRoomList();

		if(lastedRoomList.size() > 0){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("room", lastedRoomList);

			feedDao.deleteFeed(paramMap);
			roomMbrDao.outRoom(paramMap);
			roomPathDao.deleteRoomPath(paramMap);
			roomDao.deleteRoom(paramMap);
		}
	}
*/

}
