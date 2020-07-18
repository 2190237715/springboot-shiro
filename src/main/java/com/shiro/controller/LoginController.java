package com.shiro.controller;

import com.shiro.pojo.User;
import com.shiro.service.impl.LoginServiceImpl;
import com.shiro.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author fuqiangxin
 * @Classname: LoginController
 * @Description: 登陆控制类
 * @date 2020/5/18 09:53
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userName, String password) {
        // 密码MD5加密
        password = MD5Util.encrypt(userName, password);
        User user = new LoginServiceImpl().getUserByName(userName);
        if (StringUtils.isEmpty(user)) {
            return "没有该用户！";
        }
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(user.getUserName(), password);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return "没有该用户！";
        } catch (IncorrectCredentialsException e) {
            return "密码错误！";
        } catch (LockedAccountException e) {
            return "没有权限！";
        } catch (AuthenticationException e) {
            return "认证失败！";
        }
        return "login success";
    }

    //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("save")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }


}
