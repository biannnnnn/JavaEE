package com.bdx.backend.controller;

import com.bdx.backend.controller.utils.Result;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 22:12
 */
@RestController
@RequestMapping("/accessory")
public class AccessoryController {
    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public Result getAll() {
        return new Result(true, accessoryService.getAll());
    }

    @PostMapping
    public Result create(@RequestBody Accessory accessory) {
        return new Result(accessoryService.create(accessory));
    }

    @PutMapping
    public Result update(@RequestBody Accessory accessory) {
        return new Result(accessoryService.update(accessory));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return new Result(accessoryService.delete(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable int id) {
        return new Result(true, accessoryService.getById(id));
    }
}
