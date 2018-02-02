package com.controllers;

import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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


    //TODO: !!
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView showUpdateForm(@PathVariable("id") String id){
        ModelAndView model = new ModelAndView();
        model.addObject("user",userService.getUserById(id));
        model.setViewName("updateForm");
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String submitUpdateForm(HttpServletRequest request, String name, String surname, String password, @PathVariable("id") String id) throws ServletException {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setId(id);
        userService.saveUser(user);
        request.logout();
        request.login(user.getEmail(),password);
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

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }







}
