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
import com.taxi.services.friend.FriendService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.friend.Frnd;


@Controller
@RequestMapping("/friend")
public class FriendControl {
	@Autowired ServletContext sc;
	@Autowired FriendService friendService;
	
	/**
	 * 내용 : 친구목록 업데이트
	 * 작성자 : 김태경
	 */
	@RequestMapping(value="/frndRefresh", method=RequestMethod.POST)
    @ResponseBody
    public <T> Object frndRefresh(@RequestBody String json ) throws Exception {
		
    	JsonResult jsonResult = null;
    	List<Frnd> frndList = null;
    	
    	try {
    		System.out.println(json);
    		Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = (JsonObject) parser.parse(json);
			
			JsonElement jsonElement = jsonObject.get("frndList");
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			
    		frndList = gson.fromJson(jsonArray, new TypeToken<List<Frnd>>() {}.getType());
    		
    		Frnd frnd = frndList.get(0);
    		int mbrNo = frnd.getMbrNo();
    		System.out.println(frndList.size());
    		System.out.println(mbrNo);
    		
    		Map<String, Object> resultMap = new HashMap<String, Object>();
    		frndList = friendService.updateFrndList(frndList , mbrNo);
    		
    		resultMap.put("frndList", frndList);
    		jsonResult = new JsonResult().setData(resultMap)
    									 .setStatus("success");
    				
    	} catch(Throwable e) {
    		e.printStackTrace();
    		StringWriter out = new StringWriter();
    		e.printStackTrace(new PrintWriter(out));
    		
    		
    		jsonResult = new JsonResult().setStatus("fail");
    	}
    	return jsonResult;
    }
}
