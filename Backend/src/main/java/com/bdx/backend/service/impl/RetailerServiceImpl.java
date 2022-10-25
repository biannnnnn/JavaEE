package com.bdx.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdx.backend.entity.Retailer;
import com.bdx.backend.mapper.RetailerMapper;
import com.bdx.backend.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 21:24
 */
@Service
public class RetailerServiceImpl implements RetailerService {
    @Autowired
    private RetailerMapper retailerMapper;

    @Override
    public Boolean create(Retailer retailer) {
        return retailerMapper.insert(retailer) > 0;
    }

    @Override
    public Boolean delete(int id) {
        return retailerMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Retailer retailer) {
        return retailerMapper.updateById(retailer) > 0;
    }

    @Override
    public Retailer getById(int id) {
        return retailerMapper.selectById(id);
    }

    @Override
    public List<Retailer> getAll() {
        return retailerMapper.selectList(null);
    }

    @Override
    public IPage<Retailer> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return retailerMapper.selectPage(page, null);
    }
}
