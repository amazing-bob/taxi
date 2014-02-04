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
import com.taxi.dao.room.RoomDao;
import com.taxi.dao.room.RoomMbrDao;
import com.taxi.dao.room.RoomPathDao;
import com.taxi.services.gcm.GcmService;
import com.taxi.services.gcm.GcmServiceImpl;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


@Service
public class RoomServiceImpl implements RoomService {
	@Autowired RoomDao roomDao;
	@Autowired RoomMbrDao roomMbrDao;
	@Autowired RoomPathDao roomPathDao;
	
	public Room getRoomInfo( int roomNo ) throws Exception {
		Room roomInfo = roomDao.getRoomInfo(roomNo);
		List<RoomMbr> roomMbrInfo = roomMbrDao.getRoomMbrDetailList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrCount( roomMbrInfo.size() );
		List<RoomPath> roomPathInfo = roomPathDao.getRoomPathList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrList(roomMbrInfo);
		roomInfo.setRoomPathList(roomPathInfo);
		
		return roomInfo;
		
	}
	
	
	public List<Room> searchRooms( int mbrNo,
			double startLat	, double startLng	, int startRange,
			double endLat	, double endLng		, int endRange ) throws Exception {
		
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("mbrNo", mbrNo);
		paramMap.put("startLat", startLat);
		paramMap.put("startLng", startLng);
		paramMap.put("startRange", startRange);
		paramMap.put("endLat", endLat);
		paramMap.put("endLng", endLng);
		paramMap.put("endRange", endRange);

		List<Room> searchRoomList = roomDao.getRoomList(paramMap);
		
		return searchRoomList;
	}
	
/*	//====================== AS-IS =======================//
 	
	@Autowired GcmService gcmService;
	@Autowired FvrtLocDao fvrtLocDao;  
	@Autowired FeedDao feedDao;
	@Autowired PlatformTransactionManager txManager;
	

	
	
	public boolean isRoomMbr(String memberId) throws Exception {
		try {
			int count = roomMbrDao.isRoomMbr(memberId);

			if (count > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class ) 
	public int addRoom(
			Room room, 
			RoomPath startPath, 
			RoomPath endPath, 
			RoomMbr roomMbr,
			FvrtLoc fvrtLoc ) throws Exception {
        try { 
            roomDao.addRoom(room); 
            int roomNo = room.getRoomNo(); 
            
            List<RoomPath> roomPathList = new ArrayList<RoomPath>();  
            roomPathList.add( startPath.setRoomNo(roomNo) );
            roomPathList.add( endPath.setRoomNo(roomNo) );
            roomPathDao.addRoomPathList( roomPathList ); 
            
            roomMbr.setRoomNo(roomNo);
            roomMbrDao.addRoomMbr( roomMbr );
            
            fvrtLocDao.addFvrtLoc( fvrtLoc );
            
            
              
            return roomNo;
            
        } catch (Exception e) { 
            throw e; 
        } 
    } 
	
	
	@Transactional( propagation=Propagation.REQUIRED, rollbackFor=Throwable.class ) 
	public void joinRoom(RoomMbr roomMbr, FvrtLoc fvrtLoc) throws Exception { 
        try { 
        	roomMbr = roomMbrDao.getVirtualRoomMbr(roomMbr);
        	int count =  roomMbrDao.addRoomMbr(roomMbr); 
        	
        	fvrtLocDao.addFvrtLoc( fvrtLoc );
        	
        	if(count > 0){
        		Map <String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("roomNo", roomMbr.getRoomNo());
				paramMap.put("mbrId", roomMbr.getMbrId());
				
				List<Map<String, String>> gcmTargetMapList =  roomMbrDao.getGcmTargetMapList(paramMap);
				for (Map<String, String> map : gcmTargetMapList) {
					map.put("roomAction", "joinRoom" );
					map.put("roomNo", roomMbr.getRoomNo()+"" );
					map.put("mbrId", roomMbr.getMbrId() );
					map.put("mbrName", roomMbr.getMbrName() );
					map.put("mbrPhoneNo", roomMbr.getMbrPhoneNo() );
					map.put("mbrPhotoUrl", roomMbr.getMbrPhotoUrl() );
				}
				
				gcmService.asyncSend(gcmTargetMapList, GcmServiceImpl.RoomRunnable.class);
				
			}
              
        } catch (Exception e) { 
            throw e; 
        }  
    }
	
	
	public Room getRoomInfo( int roomNo ) throws Exception {
		Room roomInfo = roomDao.getRoomInfo(roomNo);
		List<RoomMbr> roomMbrInfo = roomMbrDao.getRoomMbrDetailList( roomInfo.getRoomNo() );
		roomInfo.setRoomMbrCount( roomMbrInfo.size() );
		List<RoomPath> roomPathInfo = roomPathDao.getRoomPathList( roomInfo.getRoomNo() );
		
		roomInfo.setRoomMbrList(roomMbrInfo);
		roomInfo.setRoomPathList(roomPathInfo);
		
		return roomInfo;
		
	}


	public Room getMyRoom(String mbrId) throws Exception {
		return roomDao.getMyRoom(mbrId);
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
