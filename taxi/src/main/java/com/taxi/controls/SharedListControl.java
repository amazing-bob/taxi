package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.blacklist.BlackListService;
import com.taxi.services.sharedlist.SharedListService;


@Controller
@RequestMapping("/sharedList")
public class SharedListControl {
	@Autowired ServletContext sc;
	@Autowired SharedListService sharedListService;
	

}
