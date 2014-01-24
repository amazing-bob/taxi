package com.taxi.services.calltaxi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.dao.calltaxi.CallCompDao;


@Service
public class CallTaxiServiceImpl implements CallTaxiService {
	@Autowired CallCompDao callCompDao;
	
}
