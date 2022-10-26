package com.bdx.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.entity.Fruit;
import com.bdx.backend.mapper.FruitMapper;
import com.bdx.backend.service.FruitService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 19:57
 */
@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public Boolean create(Fruit fruit) {
        return fruitMapper.insert(fruit) > 0;
    }

    @Override
    public Boolean delete(int id) {
        return fruitMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Fruit fruit) {
        return fruitMapper.updateById(fruit) > 0;
    }

    @Override
    public Fruit getById(int id) {
        return fruitMapper.selectById(id);
    }

    @Override
    public List<Fruit> getAll() {
        return fruitMapper.selectList(null);
    }

    @Override
    public IPage<Fruit> getPage(int currentPage, int pageSize, Fruit fruit) {
        LambdaQueryWrapper<Fruit> lqw = new LambdaQueryWrapper();
        lqw.like(Strings.isNotEmpty(fruit.getName()), Fruit::getName, fruit.getName());
        lqw.like(fruit.getPrice() != 0, Fruit::getPrice, fruit.getPrice());
        lqw.like(Strings.isNotEmpty(fruit.getLocality()), Fruit::getLocality, fruit.getLocality());
        IPage page = new Page(currentPage, pageSize);
        return fruitMapper.selectPage(page, lqw);
    }

    @Override
    public List<Accessory> getAccessories(int fruitid) {
        return fruitMapper.getAccessories(fruitid);
    }
}
