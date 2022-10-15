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
        // 通过配置资源对象获取userDao对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        // 调用UserDao的方法
        User user = userDao.findUserById1(1);
        // 输出用户信息
        System.out.println(user.getId()  + ":" + user.getUsername());
    }
}
