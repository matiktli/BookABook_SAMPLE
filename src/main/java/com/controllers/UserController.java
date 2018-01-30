package com.controllers;

import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;


    @RequestMapping(value = "/find",params = "email")
    public String getUserByEmail(Model model,@RequestParam("email") String email){
        model.addAttribute("user",userService.getUserByEmail(email));
        return "singleUserPage";
    }

    @RequestMapping(value = "/find",params = "id")
    public String getUserById(Model model,@RequestParam("id") String id){
        model.addAttribute("user",userService.getUserById(id));
        return "singleUserPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String submitRegistrationForm(User user){
        userService.addUser(user);
        return "redirect:/user/find?id="+user.getId();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model,@RequestParam("id") String id){
        model.addAttribute("user",userService.getUserById(id));
        return "userAddOrUpdateForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateForm(User user,@RequestParam("id") String id){
        user.setId(id);
        userService.addUser(user);
        return "redirect:/user/find?id="+user.getId();
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String email,String password){
       try {
           User loggingInUser = userService.getUserByEmail(email);
           if (loggingInUser.getPassword().equals(password)) {
                return "redirect:/user/find?id="+loggingInUser.getId();
           }
           else{
               return "redirect:/user/login";
           }

       }
       catch (Exception e){
           return "redirect:/user/login";

       }
    }


}
