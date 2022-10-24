package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT_NAME: JavaEE��ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 16:45
 */
@Repository  // Ϊ�˰���ɨ���ʱ�����Dao��ɨ�赽
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setNs("com.fruitsalesplatform.mapper.UserMapper");
    }
}
