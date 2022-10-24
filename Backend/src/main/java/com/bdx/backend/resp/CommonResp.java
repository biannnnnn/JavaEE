package com.bdx.backend.resp;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/24 14:53
 */
public class CommonResp<T> {

    // 业务上的成功与失败
    private Boolean success = true;

    // 返回信息
    private String message;

    // 返回数据类型，自定义类型
    private T content;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
