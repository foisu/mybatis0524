package com.peter.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.peter.mybatis.po.User;
import com.peter.mybatis.po.UserCustom;
import com.peter.mybatis.po.UserQueryVo;

public class UserMapperTest {

	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource="SqlMapConfig.xml";
		InputStream inputStream= Resources.getResourceAsStream(resource);
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(1);
		
		System.out.println(user);
		
		
	}
	@Test
	public void testFindUserByName() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> list=userMapper.findUserByName("小");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserList() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo =new UserQueryVo();
		UserCustom custom=new UserCustom();
		custom.setSex("1");
		custom.setUsername("小");
		userQueryVo.setUserCustom(custom);
		
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(22);
		ids.add(16); 
		userQueryVo.setIds(ids);
		
		
		
		
		List<UserCustom> list=userMapper.findUserList(userQueryVo);
		
		System.out.println(list);
		
		//for (UserCustom user : list) {
		//	System.out.println(user);
		//}
	}

}
