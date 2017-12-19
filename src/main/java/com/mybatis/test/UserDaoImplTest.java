package com.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.po.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		//创建SqlSessionFactory
		String resource = "SqlMapConfig.xml";
		//得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		//创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	@Test
	public void testFindUserById() throws Exception {
	//创建UserDao的对象
	UserDao userDao = new UserDaoImpl(sqlSessionFactory);
	System.out.println(userDao.findUserById(1)+"-------");
	User aaa = userDao.findUserById(1);	
	System.out.println(aaa.getUsername());
	System.out.println(aaa.getBirthday());
	System.out.println(aaa.getSex());
	System.out.println(aaa.getAddress());
	}


}
