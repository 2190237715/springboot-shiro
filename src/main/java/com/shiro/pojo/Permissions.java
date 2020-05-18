package com.shiro.pojo;

/**
 * @author fuqiangxin
 * @Classname: Permissions
 * @Description: 权限实体
 * @date 2020/5/18 08:14
 */
public class Permissions {
    private String id;
    private String permissionsName;


    public Permissions() {
    }

    public Permissions(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}
