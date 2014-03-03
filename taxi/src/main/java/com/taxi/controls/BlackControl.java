package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.black.BlackService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.black.Black;


@Controller
@RequestMapping("/black")
public class BlackControl {
	@Autowired ServletContext 	sc;
	@Autowired BlackService 	blackService;
	
	
	/**
	 * 설  명: 블랙리스트 등록
	 * 작성자: 김상헌
	 */
	@RequestMapping("/registerBlacklist")
	@ResponseBody
	public JsonResult registerBlacklist( Black black ) {
		JsonResult jsonResult  = new JsonResult();
		
		try {
			boolean isSuccess = blackService.registerBlacklist(black);
			
			List<Black> blackList = null;
			
			if ( isSuccess ) {
				blackList = blackService.getBlackList( black.getMbrNo(), black.getBlackMbrNo() );
			}
			
			jsonResult.setData(blackList);
			jsonResult.setStatus("success");
				
		} catch (Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setData(out.toString());
			jsonResult.setStatus("fail");
		}
		
		return jsonResult;
		
	}
	

}
