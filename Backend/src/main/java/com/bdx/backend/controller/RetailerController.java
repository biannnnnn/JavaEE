package com.bdx.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.controller.utils.Result;
import com.bdx.backend.entity.Retailer;
import com.bdx.backend.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 21:43
 */
@RestController
@RequestMapping("/retailers")
public class RetailerController {
    @Autowired
    private RetailerService retailerService;

    @GetMapping
    public Result getAll() {
        return new Result(true, retailerService.getAll());
    }

    @PostMapping
    public Result create(@RequestBody Retailer retailer) {
        return new Result(retailerService.create(retailer));
    }

    @PutMapping
    public Result update(@RequestBody Retailer retailer) {
        return new Result(retailerService.update(retailer));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return new Result(retailerService.delete(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable int id) {
        return new Result(true, retailerService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Retailer retailer) {
        System.out.println(retailer);
        IPage<Retailer> page = retailerService.getPage(currentPage, pageSize, retailer);
        if(currentPage > page.getPages()) {
            page = retailerService.getPage((int)page.getPages(), pageSize, retailer);
        }
        return new Result(true, page);
    }
}
