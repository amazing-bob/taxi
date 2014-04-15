package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.taxi.services.auth.AuthService;
import com.taxi.services.black.BlackService;
import com.taxi.services.friend.FriendService;
import com.taxi.services.location.LocationService;
import com.taxi.services.member.MemberService;
import com.taxi.services.room.RoomService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.Account;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.black.Black;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.member.Mbr;
import com.taxi.vo.room.Room;


@Controller
@RequestMapping("/auth")
public class AuthControl {
	@Autowired ServletContext 	sc;
	@Autowired AuthService 		authService;
	@Autowired MemberService 	memberService;
	@Autowired LocationService 	locationService;
	@Autowired BlackService		blackService;
	@Autowired FriendService    friendService;
	@Autowired RoomService 		roomService;
	
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@RequestMapping("/hasMember")
	@ResponseBody
	public <T> Object hasMember( Mbr mbr ) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			
			MyInfo myInfo = authService.hasMember(mbr);
			List<Frnd> 		frndList 	= null;
			List<FvrtLoc> 	fvrtLocList = null;
			List<RcntLoc> 	rcntLocList = null;
			List<Black> 	blackList 	= null;
			
			
			if ( myInfo != null && myInfo.getMbrNo() > 0 ) {
				int mbrNo = myInfo.getMbrNo();
				
				frndList 	= friendService.getFrndList(mbrNo);
				fvrtLocList = locationService.getFavoriteList(mbrNo);
				rcntLocList = locationService.getRecentDestination(mbrNo);
				blackList 	= blackService.getBlackList(mbrNo, 0);
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("myInfo" 		, myInfo);
			resultMap.put("frndList"	, frndList);
			resultMap.put("fvrtLocList"	, fvrtLocList);
			resultMap.put("rcntLocList"	, rcntLocList);
			resultMap.put("blackList"	, blackList);
			
			
			jsonResult.setData(resultMap);
			jsonResult.setStatus("success");
			
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult = new JsonResult().setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}

	
	/**
	 * 설  명: 회원가입 
	 * 작성자: 이용준
	 */
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	@ResponseBody
	public <T> Object signUp( @RequestBody String json ) throws Exception {
		JsonResult jsonResult = new JsonResult();

		try {
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			
			// Mbr 받기
			Mbr mbr = gson.fromJson(jsonObject, new TypeToken<Mbr>() {}.getType());
			//임시 이미지 셋팅.
			//mbr.setMbrPhotoUrl("../images/photo/m01.jpg");
			
			int keywordNo = 0;
			List<Frnd> frndListParam = null;
			
			try {
				// keywordNo 받기
				JsonElement keywordElement = jsonObject.get("keywordNo");
				if ( keywordElement != null ) {
					keywordNo = keywordElement.getAsInt();
				}
				
				// frndList 받기
				JsonElement jsonElement = jsonObject.get("frndList");
				JsonArray jsonArray = jsonElement.getAsJsonArray();
				if ( jsonArray != null ) {
					frndListParam = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}

			int 			mbrNo		= 0;	
			MyInfo 			myInfo 		= null;
			List<Frnd> 		frndList 	= null;
			List<FvrtLoc> 	fvrtLocList = null;
			List<RcntLoc> 	rcntLocList = null;
			List<Black> 	blackList 	= null;
			
			myInfo = authService.hasMember(mbr);
			
			if ( myInfo != null && myInfo.getMbrNo() > 0 ) {
				mbrNo = myInfo.getMbrNo();
				
			} else {
				mbrNo = memberService.signUp(mbr, keywordNo, frndListParam);
				
			}
			
			if ( mbrNo > 0 ) {
				myInfo 		= memberService.getMyInfo(mbrNo);
				frndList 	= friendService.getFrndList(mbrNo);
				fvrtLocList = locationService.getFavoriteList(mbrNo);
				rcntLocList = locationService.getRecentDestination(mbrNo);
				blackList 	= blackService.getBlackList(mbrNo, 0);
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("myInfo" 		, myInfo);
			resultMap.put("frndList"	, frndList);
			resultMap.put("fvrtLocList"	, fvrtLocList);
			resultMap.put("rcntLocList"	, rcntLocList);
			resultMap.put("blackList"	, blackList);
			
			
			jsonResult.setData(resultMap);
			jsonResult.setStatus("success");

					
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	
	/**
	 * 설  명: 추가 계정 만들기
	 * 작성자: 김상헌 
	 */
	@RequestMapping("/createAccount")
	@ResponseBody
	public Object craeteAccount(Account account) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			authService.createAccount(account);
			MyInfo myInfo = memberService.getMyInfo( account.getMbrNo() );
			
			jsonResult.setData(myInfo);
			jsonResult.setStatus("success");
			
		} catch(Exception e) {
			e.printStackTrace();
			
			jsonResult.setStatus("fail");
			jsonResult.setData(e.getMessage());
		}
		
		return jsonResult;
	}

	
	/**
	 * 설  명: 계정 로그인
	 * 작성자: 김상헌
	 */
	@RequestMapping("/loginAccount")
	@ResponseBody
	public Object loginAccount( Account account ) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			int 			mbrNo	 	= authService.loginAccountReturnMyInfo(account);
			MyInfo 			changeMyInfo = null;
			Room 			myRoom 		= null;
			List<Frnd> 		frndList 	= null;
			List<FvrtLoc> 	fvrtLocList = null;
			List<RcntLoc> 	rcntLocList = null;
			List<Black> 	blackList 	= null;
			
			
			if ( mbrNo > 0 ) {
				changeMyInfo = memberService.getMyInfo(mbrNo);
				myRoom 		= roomService.getMyRoom(mbrNo);
				frndList 	= friendService.getFrndList(mbrNo);
				fvrtLocList = locationService.getFavoriteList(mbrNo);
				rcntLocList = locationService.getRecentDestination(mbrNo);
				blackList 	= blackService.getBlackList(mbrNo, 0);
				
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("myInfo" 		, changeMyInfo);
			resultMap.put("myRoom"		, myRoom);
			resultMap.put("frndList"	, frndList);
			resultMap.put("fvrtLocList"	, fvrtLocList);
			resultMap.put("rcntLocList"	, rcntLocList);
			resultMap.put("blackList"	, blackList);
			
			
			jsonResult.setData(resultMap);
			jsonResult.setStatus("success");
			
		} catch(Exception e) {
			e.printStackTrace();
			
			jsonResult.setStatus("fail");
			jsonResult.setData( e.getMessage() );
		}
		
		return jsonResult;
	}
	
	
	/**
	 * 설  명: 이메일 유효성 검사
	 * 작성자: 김상헌
	 */
	@RequestMapping("/validSignupAccount")
	@ResponseBody
	public Object validAccount( Account account ) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			boolean isVaildAccount = authService.validAccount(account);

			if ( isVaildAccount ) {
				jsonResult.setStatus("success");
				jsonResult.setData(true);
				
			} else {
				jsonResult.setStatus("success");
				jsonResult.setData(false);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
			jsonResult.setStatus("fail");
			jsonResult.setData( e.getMessage() );
			
		}
		
		return jsonResult;
	}
	
	
	/**
	 * 설  명: 비밀번호 찾기 
	 * 작성자: 김상 
	 */
	@RequestMapping("/findPassword")
	@ResponseBody
	public Object findPassword( String accountEmail ) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			Account account = authService.sendEmailForFindPassword( accountEmail );

			if ( account != null && account.getAccountEmail() != null ) {
				jsonResult.setStatus("success");
				jsonResult.setData(account.getAccountEmail());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
			jsonResult.setStatus("fail");
			jsonResult.setData( e.getMessage() );
			
		}
		
		return jsonResult;
	}
}
