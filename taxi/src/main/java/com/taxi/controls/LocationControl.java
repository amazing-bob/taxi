package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.location.LocationService;


@Controller
@RequestMapping("/location")
public class LocationControl {
	@Autowired ServletContext sc;
	@Autowired LocationService locationService;
	

}
