package com.mybatis.dao;

import java.util.List;

import com.mybatis.po.User;

//mapper接口，相当于dao接口
public interface UserMapper {
	
	//根据id查询用户信息
    public User findUserById(int id) throws Exception;
    //根据用户名模糊查询
    public List<User> findUserByName(String name) throws Exception;
    //添加用户信息
    public void insertUser(User user) throws Exception;
    //删除用户信息
    public void deleteUser(int id) throws Exception;
    //更新用户信息
    public void updateUser(User user) throws Exception;

}