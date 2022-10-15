package com.bdx.exp03.dao;

import com.bdx.exp03.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User findUserById1(int id) throws Exception {
        // �̳�SqlSessionDaoSupport�࣬ͨ��this.getSqlSession()�õ�sqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("findUserById", id);
        return user;
    }
}
