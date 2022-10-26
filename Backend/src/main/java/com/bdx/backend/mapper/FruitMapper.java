package com.bdx.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdx.backend.entity.Accessory;
import com.bdx.backend.entity.Fruit;
import com.bdx.backend.vo.FruitAccessoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 19:55
 */
@Mapper
public interface FruitMapper extends BaseMapper<Fruit> {
    @Select("SELECT accessory.name, accessory.price, accessory.createTime FROM commodities, accessory WHERE accessory.`fruitid` = commodities.fruitid AND commodities.fruitid = #{fruitid}")
    List<Accessory> getAccessories(Integer fruitid);
}
