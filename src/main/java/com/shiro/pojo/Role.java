package com.shiro.pojo;

import java.util.Set;

/**
 * @author fuqiangxin
 * @Classname: Role
 * @Description: 角色实体
 * @date 2020/5/18 08:18
 */
public class Role {
    private String id;
    private String roleName;
    private Set<Permissions> permissions;

    public Role() {
    }

    public Role(String id, String roleName, Set<Permissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
