package com.bdx.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdx.backend.entity.Fruit;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 19:55
 */
@Mapper
public interface FruitMapper extends BaseMapper<Fruit> {
}
