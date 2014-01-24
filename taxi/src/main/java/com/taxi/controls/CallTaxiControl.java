package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.calltaxi.CallTaxiService;


@Controller
@RequestMapping("/callTaxi")
public class CallTaxiControl {
	@Autowired ServletContext sc;
	@Autowired CallTaxiService callTaxiService;
	

}
