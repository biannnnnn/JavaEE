package com.bdx.exp03.mapper;

import com.bdx.exp03.po.User;

public interface UserQueryMapper {
    public User findUserById(int id) throws Exception;
}
