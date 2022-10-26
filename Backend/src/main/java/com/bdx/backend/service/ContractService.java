package com.bdx.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.entity.Contract;
import com.bdx.backend.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/26 12:01
 */
@Service
public interface ContractService {
    Boolean create(Contract contract);
    Boolean delete(int id);
    Boolean update(Contract contract);
    Contract getById(int id);
    List<Contract> getAll();
    IPage<Contract> getPage(int currentPage, int pageSize, Contract contract);
}
