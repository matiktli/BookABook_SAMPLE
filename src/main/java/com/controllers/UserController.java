package com.controllers;

import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;

    @Autowired
    protected AuthenticationManager authenticationManager;


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
    public String submitRegistrationForm(User user, HttpServletRequest request) throws ServletException {
        userService.saveUser(user);
        request.login(user.getEmail(),user.getPassword());
        return "redirect:/home";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(@RequestParam("id") String id){
        //model.addAttribute("user",userService.getUserById(id));
        System.out.println("ID:" + id);
        return "registerForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateForm(User user,@RequestParam("id") String id){
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/user/find?id="+user.getId();
    }


    @RequestMapping(value="/perform_login",method = RequestMethod.GET)
    public String showLoginForm(@RequestParam Optional<String> error){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm");
        if(!error.equals(Optional.empty())) {
            modelAndView.addObject("error", error);

        }

        return "loginForm";
    }








}
