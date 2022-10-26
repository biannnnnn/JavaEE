package com.bdx.backend.controller;

import com.bdx.backend.controller.utils.Result;
import com.bdx.backend.entity.User;
import com.bdx.backend.req.UserLoginReq;
import com.bdx.backend.req.UserSaveReq;
import com.bdx.backend.resp.CommonResp;
import com.bdx.backend.resp.UserLoginResp;
import com.bdx.backend.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    private Result register(@RequestBody UserSaveReq userSaveReq) {
        userSaveReq.setPassword(DigestUtils.md5DigestAsHex(userSaveReq.getPassword().getBytes()));
        Result result = new Result();
        User user = userService.register(userSaveReq);
        if (user == null) {
            result.setFlag(false);
        }
        return result;
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginReq userLoginReq) {
        userLoginReq.setPassword(DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes()));
        Result result = new Result();
        UserLoginResp loginResp = userService.login(userLoginReq);
        if (loginResp == null) {
            result.setFlag(false);
        } else {
            result.setData(loginResp);
            result.setFlag(true);
        }
        return result;
    }
}
