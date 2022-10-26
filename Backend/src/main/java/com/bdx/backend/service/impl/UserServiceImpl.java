package com.bdx.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdx.backend.entity.User;
import com.bdx.backend.mapper.UserMapper;
import com.bdx.backend.req.UserLoginReq;
import com.bdx.backend.req.UserSaveReq;
import com.bdx.backend.resp.UserLoginResp;
import com.bdx.backend.service.UserService;
import com.bdx.backend.utils.CopyUtil;
import com.bdx.backend.utils.SnowFlakeId;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlakeId snowFlakeId;

    @Override
    public User register(UserSaveReq userSaveReq) {
        User user = CopyUtil.copy(userSaveReq, User.class);
        System.out.println(user.toString());
        if(userSaveReq.getId() == 0) {
            System.out.println("ddd");
            User userDb = selectByUsername(userSaveReq.getUsername());
            if(ObjectUtils.isEmpty(userDb)) {
                user.setId((int) snowFlakeId.nextId());
                System.out.println("dwa");
                System.out.println(user.toString());
                userMapper.insert(user);
                return null;
            } else {
                return userDb;
            }
        } else {
            return user;
        }
    }

    @Override
    public UserLoginResp login(UserLoginReq userLoginReq) {
        User userDb = selectByUsername(userLoginReq.getUsername());
        System.out.println("----");
        System.out.println(userDb);
        System.out.println("----");
        if (ObjectUtils.isEmpty(userDb)) {
            // 用户不存在
            return null;
        } else {
            if (userLoginReq.getPassword().equals(userDb.getPassword())) {
                // 登陆成功
                UserLoginResp resp = CopyUtil.copy(userDb, UserLoginResp.class);
                return resp;
            } else {
                return null;
            }
        }
    }

    // 查询用户名是否被注册
    public User selectByUsername(String username) {
        System.out.println(username);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, username);
        List<User> userList = userMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }
}
