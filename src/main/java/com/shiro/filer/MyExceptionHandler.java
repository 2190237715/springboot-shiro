package com.shiro.filer;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
/**
 * @author fuqiangxin
 * @Classname: MyExceptionHandler
 * @Description: 拦截异常
 * @date 2020/5/18 10:05
 */
public class MyExceptionHandler {


    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        return "没有通过权限验证！";
    }
}
