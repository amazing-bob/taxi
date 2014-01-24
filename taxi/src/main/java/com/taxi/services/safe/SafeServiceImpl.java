package com.taxi.services.safe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.safe.SafeDao;


@Service
public class SafeServiceImpl implements SafeService {
	@Autowired SafeDao safeDao;
	
}
