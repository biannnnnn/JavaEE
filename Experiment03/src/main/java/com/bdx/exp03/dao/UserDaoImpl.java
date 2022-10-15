package com.bdx.exp03.dao;

import com.bdx.exp03.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User findUserById1(int id) throws Exception {
        // 继承SqlSessionDaoSupport类，通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("findUserById", id);
        return user;
    }
}
