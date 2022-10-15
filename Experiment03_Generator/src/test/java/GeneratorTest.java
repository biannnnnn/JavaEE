import com.bdx.exp03_gen.mapper.UserMapper;
import com.bdx.exp03_gen.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GeneratorTest {

    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void insertTest() throws ParseException {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        User user1 = new User();
        user1.setUsername("������");
        user1.setPassword("123qwe");
        user1.setGender("��");
        user1.setBirthday(sdf.parse("1992-01-01"));
        user1.setProvince("����");
        user1.setCity("����");
        user1.setEmail("leilei@126.com");
        userMapper.insert(user1);
        System.out.println("1.������һ����Ϊ��" + user1.getUsername() + "���û�");
    }
}
