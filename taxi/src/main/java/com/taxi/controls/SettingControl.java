package com.taxi.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/settings")
public class SettingControl {

	
/*	//====================== AS-IS =======================//
 
	@Autowired ServletContext sc;
	@Autowired SettingService settingService;
	
	
	@RequestMapping(value="/getRange")
    @ResponseBody
    public Object getRange( HttpSession session,
                                    LoginInfo loginInfo ) throws Exception {
         
        JsonResult jsonResult = new JsonResult();
 
        try {
             
            loginInfo = (LoginInfo) session.getAttribute("loginInfo");
           
                jsonResult.setStatus("success");
                jsonResult.setData(settingService.getRange(loginInfo.getMbrId()));
                 
            } catch (Throwable e) {
            	e.printStackTrace();
                StringWriter out = new StringWriter();
                e.printStackTrace(new PrintWriter(out));
                 
                jsonResult.setStatus("fail");
                jsonResult.setData(out.toString());
            }
            return jsonResult;          
    }
	
	
	@RequestMapping(value="/updateRange",method=RequestMethod.POST)
	@ResponseBody
	public Object updateRange(Setting setting, HttpSession session) throws Exception{

		JsonResult jsonResult = new JsonResult();

		try{
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
			setting.setMbrId(loginInfo.getMbrId());
			settingService.updateRange(setting);
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

//	@RequestMapping("/deleteFvrtLoc")
//	@ResponseBody
//	public Object deleteFvrtLoc(int fvrtLocNo)throws Exception{
//		JsonResult jsonResult = new JsonResult();
//		try {
//			settingService.removeFvrtLoc(fvrtLocNo);
//			jsonResult.setStatus("success");
//
//
//		} catch (Throwable e) {
//			StringWriter out = new StringWriter();
//			e.printStackTrace(new PrintWriter(out));
//
//			jsonResult.setStatus("fail");
//			jsonResult.setData(out.toString());
//		}
//		return jsonResult;
//	}

	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(SessionStatus status) throws Exception {
		System.out.println("logout()");
		status.setComplete();
		JsonResult jsonResult = new JsonResult();
		jsonResult.setStatus("success");

		return jsonResult;
	}
*/	
}

