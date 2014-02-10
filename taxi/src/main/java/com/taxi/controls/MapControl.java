package com.taxi.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxi.vo.JsonResult;


@Controller
@RequestMapping("/map")
public class MapControl {
	@Autowired ServletContext sc;	
	
	
	@RequestMapping(value="/ollehMapApi")
	@ResponseBody
	public <T> Object ollehMapApi( String url, String params ) throws Exception {
		System.out.println("localSearch");
		
		System.out.println("url :: " + url + "\nparams :: " + params);
		HttpResponse responseGet = null;
		HttpEntity resEntity = null;
		JsonResult jsonResult = new JsonResult();
		try {
			url += "?params=" + URLEncoder.encode(params, "UTF-8");
			System.out.println("url :: " + url);
			
			HttpGet get = new HttpGet(url);
			// 개발 key
			get.setHeader("authorization", "Basic QjdwcFZacjlEUXJLaXJ0NDU3RlNicU8xYzhVZjI0OVN0THZ5V0l2eDF0c1g0Z0JDRnk6OG1jMEY2d3FXS1hNczJYcVVkTnU3bDg5aVpDYWhlaFNGTm55UFNaVTcwMTd4NTRYOWg=");
			// 상용 key
//			get.setHeader("authorization", "Basic VThnQjRtU3ZPUHlUQkxKWVMzeU1HaVpkM2ljQ1RNNWQ3Y0JXT05wc2IyZTB2QlByOFk6dUNvYm9tbHROMUZQR0NCVjB1SnZyZngxQ1dhb3JkV21DY1U4Rm0wZkJKelhqQlN6VkE=");
			
			responseGet = new DefaultHttpClient().execute(get);
			resEntity = responseGet.getEntity();
			String result = EntityUtils.toString(resEntity);
			result = URLDecoder.decode(result, "UTF-8").replace("\"{", "{").replace("}\"", "}");
			if (result != null && result.length() > 0) {
				jsonResult.setData(result);
				jsonResult.setStatus("success");
			} else {
				jsonResult.setStatus("fail");
			}
			
		} catch(Throwable e) {
			e.printStackTrace();
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult = new JsonResult().setStatus("fail");
		}
		return jsonResult;
	}
	
	
}
