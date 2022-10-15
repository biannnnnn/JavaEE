package com.bdx.exp03.test;

import com.bdx.exp03.mapper.UserQueryMapper;
import com.bdx.exp03.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        // ͨ��������Դ�����ȡuserDao����
        UserQueryMapper userQueryMapper = (UserQueryMapper) applicationContext.getBean("userQueryMapper");
        // ����UserDao����
        User user = userQueryMapper.findUserById(1);
        System.out.println(user.getId() + ":" + user.getUsername());
    }
}
