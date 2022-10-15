package com.bdx.exp01.test;

import com.bdx.exp01.dataSource.DataConnection;
import com.bdx.exp01.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyTest {

    public DataConnection dataConnection = new DataConnection();

    @Test
    public void TestFuzzySearch() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        List<User> userList = sqlSession.selectList("findUserByUsername", "丽");
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println("姓名：" + u.getUsername());
            System.out.println("性别：" + u.getGender());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("生日：" + sdf.format(u.getBirthday()));
            System.out.println("所在地：" + u.getProvince() + u.getCity());
            System.out.println();
        }
        sqlSession.close();
    }

    @Test
    public void TestSelectUserInfo() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        User user = sqlSession.selectOne("findUserById", 1);
        System.out.println("姓名：" + user.getUsername());
        System.out.println("性别：" + user.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("生日：" + sdf.format(user.getBirthday()));
        System.out.println("所在地：" + user.getProvince() + user.getCity());
        sqlSession.close();
    }

    @Test
    public void TestInsert() throws IOException, ParseException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        User user = new User();
        user.setUsername("边帝行");
        user.setGender("男");
        user.setPassword("88888888");
        user.setEmail("2877@qq.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("2002-05-11"));
        user.setProvince("河南省");
        user.setCity("郑州市");
        sqlSession.insert("insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestDelete() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        sqlSession.delete("deleteUser", 6);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestUpdate() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        User user = new User();
        user.setId(4);
        user.setUsername("李丽");
        sqlSession.update("updateUsername", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
