package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.location.LocationService;
import com.taxi.services.room.RoomService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.LoginInfo;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.LocationSession;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.room.Room;
import com.taxi.vo.room.RoomMbr;
import com.taxi.vo.room.RoomPath;


@Controller
@RequestMapping("/room")
public class RoomControl {
	@Autowired ServletContext 	sc;
	@Autowired RoomService 		roomService;	
	@Autowired LocationService 	locationService;
	
	
	/**
	 * 설  명: 방 정보 조회
	 * 작성자: 김상헌
	 */
    @RequestMapping("/getRoomInfo")
    @ResponseBody
    public Object getRoomInfo( int roomNo ) throws Exception {
        JsonResult jsonResult = new JsonResult();

        try {

        	jsonResult.setData( roomService.getRoomInfo(roomNo) );
            jsonResult.setStatus("success");

        } catch (Throwable e) {
        	e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));

            jsonResult.setStatus("fail");
            jsonResult.setData(out.toString());
        }

        return jsonResult;
    }

    
	/**
	 * 설  명: 방 목록 조회
	 * 작성자: 김상헌 
	 */
	@RequestMapping("/searchRooms")
	@ResponseBody
	public JsonResult searchRooms( int mbrNo,
			String startLat	, String startLng	, int startRange,
			String endLat	, String endLng		, int endRange ) throws Exception {
		
		JsonResult jsonResult = new JsonResult();
		
		try {
			List<Room> roomList = roomService.searchRooms( 
													mbrNo,
													Double.parseDouble(startLat),
													Double.parseDouble(startLng),
													startRange,
													Double.parseDouble(endLat),
													Double.parseDouble(endLng),
													endRange );
			
			jsonResult.setData( roomList );
			jsonResult.setStatus("success");

		} catch (Throwable e) {
			e.printStackTrace();
			StringWriter out =  new StringWriter();
			e.printStackTrace(new PrintWriter(out));

			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}

		return jsonResult;
	}
	
	
    /**
	 * 설  명: 방 나가기
	 * 작성자: 김상헌 
	 */
	@RequestMapping("/outRoom")
	@ResponseBody
	public Object outRoom( int mbrNo, int roomNo ) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			roomService.outRoom(mbrNo, roomNo);
			
			jsonResult.setStatus("success");

		} catch (Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		return jsonResult;
	}
	

	/**
	 * 설  명: 방 만들기
	 * 작성자: 김상헌 
	 */
    @RequestMapping("/addRoom")
    @ResponseBody
    public JsonResult addRoom(
    		MyInfo myInfo		, String gcmRegId	, Room room,
    		String startLocName	, double startLocLat, double startLocLng, int startLocRank,
    		String endLocName	, double endLocLat	, double endLocLng	, int endLocRank ) throws Exception {

        JsonResult jsonResult= new JsonResult();
        
        try {

			RoomMbr roomMbr = new RoomMbr()
											.setMbrNo( myInfo.getMbrNo() )
											.setRoomMbrRank(0)
											.setGcmRegId(gcmRegId);
        	RoomPath startPath = new RoomPath()
											.setPathRank(startLocRank)
											.setPathName(startLocName)
											.setPathLat(startLocLat)
											.setPathLng(startLocLng);
        	RoomPath endPath = new RoomPath()
											.setPathRank(endLocRank)
											.setPathName(endLocName)
											.setPathLat(endLocLat)
											.setPathLng(endLocLng);

        	RcntLoc recentEndLoc = new RcntLoc()
												.setMbrNo( myInfo.getMbrNo() )
												.setRcntLocName( endPath.getPathName() )
												.setRcntLocLat( endPath.getPathLat() )
												.setRcntLocLng( endPath.getPathLng() )
												.setRcntLocSt("E");

			int roomNo = roomService.addRoom( room, roomMbr, startPath, endPath, recentEndLoc );
			
			Room myRoom = roomService.getRoomInfo(roomNo);

			jsonResult.setData(myRoom);
			jsonResult.setStatus("success");

        } catch (Throwable e) {
            e.printStackTrace();
            StringWriter out =  new StringWriter();
            e.printStackTrace(new PrintWriter(out));

            jsonResult.setStatus("fail");
            jsonResult.setData(out.toString());
        }

        return jsonResult;
    }
	
    
    /**
	 * 설  명: 방 참여하기
	 * 작성자: 김상헌 
	 */
    @RequestMapping("/joinRoom")
    @ResponseBody
    public JsonResult joinRoom( 
    		RoomMbr roomMbr, String endLocName, double endLocLat, double endLocLng ) throws Exception {

        JsonResult jsonResult = new JsonResult();
        
        try {
        	int mbrNo = roomMbr.getMbrNo();
        	
        	RcntLoc recentEndLoc = new RcntLoc()
											.setMbrNo( mbrNo )
											.setRcntLocName( endLocName )
											.setRcntLocLat( endLocLat )
											.setRcntLocLng( endLocLng )
											.setRcntLocSt("E");
        	
            int roomNo = roomService.joinRoom(roomMbr, recentEndLoc);
            
            Room myRoom = roomService.getRoomInfo(roomNo);
            List<RcntLoc> rcntLocList 	= locationService.getRecentDestination(mbrNo);
            
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("myRoom"		, myRoom);
            resultMap.put("rcntLocList" , rcntLocList);
            
            jsonResult.setData(resultMap);
            jsonResult.setStatus("success");

        } catch (Throwable e) {
            e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));

            jsonResult.setStatus("fail");
            jsonResult.setData(out.toString());
        }
        return jsonResult;
    }
    
    
    /**
     * 설  명: 내방 가져오기
     * 작성자: 김상헌 
     */
    @RequestMapping("/getMyRoom")
    @ResponseBody
    public Object getMyRoom( int mbrNo ) throws Exception {
        
    	JsonResult jsonResult = new JsonResult();
        
    	try {

        	Room myRoom = roomService.getMyRoom( mbrNo );

            jsonResult.setData( myRoom );
            jsonResult.setStatus("success");

        } catch (Throwable e) {
        	e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));

            jsonResult.setStatus("fail");
            jsonResult.setData(out.toString());
        }

        return jsonResult;
    }
	
	
