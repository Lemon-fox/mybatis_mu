package com.mybatis.dao;

import java.util.List;

import com.mybatis.po.OrdersCustom;

public interface UserMapperOrders {
	
	//查询订单，关联查询用户信息
	public List<OrdersCustom> findOrdersUser() throws Exception;
	//查询订单，关联查询用户信息,使用resultMap
	public List<OrdersCustom> findOrdersUserResultMap() throws Exception;



}
