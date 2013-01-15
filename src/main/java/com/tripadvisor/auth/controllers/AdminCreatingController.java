package com.tripadvisor.auth.controllers;

import com.tripadvisor.auth.domain.Administrator;
import com.tripadvisor.auth.domain.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminCreatingController {
    private static List<Administrator> administrators = new ArrayList<Administrator>();

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("administrators", administrators);
        model.addAttribute("applications", ApplicationCreatingController.applications);
        return "administrators";
    }

    @RequestMapping(value = "/add-admin", method = RequestMethod.POST)
    public String addApplication(@RequestParam(required = true) String name,
                                               @RequestParam(required = true) String applicationNames,
                                               @ModelAttribute("model")ModelMap model,
                                               HttpServletResponse response,
                                               HttpServletRequest request) {
        List<Application> applications = getApplications(applicationNames);
        administrators.add(new Administrator(name, applications));
        model.addAttribute("administrators", administrators);
        return "redirect:/admins";
    }

    private List<Application> getApplications(String applications) {
        List<String> applicationNames = Arrays.asList(applications.split(","));
        List<Application> apps = new ArrayList<Application>();
        for(String applicationName:applicationNames) {
            for(Application application: ApplicationCreatingController.applications) {
                if (application.getName().equals(applicationName)){
                    apps.add(application);
                }
            }
        }
        return apps;
    }

    public static Administrator getAdmin(String name) {
        for(Administrator administrator:administrators) {
            if (administrator.getName().equals(name)) {
                return administrator;
            }
        }
        throw new IllegalArgumentException("no admin found with name " + name);
    }


}

