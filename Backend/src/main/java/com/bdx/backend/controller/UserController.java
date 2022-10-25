package com.bdx.backend.controller;

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
    private CommonResp register(@RequestBody UserSaveReq userSaveReq) {
        userSaveReq.setPassword(DigestUtils.md5DigestAsHex(userSaveReq.getPassword().getBytes()));
        CommonResp resp = new CommonResp();
        userService.register(userSaveReq);
        return resp;
    }

    @PostMapping("/login")
    public CommonResp login(@RequestBody UserLoginReq userLoginReq) {
        userLoginReq.setPassword(DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes()));
        CommonResp resp = new CommonResp();
        UserLoginResp loginResp = userService.login(userLoginReq);
        resp.setContent(loginResp);
        return resp;
    }
}
