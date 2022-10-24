package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT_NAME: JavaEE作业
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 16:45
 */
@Repository  // 为了包在扫描的时候这个Dao被扫描到
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setNs("com.fruitsalesplatform.mapper.UserMapper");
    }
}
