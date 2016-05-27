package com.peter.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.peter.mybatis.po.User;

public class UserDaoImpl implements UserDao {
	
	
	//需要
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user= sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		

	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.insertUser", id);
		sqlSession.commit();
		sqlSession.close();

	}

}
