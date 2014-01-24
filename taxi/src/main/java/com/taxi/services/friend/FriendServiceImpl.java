package com.taxi.services.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.friend.FrndDao;


@Service
public class FriendServiceImpl implements FriendService {
	@Autowired FrndDao FrndDao;
	
}
