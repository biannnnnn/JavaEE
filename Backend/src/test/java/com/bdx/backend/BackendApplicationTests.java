package com.bdx.backend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdx.backend.entity.User;
import com.bdx.backend.mapper.FruitMapper;
import com.bdx.backend.mapper.RetailerMapper;
import com.bdx.backend.mapper.UserMapper;
import com.bdx.backend.service.FruitService;
import com.bdx.backend.service.RetailerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private RetailerService retailerService;

    @Autowired
    private RetailerMapper retailerMapper;

    @Autowired
    private FruitMapper fruitMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FruitService fruitService;

    @Test
    public void getAllTest() {
        retailerService.getAll();
        // retailerMapper.selectList(null);
    }

    @Test
    public void getById() {
        retailerService.getById(1).toString();
        // retailerMapper.selectById(1);
    }

    @Test
    public void getById2() {
        //fruitMapper.selectById(1);
        fruitService.getById(1);
    }

    @Test
    public void getAccessories() {
        System.out.println("-------");
        //fruitMapper.getAccessories(2).toString();
        fruitService.getAccessories(2);
        System.out.println("-------");
    }

    @Test
    public void selectByUsername() {
        System.out.println("wd");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, "biand");
        List<User> userList = userMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(userList)) {
            System.out.println("null");
        } else {
            userList.get(0).toString();
        }
    }
}
