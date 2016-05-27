package com.peter.mybatis.first;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.peter.mybatis.po.User;
import com.peter.mybatis.po.UserPo;

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
	
	//根据Id查询用户信息
		@Test
		public void insertUser() throws IOException{
			//创建会话工厂
			String resource="SqlMapConfig.xml";
			InputStream inputStream= Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

			//通过工厂得到SqlSession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			User user = new User();
			user.setAddress("苏州");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setUsername("abcd");
			
			//通过SqlSession操作数据库
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
			sqlSession.close();
		}
		
		
		//插入UserPo
				@Test
				public void insertUserPo() throws IOException{
					//创建会话工厂
					String resource="SqlMapConfig.xml";
					InputStream inputStream= Resources.getResourceAsStream(resource);
					SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

					//通过工厂得到SqlSession
					SqlSession sqlSession=sqlSessionFactory.openSession();
					
					UserPo userPo=new UserPo();
					userPo.setAddress("苏州");
					userPo.setBirthday(new Date());
					userPo.setSex("1");
					userPo.setUsername("abcd");
					
					//通过SqlSession操作数据库
					sqlSession.insert("test.insertUserPo", userPo);
					sqlSession.commit();
					sqlSession.close();
				}
	
	
				//根据Id删除用户信息
				@Test
				public void deleteUser() throws IOException{
					//创建会话工厂
					String resource="SqlMapConfig.xml";
					InputStream inputStream= Resources.getResourceAsStream(resource);
					SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

					//通过工厂得到SqlSession
					SqlSession sqlSession=sqlSessionFactory.openSession();
					//通过SqlSession操作数据库
					sqlSession.insert("test.deleteUser", 27);
					sqlSession.commit();
					sqlSession.close();
				}
				
				//根据Id更新用户信息
				@Test
				public void updateUser() throws IOException{
					//创建会话工厂
					String resource="SqlMapConfig.xml";
					InputStream inputStream= Resources.getResourceAsStream(resource);
					SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

					//通过工厂得到SqlSession
					SqlSession sqlSession=sqlSessionFactory.openSession();
					
					User user = new User();
					user.setId(28);
					user.setAddress("江苏苏州");
					user.setBirthday(new Date());
					user.setSex("2");
					user.setUsername("赵七");
					
					//通过SqlSession操作数据库
					sqlSession.insert("test.updateUser", user);
					sqlSession.commit();
					sqlSession.close();
				}

}
