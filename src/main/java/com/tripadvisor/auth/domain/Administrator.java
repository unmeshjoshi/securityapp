package com.tripadvisor.auth.domain;

import java.util.List;

public class Administrator
{
    String name;
    List<Application> applications;
    public Administrator(String name, List<Application> applications) {
        this.name = name;
        this.applications = applications;
    }

    public String getName() {
        return name;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public String getApplicationNames() {
        String names = "";
        for(Application application:applications) {
            names = names + ", " + application.getName();
        }
        return names;
    }
}
