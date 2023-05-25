package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MasterItemName;
import com.example.demo.mapper.MasterItemNameMapper;

@Service
public class MasterItemNameService {

	@Autowired
	private MasterItemNameMapper masterItemNameMapper;

	@Transactional
	public List<MasterItemName> findAll() {
		return masterItemNameMapper.findAll();
	}

	@Transactional
	public MasterItemName findOne(Long id) {
		return masterItemNameMapper.findOne(id);
	}

	@Transactional
	public int findNameCount(String name) {
		return masterItemNameMapper.findNameCount(name);
	}
}
