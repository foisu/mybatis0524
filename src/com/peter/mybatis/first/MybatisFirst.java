package com.peter.mybatis.first;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.peter.mybatis.po.User;

public class MybatisFirst {
	//根据Id查询用户信息
	@Test
	public void findUserByIdTest() throws IOException{
		
		//创建会话工厂
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
		
		//通过工厂得到SqlSession
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//通过SqlSession操作数据库
		
		List<User> user=sqlSession.selectList("test.findUserByName", "小");
		System.out.println(user.toString());
		
		sqlSession.close();
	
	}
	
	

}
