package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MasterVendor;
import com.example.demo.mapper.MasterVendorMapper;

@Service
public class MasterVendorService {

	@Autowired
	private MasterVendorMapper masterVendorMapper;
	
	@Transactional
	public List<MasterVendor> findAll() {
		return masterVendorMapper.findAll();
	}
	
	@Transactional
	public MasterVendor findOne(Long id) {
		return masterVendorMapper.findOne(id);
	}
	
	@Transactional
	public int findNameCount(String name) {
		return masterVendorMapper.findNameCount(name);
	}
}
