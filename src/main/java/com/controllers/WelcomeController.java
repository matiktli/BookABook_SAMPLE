package com.controllers;

import com.models.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = {"/home","/"})
    public ModelAndView welcome(Authentication authentication) {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        if(authentication != null) {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            model.addObject("currentUser",currentUser.getUser().getName());
        }
        return model;
    }



}
