package com.tripadvisor.auth.controllers;


import com.tripadvisor.auth.domain.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminLoginController {

    @RequestMapping(value = "/admin-login", method = RequestMethod.GET)
    public String loginForm() {
        return "adminlogin";

    }

    @RequestMapping(value = "/admin-login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String name,
                                               @RequestParam(required = true) String password,
                                               @ModelAttribute("model")ModelMap model,
                                               HttpServletResponse response,
                                               HttpServletRequest request) {
        Administrator administrator = AdminCreatingController.getAdmin(name);
        request.getSession().setAttribute("admin", administrator);
        return "redirect:/user-permissions";
    }


}
