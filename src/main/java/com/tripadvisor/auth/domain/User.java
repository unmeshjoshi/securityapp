package com.tripadvisor.auth.domain;

import java.util.List;

public class User
{
    private String name;
    List<String> permissions;

    public User(String name, List<String> permissions)
    {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getPermissionNames() {
        String permissionString= "";
        for (String p:permissions) {
            permissionString = permissionString + "," + p;
        }
        return permissionString;
    }
}
