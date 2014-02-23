package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.taxi.services.auth.AuthService;
import com.taxi.services.member.MemberService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


@Controller
@RequestMapping("/auth")
public class AuthControl {
	@Autowired ServletContext 	sc;
	@Autowired AuthService 		authService;
	@Autowired MemberService 	memberService;
	
	
	/**
	 * 설  명: 회원가입 여부 조회 
	 * 작성자: 이용준
	 */
	@RequestMapping("/hasMember")
	@ResponseBody
	public <T> Object hasMember( Mbr mbr ) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			
			MyInfo myInfo = authService.hasMember(mbr.getMbrNo());
			
			jsonResult.setData(myInfo);
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
			
			// 임시 이미지 세팅
			mbr.setMbrPhotoUrl("../images/photo/m01.jpg");
			
/*			JsonElement jsonElement = jsonObject.get("friendList");
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			List<Frnd> frndList = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
			
			mbr.setFrndList(frndList);*/
		
			MyInfo myInfo = memberService.signUp(mbr);
			
			jsonResult.setData(myInfo);
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
	 * 설  명: 초기 DB 키워드 목록 
	 * 작성자: 김태경
	 */
	@RequestMapping("/getKeyWordList")
	@ResponseBody
	public Object getKeyWordlist() throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			
			jsonResult.setData(authService.getKeyWordlist());
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
	 * 설  명: 초기 DB 키워드 목록 
	 * 작성자: 김태경
	 *//*
	@RequestMapping("/serchKeyWordList")
	@ResponseBody
	public Object serchKeyWordList(String serchKeyWord) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		System.out.println("=================================입력된 키워드:"+serchKeyWord+"===============");
		try {
			
			jsonResult.setData(authService.serchKeyWordList(serchKeyWord));
			jsonResult.setStatus("success");
			
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult = new JsonResult().setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}*/
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
