package com.bdx.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.controller.utils.Result;
import com.bdx.backend.entity.Contract;
import com.bdx.backend.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/26 12:13
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public Result getAll() {
        return new Result(true, contractService.getAll());
    }

    @PostMapping
    public Result create(@RequestBody Contract contract) {
        return new Result(contractService.create(contract));
    }

    @PutMapping
    public Result update(@RequestBody Contract contract) {
        return new Result(contractService.update(contract));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return new Result(contractService.delete(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable int id) {
        return new Result(true, contractService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Contract contract) {
        IPage<Contract> page = contractService.getPage(currentPage, pageSize, contract);
        if(currentPage > page.getPages()) {
            page = contractService.getPage((int)page.getPages(), pageSize, contract);
        }
        return new Result(true, page);
    }
}
