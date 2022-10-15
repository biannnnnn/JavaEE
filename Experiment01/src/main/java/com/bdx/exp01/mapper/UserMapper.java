package com.bdx.exp01.mapper;

import com.bdx.exp01.pojo.User;

public interface UserMapper {

    User findUserByUsername(String value);
    User findUserById(int id);
    void insertUser(User user);
    void deleteUser(int id);
    void updateUsername(User user);
}
