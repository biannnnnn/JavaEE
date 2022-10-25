package com.bdx.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.entity.Fruit;
import com.bdx.backend.entity.Retailer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 19:55
 */
@Service
public interface FruitService {
    Boolean create(Fruit fruit);
    Boolean delete(int id);
    Boolean update(Fruit fruit);
    Fruit getById(int id);
    List<Fruit> getAll();
    IPage<Fruit> getPage(int currentPage, int pageSize, Fruit fruit);
}
