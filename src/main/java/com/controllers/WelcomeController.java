package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greetings")
public class WelcomeController {

    @RequestMapping("/hello")
    public String welcome(Model model, @RequestParam(value = "name",required = false,defaultValue = "test") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
