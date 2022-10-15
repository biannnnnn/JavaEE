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
        List<User> userList = sqlSession.selectList("findUserByUsername", "��");
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println("������" + u.getUsername());
            System.out.println("�Ա�" + u.getGender());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("���գ�" + sdf.format(u.getBirthday()));
            System.out.println("���ڵأ�" + u.getProvince() + u.getCity());
            System.out.println();
        }
        sqlSession.close();
    }

    @Test
    public void TestSelectUserInfo() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        User user = sqlSession.selectOne("findUserById", 1);
        System.out.println("������" + user.getUsername());
        System.out.println("�Ա�" + user.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("���գ�" + sdf.format(user.getBirthday()));
        System.out.println("���ڵأ�" + user.getProvince() + user.getCity());
        sqlSession.close();
    }

    @Test
    public void TestInsert() throws IOException, ParseException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        User user = new User();
        user.setUsername("�ߵ���");
        user.setGender("��");
        user.setPassword("88888888");
        user.setEmail("2877@qq.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("2002-05-11"));
        user.setProvince("����ʡ");
        user.setCity("֣����");
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
        user.setUsername("����");
        sqlSession.update("updateUsername", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
