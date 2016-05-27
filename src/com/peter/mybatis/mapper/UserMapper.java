package com.peter.mybatis.mapper;

import java.util.List;

import com.peter.mybatis.po.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;

	public List<User> findUserByName(String username) throws Exception;
	

}
