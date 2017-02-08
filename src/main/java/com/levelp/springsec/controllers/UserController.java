package com.levelp.springsec.controllers;

import com.levelp.springsec.dto.UserRegistrationDTO;
import com.levelp.springsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Student-25 on 03.02.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("registration_form", "user", new UserRegistrationDTO());
    }

    @RequestMapping(value = "/register_me", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute UserRegistrationDTO dto) {

        service.register(dto);

        return new ModelAndView("redirect:login");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
