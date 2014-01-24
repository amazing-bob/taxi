package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.blacklist.BlackListService;


@Controller
@RequestMapping("/blackList")
public class BlackListControl {
	@Autowired ServletContext sc;
	@Autowired BlackListService blackListService;
	

}
