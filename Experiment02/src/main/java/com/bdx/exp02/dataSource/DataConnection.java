package com.bdx.exp02.dataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DataConnection {

    //mybatis�����ļ�
    private String resource="mybatis-config.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
}
