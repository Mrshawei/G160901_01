package com.ssm.dao;

import com.ssm.entity.User;

import java.util.List;

public interface UserDao {
    //查询所有用户的方法
    public List<User> findAllUser();
    public void addUser(User user);
}
