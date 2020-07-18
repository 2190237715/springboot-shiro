package com.shiro.service.impl;

import com.shiro.pojo.Permissions;
import com.shiro.pojo.Role;
import com.shiro.pojo.User;
import com.shiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fuqiangxin
 * @Classname: LoginServiceImpl
 * @Description: 登陆实现接口层
 * @date 2020/5/18 08:25
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public User getUserByName(String userName) {
        return getMapByName(userName);
    }

    private User getMapByName(String name) {
        Permissions permissions1 = new Permissions("1", "save");
        Permissions permissions2 = new Permissions("2", "select");
        Permissions permissions3 = new Permissions("3", "delete");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions1);
        permissionsSet1.add(permissions2);
        permissionsSet1.add(permissions3);
        Set<Permissions> permissionsSet2 = new HashSet<>();
        permissionsSet2.add(permissions2);
        Role role1 = new Role("1", "admin", permissionsSet1);
        Role role2 = new Role("2", "other", permissionsSet2);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(role2);
        User xiaoxin = new User("1", "xiaoxin", "f744e04d0c8d72b82ec9c94f1b866698", roleSet1);
        User xiaoxia = new User("2", "xiaoxia", "b8af9e96f332f46e9905760e7dd4d8ad", roleSet2);
        Map<String, User> userMap = new HashMap<>();
        userMap.put(xiaoxin.getUserName(), xiaoxin);
        userMap.put(xiaoxia.getUserName(), xiaoxia);
        return userMap.get(name);
    }
}
