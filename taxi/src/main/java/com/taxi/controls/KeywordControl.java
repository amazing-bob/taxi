package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.keyword.KeywordService;


@Controller
@RequestMapping("/keyword")
public class KeywordControl {
	@Autowired ServletContext sc;
	@Autowired KeywordService keywordService;
	

}
