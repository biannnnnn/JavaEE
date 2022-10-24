package com.fruitsalesplatform.service;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE作业
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 17:07
 */
public interface UserService {
    public User get(Serializable id);  // 只查询一个数据，常用于修改
    public List<User> find(Map map);  // 根据条件查询多个结果
    public void insert(User user);  // 插入，用实体作为参数
    public void update(User user);  // 修改，用实体作为参数
    public void deleteById(Serializable id);  // 按id删除，删除一条
    public void delete(Serializable[] ids);  // 批量删除
}
