package com.tripadvisor.auth.controllers;

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
import java.util.List;

@Controller
public class ApplicationCreatingController {

    static List<Application> applications = new ArrayList<Application>();

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("applications", applications);
        return "applications";
    }

    @RequestMapping(value = "/add-application", method = RequestMethod.POST)
    public String addApplication(@RequestParam(required = true) String name,
                                               @RequestParam(required = true) String permissions,
                                               @ModelAttribute("model")ModelMap model,
                                               HttpServletResponse response,
                                               HttpServletRequest request) {
        applications.add(new Application(name, permissions));
        model.addAttribute("applications", applications);
        return "redirect:/applications";
    }



}
