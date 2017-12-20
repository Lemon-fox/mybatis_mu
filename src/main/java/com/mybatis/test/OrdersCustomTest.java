package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.UserMapperOrders;
import com.mybatis.po.Orders;
import com.mybatis.po.OrdersCustom;

public class OrdersCustomTest {
	
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
	public void testUserMapperOrders() throws Exception {
	//获取sqlSessionFactory的代码省略了
	SqlSession sqlSession = sqlSessionFactory.openSession();
	UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
	List<OrdersCustom> list = userMapperOrders.findOrdersUser();
	System.out.println(list);
	}
	@Test
	public void testUserMapperOrdersResultMap() throws Exception {
	SqlSession sqlSession = sqlSessionFactory.openSession();
	UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
	List<OrdersCustom> list = userMapperOrders.findOrdersUserResultMap();
	System.out.println(list);
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
	SqlSession sqlSession = sqlSessionFactory.openSession();
	UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
	List<Orders> list = userMapperOrders.findOrdersAndOrderDetailResultMap();
	System.out.println(list);
	}




}
