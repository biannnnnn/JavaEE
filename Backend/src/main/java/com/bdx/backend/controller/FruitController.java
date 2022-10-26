package com.bdx.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdx.backend.controller.utils.Result;
import com.bdx.backend.entity.Fruit;
import com.bdx.backend.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 20:03
 */
@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping
    public Result getAll() {
        return new Result(true, fruitService.getAll());
    }

    @PostMapping
    public Result create(@RequestBody Fruit fruit) {
        return new Result(fruitService.create(fruit));
    }

    @PutMapping
    public Result update(@RequestBody Fruit fruit) {
        return new Result(fruitService.update(fruit));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return new Result(fruitService.delete(id));
    }

//    @GetMapping("{id}")
//    public Result getById(@PathVariable int id) {
//        return new Result(true, fruitService.getById(id));
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Fruit fruit) {
        System.out.println("----");
        System.out.println(fruit);
        System.out.println("----");
        IPage<Fruit> page = fruitService.getPage(currentPage, pageSize, fruit);
        if(currentPage > page.getPages()) {
            page = fruitService.getPage((int)page.getPages(), pageSize, fruit);
        }
        return new Result(true, page);
    }

    @GetMapping("{id}")
    public Result getAccessories(@PathVariable int id) {
        System.out.println("----------------");
        System.out.println(id);
        System.out.println("-----------------");
        return new Result(true, fruitService.getAccessories(id));
    }
}
