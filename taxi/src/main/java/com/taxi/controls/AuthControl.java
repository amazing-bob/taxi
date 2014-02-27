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
			
			MyInfo myInfo = authService.hasMember(mbrNo);
			
			if ( myInfo != null && myInfo.getMbrNo() > 0 ) {
				List<Frnd> 		frndList 	= friendService.getFrndList(mbrNo);
				List<FvrtLoc> 	fvrtLocList = locationService.getFavoriteList(mbrNo);
				List<RcntLoc> 	rcntLocList = locationService.getRecentDestination(mbrNo);
				List<Black> 	blackList 	= blackListService.getBlackList(mbrNo);
				
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("myInfo" 		, myInfo);
				resultMap.put("frndList"	, frndList);
				resultMap.put("fvrtLocList"	, fvrtLocList);
				resultMap.put("rcntLocList"	, rcntLocList);
				resultMap.put("blackList"	, blackList);
			
				
				jsonResult.setData(resultMap);
				jsonResult.setStatus("success");
				
			} else {
				throw new Exception("회원가입 실패!!");
				
			}
			
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
			mbr.setMbrPhotoUrl("../images/photo/m01.jpg");
			
			int keywordNo = 0;
			List<Frnd> frndListParam = null;
			
			try {
				// keywordNo 받기
				JsonElement keywordElement = jsonObject.get("keywordNo");
				keywordNo = keywordElement.getAsInt();
				
				// frndList 받기
				JsonElement jsonElement = jsonObject.get("frndList");
				JsonArray jsonArray = jsonElement.getAsJsonArray();
				frndListParam = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
				
			} catch(Exception e) {}

			int mbrNo = memberService.signUp(mbr, keywordNo, frndListParam);
		
			if ( mbrNo > 0 ) {
				MyInfo 			myInfo 		= memberService.getMyInfo(mbrNo);
				List<Frnd> 		frndList 	= friendService.getFrndList(mbrNo);
				List<FvrtLoc> 	fvrtLocList = locationService.getFavoriteList(mbrNo);
				List<RcntLoc> 	rcntLocList = locationService.getRecentDestination(mbrNo);
				List<Black> 	blackList 	= blackListService.getBlackList(mbrNo);
				
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("myInfo" 		, myInfo);
				resultMap.put("frndList"	, frndList);
				resultMap.put("fvrtLocList"	, fvrtLocList);
				resultMap.put("rcntLocList"	, rcntLocList);
				resultMap.put("blackList"	, blackList);
			
				
				jsonResult.setData(resultMap);
				jsonResult.setStatus("success");
				
			} else {
				throw new Exception("회원가입 실패!!");
				
			}
					
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}

}
