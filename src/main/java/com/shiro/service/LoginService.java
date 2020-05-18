package com.shiro.service;

import com.shiro.pojo.User;

/**
 * @author fuqiangxin
 * @Classname: LoginService
 * @Description: 登陆接口
 * @date 2020/5/18 08:23
 */
public interface LoginService {
    User getUserByName(String userName);
}
