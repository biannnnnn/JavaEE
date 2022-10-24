package com.bdx.backend.service;

import com.bdx.backend.req.UserLoginReq;
import com.bdx.backend.req.UserSaveReq;
import com.bdx.backend.resp.UserLoginResp;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:28
 */
public interface UserService {
    void register(UserSaveReq userSaveReq);

    UserLoginResp login(UserLoginReq userLoginReq);
}