package com.bdx.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdx.backend.entity.Contract;
import com.bdx.backend.mapper.ContractMapper;
import com.bdx.backend.service.ContractService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/26 12:01
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public Boolean create(Contract contract) {
        return contractMapper.insert(contract) > 0;
    }

    @Override
    public Boolean delete(int id) {
        return contractMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Contract contract) {
        return contractMapper.updateById(contract) > 0;
    }

    @Override
    public Contract getById(int id) {
        return contractMapper.selectById(id);
    }

    @Override
    public List<Contract> getAll() {
        return contractMapper.selectList(null);
    }

    @Override
    public IPage<Contract> getPage(int currentPage, int pageSize, Contract contract) {
        LambdaQueryWrapper<Contract> lqw = new LambdaQueryWrapper();
        lqw.like(Strings.isNotEmpty(contract.getBarcode()), Contract::getBarcode, contract.getBarcode());
        lqw.like(Strings.isNotEmpty(contract.getType()), Contract::getType, contract.getType());
        lqw.like(contract.getRetailerId() != 0, Contract::getRetailerId, contract.getRetailerId());
        IPage page = new Page(currentPage, pageSize);
        return contractMapper.selectPage(page, lqw);
    }
}
