package com.peter.mybatis.mapper;

import java.util.List;

import com.peter.mybatis.po.User;
import com.peter.mybatis.po.UserCustom;
import com.peter.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;

	public List<User> findUserByName(String username) throws Exception;
	
	public List<UserCustom> findUserList(UserQueryVo userQueryvo) throws Exception;
	

}
