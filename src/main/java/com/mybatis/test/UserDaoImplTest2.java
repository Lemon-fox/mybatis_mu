package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserMapper;
import com.mybatis.po.User;
import com.mybatis.po.UserQueryVo;

public class UserDaoImplTest2 {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建SqlSessionFactory
		String resource = "SqlMapConfig.xml";
		// 得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(2);
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday());
		System.out.println(user.getSex());
		System.out.println(user.getAddress());
		System.out.println(user);
	}
	@Test
    public void testFindUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByName("ackles");
        sqlSession.close();
        System.out.println(list);
    }
	
	//v1.5
	@Test
	public void testFindUserList() throws Exception {

	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    //创建UserMapper对象，mybatis自动生成mapper代理对象
	    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

	    //创建包装对象，设置查询条件
	    UserQueryVo userQueryVo = new UserQueryVo();
	    User user = new User();
	    user.setSex("男");
	    user.setUsername("ackles");
	    userQueryVo.setUser(user);

	    //调用userMapper的方法
	    List<User> list = userMapper.findUserList(userQueryVo);
	    System.out.println(list);
	}
	@Test
	public void testFindUserByIdResultMap() throws Exception {

	SqlSession sqlSession = sqlSessionFactory.openSession();
	//创建UserMapper对象，mybatis自动生成mapper代理对象
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

	User user = userMapper.findUserByIdResultMap(2);
	System.out.println(user.getUsername());
//	System.out.println(user.getSex());
	System.out.println(user.getSex());
	System.out.println(user.getAddress());
	System.out.println(user);

	}


}
