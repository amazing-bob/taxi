package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

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
import com.taxi.services.member.MemberService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.friend.Frnd;


@Controller
@RequestMapping("/member")
public class MemberControl {
	@Autowired ServletContext sc;
	@Autowired MemberService memberService;	
	
/*	//====================== AS-IS =======================//
 
	@RequestMapping("/leaveMember")
    @ResponseBody
    public Object leaveMember(HttpSession session) throws Exception {
        JsonResult jsonResult = new JsonResult();
         
        try {
            LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
            String mbrId = loginInfo.getMbrId();
            jsonResult.setData(mbrId);
            memberService.leaveMember(mbrId);
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
	
	@RequestMapping("/addFavoritePlace")
    @ResponseBody
    public Object addFavoritePlace( HttpSession session,
                                    LoginInfo loginInfo, 
                                    FvrtLoc fvrtLoc ) throws Exception {
                 
	       JsonResult jsonResult = new JsonResult();
	         
	        try {
	            loginInfo = (LoginInfo) session.getAttribute("loginInfo");
	            fvrtLoc.setMbrId(loginInfo.getMbrId());
	            
	            memberService.addFavoritePlace(fvrtLoc);
	            
	            jsonResult.setStatus("success");
	            System.out.println("Add Control success");
	             
	        } catch (Throwable e) {
	        	e.printStackTrace();
	            StringWriter out = new StringWriter();
	            e.printStackTrace(new PrintWriter(out));
	             
	            jsonResult.setStatus("fail");
	            jsonResult.setData(out.toString());
	        }
	         
	        return jsonResult;
    }
             
    @RequestMapping("/getFavoritePlaces")
    @ResponseBody
    public Object getFavoritePlaces( HttpSession session ) throws Exception {
         
        JsonResult jsonResult = new JsonResult();
 
        try {
             
            LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
            System.out.println("loginInfo :" + loginInfo.getMbrId());
             
                jsonResult.setStatus("success");
                jsonResult.setData(memberService.getFavoritePlaces(loginInfo.getMbrId()));
                 
            } catch (Throwable e) {
            	e.printStackTrace();
                StringWriter out = new StringWriter();
                e.printStackTrace(new PrintWriter(out));
                 
                jsonResult.setStatus("fail");
                jsonResult.setData(out.toString());
            }
            return jsonResult;          
    }
    
    @RequestMapping(value="/changeFavoritePlaces" )
	@ResponseBody
	public Object changeFavoritePlaces(HttpSession session,
											@RequestBody String json ) throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			System.out.println(json);
			System.out.println("11");
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			
			JsonElement jsonElement = jsonObject.get("fvrtArr");
      		JsonArray jsonArray = jsonElement.getAsJsonArray();
			List<FvrtLoc> fvrtLocList = gson.fromJson(jsonArray, new TypeToken<List<FvrtLoc>>() {}.getType());

			for (int i = 0; i < fvrtLocList.size(); i++) {
				System.out.println(fvrtLocList.get(i).getFvrtLocName() + " | " + 
						fvrtLocList.get(i).getFvrtLocNo() + " | " + fvrtLocList.get(i).getFvrtLocRank());
				System.out.println(fvrtLocList);
				System.out.println("알라리오");
				
				memberService.changeFavoritePlaces(fvrtLocList.get(i));
			}
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
    
    
    @RequestMapping("/deleteFavoritePlace")
    @ResponseBody
    public Object deleteFavoritePlace ( int fvrtLocNo ) throws Exception{
        JsonResult jsonResult = new JsonResult();
        try {
            memberService.removeFavoritePlace(fvrtLocNo);
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
    
    

	
	@RequestMapping("/leaveMember")
    @ResponseBody
    public Object leaveMember(int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
         
        
        System.out.println(mbrNo+"=============넘어온회원번호");
        try {
        	memberService.leaveMember(mbrNo);
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
	 * 내용 : 프로필 이름변경
	 * 작성자 : 김태경
	 */
	@RequestMapping("/profileNameUpdate")
    @ResponseBody
    public Object profileNameUpdate(String newName , int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
         
        
        System.out.println(newName+"=============변경될이름");
        System.out.println(mbrNo+"=============변경회원");
        try {
        	
        	String result = memberService.updateMbrName(newName , mbrNo);
        	
        	if(result != null){
        		jsonResult.setData(result);
        		jsonResult.setStatus("success");
        	}
        	
        	
        	
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
	 * 내용:프로필 전화번호 변경
	 * 작성자 : 김태경
	 */
	@RequestMapping("/profilePhoneNumberUpdate")
    @ResponseBody
    public Object profilePhoneNumberUpdate(String newPhoneNumber , int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
         
        
        System.out.println(newPhoneNumber+"=============변경될번호");
        System.out.println(mbrNo+"=============변경될회원");
        try {
        	
        	String result = memberService.updateMbrPhoneNo(newPhoneNumber , mbrNo);
        	jsonResult.setData(result);
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
}