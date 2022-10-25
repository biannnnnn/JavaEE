package com.bdx.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.entity.Retailer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 21:20
 */
@Service
public interface RetailerService {
    Boolean create(Retailer retailer);
    Boolean delete(int id);
    Boolean update(Retailer retailer);
    Retailer getById(int id);
    List<Retailer> getAll();
    IPage<Retailer> getPage(int currentPage, int pageSize, Retailer retailer);
}
