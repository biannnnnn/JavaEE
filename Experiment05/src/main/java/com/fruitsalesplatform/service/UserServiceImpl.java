package com.fruitsalesplatform.service;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE作业
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 17:11
 */
@Service  // 为了包扫描的时候这个Service被扫描到
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<User> find(Map map) {
        return userDao.find(map);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(Serializable id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        userDao.delete(ids);
    }
}
