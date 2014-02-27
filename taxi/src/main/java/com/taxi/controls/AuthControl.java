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
import com.taxi.services.blacklist.BlackListService;
import com.taxi.services.friend.FriendService;
import com.taxi.services.location.LocationService;
import com.taxi.services.member.MemberService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.blacklist.Black;
import com.taxi.vo.friend.Frnd;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.member.Mbr;


@Controller
@RequestMapping("/auth")
public class AuthControl {
	@Autowired ServletContext 	sc;
	@Autowired AuthService 		authService;
	@Autowired MemberService 	memberService;
	@Autowired LocationService 	locationService;
	@Autowired BlackListService	blackListService;
	@Autowired FriendService    friendService;
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@RequestMapping("/hasMember")
	@ResponseBody
	public <T> Object hasMember( Mbr mbr ) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			
			int mbrNo = mbr.getMbrNo();
			
			MyInfo myInfo 				= authService.hasMember(mbrNo);
			List<FvrtLoc> fvrtLocList 	= locationService.getFavoriteList(mbrNo);
			List<RcntLoc> rcntLocList 	= locationService.getRecentDestination(mbrNo);
			List<Black> blackList 		= blackListService.getBlackList(mbrNo);
			
			// 대학교(keyword) 목록 조회
			
			// 친구정보 업데이트 코드 들어가야함.
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("myInfo" 		, myInfo);
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
			Mbr mbr = gson.fromJson(jsonObject, new TypeToken<Mbr>() {}.getType());
			//임시 이미지 셋팅.
			mbr.setMbrPhotoUrl("../images/photo/m01.jpg");
			
			int keywordNo = 0;
			try {
				JsonElement keywordElement = jsonObject.get("keywordNo");
				keywordNo = keywordElement.getAsInt();
			} catch(Exception e) {}
			
			
			MyInfo myInfo = memberService.signUp(mbr, keywordNo);
			
			
			// json객체에서 frndList 가져오기
			try{
				JsonElement jsonElement = jsonObject.get("frndList");
				JsonArray jsonArray = jsonElement.getAsJsonArray();
				List<Frnd> frndList = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
				// 넣기 전 frndList에  mbrNo 추가
				for(Frnd frnd : frndList){
					frnd.setMbrNo(myInfo.getMbrNo());
				}

				//frndList 서버에 등록
				friendService.insertFrndList(frndList);
				
			}catch(Exception e){
				
			};
			
			List<Frnd> frndList = friendService.getFrndList(myInfo.getMbrNo());
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("myInfo" 		, myInfo);
			resultMap.put("frndList"	, frndList);
//			resultMap.put("fvrtLocList"	, fvrtLocList);
//			resultMap.put("rcntLocList"	, rcntLocList);
//			resultMap.put("blackList"	, blackList);
		
			
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
	
	

/*	//====================== AS-IS =======================//
 	
	@Autowired MemberService memberService;
	
	
	// LOGIN - SELECT 
	@RequestMapping(value="/isSignUp", method=RequestMethod.POST)
	@ResponseBody
	public <T> Object isSignUp( @RequestBody String json) throws Exception {
		System.out.println("isSignUp");
		JsonResult jsonResult = new JsonResult();
		try {
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			Mbr mbr = gson.fromJson(jsonObject, new TypeToken<Mbr>() {}.getType());
			
			LoginInfo loginInfo = authService.getLoginInfo(mbr.getMbrId());
			
			String mbrId = mbr.getMbrId();
			
			
			if (loginInfo != null && mbrId.equals(loginInfo.getMbrId()) ) {
				jsonResult.setData(true);
				jsonResult.setStatus("success");
				
			} else {
				jsonResult.setData(false);
				jsonResult.setStatus("success");
			}
			
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult = new JsonResult().setStatus("fail");
		}
		return jsonResult;
	}
	
	
	// SIGN UP- INSERT
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseBody
	public <T> Object signup(@RequestBody String json, 
							HttpSession session ) throws Exception {
		JsonResult jsonResult = null;

		try {
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			Mbr mbr = gson.fromJson(jsonObject, new TypeToken<Mbr>() {}.getType());
			
			JsonElement jsonElement = jsonObject.get("friendList");
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			List<Frnd> frndList = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
			
			mbr.setFrndList(frndList);
		
			memberService.signUp(mbr);
			jsonResult = new JsonResult().setStatus("success");
					
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			session.invalidate();
			jsonResult = new JsonResult().setStatus("fail");
		}
		return jsonResult;
	}
	
	// LOGIN - SELECT 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public <T> Object login( @RequestBody String json, 
										HttpSession session ) throws Exception {
		System.out.println("login");
		JsonResult jsonResult = new JsonResult();
		try {
			System.out.println(json);
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			Mbr mbr = gson.fromJson(jsonObject, new TypeToken<Mbr>() {}.getType());
			
			JsonElement jsonElement = jsonObject.get("friendList");
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			List<Frnd> frndList = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
			mbr.setFrndList(frndList);
			
			LoginInfo loginInfo = authService.getLoginInfo(mbr.getMbrId());
			
			if (loginInfo != null) {
				session.setAttribute("loginInfo", loginInfo);
				jsonResult.setData(loginInfo);
				jsonResult.setStatus("success");
															
			} else {
				session.invalidate();
				jsonResult.setStatus("fail");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			session.invalidate();
			
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			jsonResult.setData(out.toString());
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		return jsonResult;
	}
	
	
	// 111111111111111
	 
	// LoginInfo 세션 
	@RequestMapping(value="/loginInfo")
	@ResponseBody
	public Object loginInfo(
			HttpSession session ) throws Exception {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		
		JsonResult jsonResult = null;
		if (loginInfo != null) {
			jsonResult = new JsonResult().setStatus("success")
										 .setData(loginInfo);
		} else {
			session.invalidate();
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		return jsonResult;
	}
	
	// LOGOUT 
	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(HttpSession session) throws Exception {
		System.out.println("logout()");
		JsonResult jsonResult = new JsonResult();
		try {
			session.invalidate();
			jsonResult.setStatus("success");
		} catch (Throwable e) {
			e.printStackTrace();
			session.invalidate();
			
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			jsonResult.setData(out.toString());
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		return jsonResult;
	}
*/

}
