package com.bdx.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.entity.Retailer;
import com.bdx.backend.service.RetailerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 21:43
 */
@RestController
@RequestMapping("/retailer")
public class RetailerController {
    @Autowired
    private RetailerService retailerService;

    @GetMapping
    public List<Retailer> getAll() {
        return retailerService.getAll();
    }

    @PostMapping
    public Boolean create(@RequestBody Retailer retailer) {
        return retailerService.create(retailer);
    }

    @PutMapping
    public Boolean update(@RequestBody Retailer retailer) {
        return retailerService.update(retailer);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable int id) {
        return retailerService.delete(id);
    }

    @GetMapping("{id}")
    public Retailer getById(@PathVariable int id) {
        return retailerService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Retailer> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return retailerService.getPage(currentPage, pageSize);
    }
}
