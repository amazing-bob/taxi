package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.comment.CommentService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;

@Controller
@RequestMapping("/comment")
public class CommentControl {
	@Autowired ServletContext sc;
	@Autowired CommentService commentService;
	
	/**
	 * 설  명: 의견보내기
	 * 작성자: 김영화 
	 */
	@RequestMapping(value="/commentSend",method=RequestMethod.POST)
	@ResponseBody
	public Object commentSend(int mbrNo, String comment) throws Exception{
		JsonResult jsonResult = new JsonResult();
		
		try{
			jsonResult.setData(commentService.commentSend(mbrNo, comment));
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
}

