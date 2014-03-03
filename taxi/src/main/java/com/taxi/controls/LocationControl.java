package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.taxi.services.location.LocationService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.LoginInfo;
import com.taxi.vo.location.FvrtLoc;
import com.taxi.vo.location.RcntLoc;
import com.taxi.vo.member.Mbr;


@Controller
@RequestMapping("/location")
public class LocationControl {
	@Autowired ServletContext sc;
	@Autowired LocationService locationService;
	
	
	/**
	 * 설  명: 최근 목적지 가져오기
     * 작성자: 김상헌 
	 */
	@RequestMapping("/getRecentDestination")
    @ResponseBody
    public Object getRecentDestination(Mbr mbr) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	List<RcntLoc> recentLocList = locationService.getRecentDestination(mbr.getMbrNo());
        	
            jsonResult.setData( recentLocList );
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
	 * 설  명 : 즐겨찾기 목록 가져오기
	 * 작성자 : 장종혁
	 * 
	 */
	@RequestMapping("/getFavoriteList")
    @ResponseBody
    public Object getFavoriteList(int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
        
        try {
        	List<FvrtLoc> fvrtLocList = locationService.getFavoriteList(mbrNo);
        	
            jsonResult.setData(fvrtLocList);
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
	 * 설  명 : 즐겨찾기 추가 
	 * 작성자 : 장종혁
	 */
	@RequestMapping("/addFavoriteLocation")
    @ResponseBody
    public Object addFavoriteLocation(FvrtLoc fvrtLoc) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	
        	List<FvrtLoc> fvrtLocList = locationService.addFvrtLoc(fvrtLoc);
        	
        	jsonResult.setData( fvrtLocList );
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
	 * 설  명 : 즐겨찾기 목록 전체 삭제
	 * 작성자 : 장종혁
	 * @param mbrNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAllFavoriteLocation")
    @ResponseBody
    public Object deleteAllFavoriteLocation(int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	locationService.deleteAllFvrtLoc(mbrNo);
        	
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
	 * 설  명 : 즐겨찾기 삭제
	 * 작성자 : 장종혁
	 */
	@RequestMapping("/deleteFavoriteLocation")
    @ResponseBody
    public Object deleteFavoriteLocation(int fvrtLocNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	locationService.deleteFvrtLoc(fvrtLocNo);
        	
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
	 * 내  용:회원 번호와 위치번호에 해당 하는 우선순위 값 업데이트. 후 업데이트 결과 클라이언트에 넘겨줌.
	 * 작성자 : 김태경
	 */
	@RequestMapping(value="/changeFavoritePlaces" )
	@ResponseBody
	public Object changeFavoritePlaces(	int mbrNo,
										@RequestBody String json ) throws Exception {
	 JsonResult jsonResult = new JsonResult();
	 
		try {
			System.out.println(json);
			System.out.println(mbrNo);
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
				
				locationService.changeFavoritePlaces(mbrNo,fvrtLocList.get(i));
			}
			
	        jsonResult.setStatus("success");
	        jsonResult.setData(locationService.getFavoriteList(mbrNo));
	       
			
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
	  * 내   용:선택된 랭크번호에 따른 db 즐겨찾기 목록 삭제후 변경된 즐겨찾기 목록 반환.
	  * 작성자 : 김태경
	  */
	@RequestMapping("/deleteFavoritePlace")
	@ResponseBody
	public Object deleteFavoritePlace ( int fvrtLocNo , int mbrNo) throws Exception{
	    JsonResult jsonResult = new JsonResult();
	    
	    System.out.println("위치 고유 번호="+fvrtLocNo+"\t컨트롤");
	    try {
	    	jsonResult.setData(locationService.removeFavoritePlace(fvrtLocNo , mbrNo));
	        jsonResult.setStatus("success");
	       /* jsonResult.setData(locationService.getFavoriteList(mbrNo));*/
	 
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
