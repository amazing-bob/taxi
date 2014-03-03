package com.taxi.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.services.black.BlackService;
import com.taxi.services.friend.FriendService;


@Controller
@RequestMapping("/friend")
public class FriendControl {
	@Autowired ServletContext sc;
	@Autowired FriendService friendService;
	

}
