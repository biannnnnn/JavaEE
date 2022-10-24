package com.bdx.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdx.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:33
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
