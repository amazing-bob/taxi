package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.services.location.LocationService;
import com.taxi.vo.JsonResult;
import com.taxi.vo.auth.LoginInfo;
import com.taxi.vo.member.Mbr;


@Controller
@RequestMapping("/location")
public class LocationControl {
	@Autowired ServletContext sc;
	@Autowired LocationService locationService;
	

	@RequestMapping("/getRecentDestination")
    @ResponseBody
    public Object getRecentDestination(Mbr mbr) throws Exception {
        JsonResult jsonResult = new JsonResult();
        try {
        	System.out.println("=========" + mbr.getMbrNo());
            jsonResult.setData( locationService.getRecentDestination(mbr.getMbrNo()) );
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
