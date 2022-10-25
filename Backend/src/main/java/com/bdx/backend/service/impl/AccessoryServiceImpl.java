package com.bdx.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.mapper.AccessoryMapper;
import com.bdx.backend.service.AccessoryService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 22:10
 */
@Service
public class AccessoryServiceImpl implements AccessoryService {
    @Autowired
    private AccessoryMapper accessoryMapper;

    @Override
    public Boolean create(Accessory accessory) {
        return accessoryMapper.insert(accessory) > 0;
    }

    @Override
    public Boolean delete(int id) {
        return accessoryMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Accessory accessory) {
        return accessoryMapper.updateById(accessory) > 0;
    }

    @Override
    public Accessory getById(int id) {
        return accessoryMapper.selectById(id);
    }

    @Override
    public List<Accessory> getAll() {
        return accessoryMapper.selectList(null);
    }
}
