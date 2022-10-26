package com.bdx.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.vo.FruitAccessoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 22:07
 */
@Mapper
public interface AccessoryMapper extends BaseMapper<Accessory> {
}
