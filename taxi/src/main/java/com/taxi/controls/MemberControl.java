package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.member.MemberService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


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
    
    
    @RequestMapping(value="/frndRefresh", method=RequestMethod.POST)
    @ResponseBody
    public <T> Object frndRefresh(@RequestBody String json, 
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
    	
    		memberService.frndRefresh(mbr);
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
*/
	
	@RequestMapping("/leaveMember")
    @ResponseBody
    public Object leaveMember(MyInfo myInfo) throws Exception {
        JsonResult jsonResult = new JsonResult();
         
        try {
        	
        	
        	
        	memberService.leaveMember(myInfo.getMbrNo());
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