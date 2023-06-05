package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MasterUserMapper {
	String findUserId(String id, String password);
}
