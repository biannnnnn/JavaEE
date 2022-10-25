package com.bdx.backend.service;

import com.bdx.backend.entity.Accessory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 22:08
 */
@Service
public interface AccessoryService {
    Boolean create(Accessory accessory);
    Boolean delete(int id);
    Boolean update(Accessory accessory);
    Accessory getById(int id);
    List<Accessory> getAll();
}
