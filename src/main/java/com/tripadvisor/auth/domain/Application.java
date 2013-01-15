package com.tripadvisor.auth.domain;

import java.util.Arrays;
import java.util.List;

public class Application
{
    private String name;
    private String permissions;

    public Application(String name, String permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> permissionList() {
        return Arrays.asList(permissions.split(","));
    }
}
