package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.keyword.KeywordService;
import com.taxi.vo.JsonResult;


@Controller
@RequestMapping("/keyword")
public class KeywordControl {
	@Autowired ServletContext sc;
	@Autowired KeywordService keywordService;
	
	/**
	 * 설  명: 초기 DB 키워드 목록 
	 * 작성자: 김태경
	 */
	@RequestMapping("/getKeywordList")
	@ResponseBody
	public Object getKeywordList() throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			
			jsonResult.setData(keywordService.getKeywordList());
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
}
