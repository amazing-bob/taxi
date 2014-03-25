package com.taxi.controls;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.taxi.services.member.MemberService;
import com.taxi.services.setting.SettingService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.MyInfo;
import com.taxi.vo.member.Mbr;


@Controller
@RequestMapping("/setting")
public class SettingControl {
	@Autowired ServletContext sc;
	@Autowired SettingService settingService;
	@Autowired MemberService memberService;
	
	long currTime = 0;
	int count = 0; 
	
	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(SessionStatus status) throws Exception {
		System.out.println("logout()");
		status.setComplete();
		JsonResult jsonResult = new JsonResult();
		jsonResult.setStatus("success");

		return jsonResult;
	}
	
	@RequestMapping(value="/updateRange",method=RequestMethod.POST)
	@ResponseBody
	public Object updateRange(MyInfo myInfo) throws Exception{

		JsonResult jsonResult = new JsonResult();
		
		try{
			jsonResult.setData(settingService.updateRange(myInfo));
			System.out.println("변경된 시작 반경!!!!!"+settingService.updateRange(myInfo).getStartRange());
			jsonResult.setStatus("success");
		}catch(Throwable e){
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));

			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}

		return jsonResult;

	}

	/**
	 * 설  명 : 프로필 사진 업로드 및 유저 ImgUrl 업데이트
	 * 작성자 : 장종혁
	 */
	@RequestMapping(value="/uploadUserPhoto", method=RequestMethod.POST)
	@ResponseBody
	public Object uploadUserPhoto(@RequestParam("mbrNo")int mbrNo,
								  @RequestParam("rootPath")String rtPath,
								  @RequestParam("file")MultipartFile userPhoto) throws Exception {
		
		JsonResult jsonResult = new JsonResult();
		
	    try {
		    String path = new String();
		    Mbr mbr = new Mbr();
		    
		    path = sc.getAttribute("rootRealPath") +userPhoto.getName(); 

		    String filename = this.getNewFileName();
			path = sc.getAttribute("rootRealPath") + "userProfileImg/" + filename+".jpg";
			userPhoto.transferTo(new File(path));
			
			mbr.setMbrNo(mbrNo);
			mbr.setMbrPhotoUrl(rtPath+"/userProfileImg/" + filename+".jpg");
			
			System.out.println(mbr.getMbrPhotoUrl());
			
			memberService.updateMbrPhotoUrl(mbr);
		
			jsonResult.setStatus("success");
			jsonResult.setData(mbr.getMbrPhotoUrl());
		
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			e.printStackTrace();
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		return jsonResult;
	}
	
	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "userProfileImg_" + millis + "_" + (++count);
	}
	
	
	
}

