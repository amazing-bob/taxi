package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * 현재는 mbrNo를 보내주지 않으므로 고정적으로 1이라 작성
	 * 
	 */
	@RequestMapping("/getFavoriteList")
    @ResponseBody
    public Object getFavoriteList() throws Exception {
//    public Object getFavoriteList(int mbrNo) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	int mbrNo;
        	mbrNo=1;
        	
        	System.out.println("=========" + mbrNo);
            jsonResult.setData(locationService.getFavoriteList(mbrNo));
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
	 * mbrNo값이 넘어오지 않으므로, 지정값 1로 설정
	 */
	@RequestMapping("/addFavoriteLocation")
    @ResponseBody
    public Object addFavoriteLocation(FvrtLoc fvrtLoc) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	fvrtLoc.setMbrNo(1);
        	
        	locationService.addFvrtLoc(fvrtLoc);
        	
        	jsonResult.setData(locationService.getFavoriteList(fvrtLoc.getMbrNo()));
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
	
	
	
	

}