//	@RequestMapping(value="/setLocationSession")
//	@ResponseBody
//	public Object setLocationSession(
//			LocationSession paramLocation,
//			HttpSession session ) throws Exception {
//		JsonResult jsonResult = null;
//		LocationSession locationSession = (LocationSession) session.getAttribute("locationSession");
//
//		if ( locationSession == null ) {
//			locationSession = paramLocation;
//		} else {
//			if ( paramLocation.getStartName() != null && !"".equals(paramLocation.getStartName()) ) {
//				locationSession.setStartName(paramLocation.getStartName());
//			}
//			if ( paramLocation.getStartX() != 0 ) {
//				locationSession.setStartX(paramLocation.getStartX());
//			}
//			if ( paramLocation.getStartY() != 0 ) {
//				locationSession.setStartY(paramLocation.getStartY());
//			}
//			if ( paramLocation.getStartPrefix() != null ) {
//				locationSession.setStartPrefix(paramLocation.getStartPrefix());
//			}
//			if ( paramLocation.getEndName() != null && !"".equals(paramLocation.getEndName()) ) {
//				locationSession.setEndName(paramLocation.getEndName());
//			}
//			if ( paramLocation.getEndX() != 0 ) {
//				locationSession.setEndX(paramLocation.getEndX());
//			}
//			if ( paramLocation.getEndY() != 0 ) {
//				locationSession.setEndY(paramLocation.getEndY());
//			}
//			if ( paramLocation.getEndPrefix() != null ) {
//				locationSession.setEndPrefix(paramLocation.getEndPrefix());
//			}
//		}
//
//		session.setAttribute("locationSession", locationSession);
//
//
//		if (locationSession != null) {
//			jsonResult = new JsonResult()
//										.setStatus("success")
//										.setData(locationSession);
//		} else {
//			jsonResult = new JsonResult()
//										.setStatus("fail")
//										.setData(null);
//		}
//
//		return jsonResult;
//	}
	
	
//	@RequestMapping(value="/getLocationSession")
//	@ResponseBody
//	public Object getLocationSession( HttpSession session) throws Exception {
//		JsonResult jsonResult = null;
//
//		LocationSession locationSession = (LocationSession) session.getAttribute("locationSession");
//
//		if (locationSession != null) {
//			jsonResult = new JsonResult().setStatus("success")
//										 .setData(locationSession);
//		} else {
//			jsonResult = new JsonResult().setStatus("fail");
//		}
//
//		return jsonResult;
//	}
	
/*	//====================== AS-IS =======================//

    @RequestMapping("/getRoomInfo")
    @ResponseBody
    public Object getRoomInfo( int roomNo ) throws Exception {
        JsonResult jsonResult = new JsonResult();

        try {
            jsonResult.setStatus("success");
            jsonResult.setData( roomService.getRoomInfo(roomNo) );

        } catch (Throwable e) {
        	e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));

            jsonResult.setStatus("fail");
            jsonResult.setData(out.toString());
        }

        return jsonResult;
    }


/*
  @RequestMapping("/outRoom")
  @ResponseBody
  public Object outRoom( String mbrId, int roomNo ) throws Exception {
      JsonResult jsonResult = new JsonResult();

      System.out.println(mbrId + roomNo);
      try {
          roomService.outRoom(mbrId, roomNo);
          jsonResult.setStatus("success");

      } catch (Throwable e) {
          e.printStackTrace();
          StringWriter out = new StringWriter();
          e.printStackTrace(new PrintWriter(out));

          jsonResult.setStatus("fail");
          jsonResult.setData(out.toString());
      }
      return jsonResult;
  }
*/

}
