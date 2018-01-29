package com.controllers;

import com.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping("/hello")
    public String welcome() {
        return "welcomePage";
    }

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView model = new ModelAndView();
        model.addObject("booksList", bookService.getAllBooks());
        model.setViewName("booksList");
        return model;
    }


}
