package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MasterItemName;

@Mapper
public interface MasterItemNameMapper {
	List<MasterItemName> findAll();

	MasterItemName findOne(Long id);

	int findNameCount(String name);
}
