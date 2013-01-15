package com.tripadvisor.auth.controllers;

import com.tripadvisor.auth.domain.Administrator;
import com.tripadvisor.auth.domain.User;
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
public class UserPermissionController {

    static List<User> users = new ArrayList<User>();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(@ModelAttribute("model") ModelMap model,
                                      HttpServletResponse response,
                                      HttpServletRequest request) {

        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/user-permissions", method = RequestMethod.GET)
    public String userPermissionsForm(@ModelAttribute("model") ModelMap model,
                                      HttpServletResponse response,
                                      HttpServletRequest request) {

        Administrator admin = (Administrator) request.getSession().getAttribute("admin");
        model.addAttribute("permissions", admin.getApplications().get(0).permissionList());
        model.addAttribute("admin", admin);
        model.addAttribute("users", getUersFromLdap(admin));
        return "userpermissions";
    }

    @RequestMapping(value = "/add-permissions", method = RequestMethod.POST)
    public String addPermissions(@RequestParam(required = true) String userName,
                                 @RequestParam(required = true) String permission,
                                 @ModelAttribute("model") ModelMap model,
                                 HttpServletResponse response,
                                 HttpServletRequest request) {


        users.add(new User(userName, Arrays.asList(permission.split(","))));
        return "redirect:/users";

    }

    private List<String> getUersFromLdap(Administrator admin) {
        return Arrays.asList("user1", "user2");
    }
}
