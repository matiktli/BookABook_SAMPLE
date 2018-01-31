package com.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("error")
public class WebErrorController implements ErrorController {

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
