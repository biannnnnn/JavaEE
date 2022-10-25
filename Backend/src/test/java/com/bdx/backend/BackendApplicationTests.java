package com.bdx.backend;

import com.bdx.backend.mapper.RetailerMapper;
import com.bdx.backend.service.RetailerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private RetailerService retailerService;

    @Autowired
    private RetailerMapper retailerMapper;

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
}
