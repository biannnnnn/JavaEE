package com.bdx.backend.controller.utils;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION: 表现层数据一致性处理
 * @USER: bian
 * @DATE: 2022/10/25 15:38
 */
public class Result {
    private Boolean flag;
    private Object data;

    public Result() {

    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
