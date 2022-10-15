package com.bdx.exp03.test;

import com.bdx.exp03.dao.UserDao;
import com.bdx.exp03.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testFindUserByID() throws Exception {
        // ͨ��������Դ�����ȡuserDao����
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        // ����UserDao�ķ���
        User user = userDao.findUserById1(1);
        // ����û���Ϣ
        System.out.println(user.getId()  + ":" + user.getUsername());
    }
}
