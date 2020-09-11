package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserService {

    //新增
    public void add(User user);

    //删除
    public void delete(Long id);

    //修改
    public void update(Long id,User user);

    //根据id查找
    public User findOne(Long id);

    //查询所有
    public List<User>findAll();
}
