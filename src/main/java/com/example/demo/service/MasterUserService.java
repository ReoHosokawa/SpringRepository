package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.MasterUserMapper;

@Service
public class MasterUserService {
	
	@Autowired
	private MasterUserMapper masterUserMapper;
	
	@Transactional
	public String findUserId(String id, String password) {
		return masterUserMapper.findUserId(id, password);
	}

}
