package com.shiro.controller;

import com.shiro.pojo.User;
import com.shiro.service.impl.LoginServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
    public String login(String userName) {
        User user = new LoginServiceImpl().getUserByName(userName);
        if (StringUtils.isEmpty(user)){
            return "没有该用户！";
        }
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
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
