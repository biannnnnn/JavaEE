package com.fruitsalesplatform.entity;

/**
 * @PROJECT_NAME: JavaEE??ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 16:43
 */
public class User {
    private String userId;
    private String userName;
    private String password;
    private String name;
    private String telephone;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
