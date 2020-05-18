package com.shiro.pojo;

import java.util.Set;

/**
 * @author fuqiangxin
 * @Classname: User
 * @Description: 用户实体
 * @date 2020/5/18 08:20
 */
public class User {
    private String id;
    private String userName;
    private String password;
    private Set<Role> roles;

    public User() {
    }

    public User(String id, String userName, String password, Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
