package com.bdx.backend.service;

import com.bdx.backend.entity.User;
import com.bdx.backend.req.UserLoginReq;
import com.bdx.backend.req.UserSaveReq;
import com.bdx.backend.resp.UserLoginResp;
import org.springframework.stereotype.Service;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:28
 */
@Service
public interface UserService {
    User register(UserSaveReq userSaveReq);

    UserLoginResp login(UserLoginReq userLoginReq);
}