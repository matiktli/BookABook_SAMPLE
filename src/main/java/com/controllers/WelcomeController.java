package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping(value = {"/home","/"})
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }


}
