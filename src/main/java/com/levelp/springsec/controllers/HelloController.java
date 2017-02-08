package com.levelp.springsec.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Student-25 on 03.02.2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ModelAndView("index", "name", user.getUsername());
    }
}
