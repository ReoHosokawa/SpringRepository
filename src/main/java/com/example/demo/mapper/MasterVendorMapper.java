package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MasterVendor;

@Mapper
public interface MasterVendorMapper {
	List<MasterVendor> findAll();

	MasterVendor findOne(Long id);

	int findNameCount(String name);
}
