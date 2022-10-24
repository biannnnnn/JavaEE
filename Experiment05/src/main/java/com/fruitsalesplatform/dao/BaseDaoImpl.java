package com.fruitsalesplatform.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE作业
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 10:38
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private String ns;  // 命名空间

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    @Override
    public T get(Serializable id) {
        return null;
    }

    @Override
    public List find(Map map) {
        return null;
    }

    @Override
    public void insert(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void delete(Serializable id) {

    }
}
