package com.controllers;

import com.models.User;
import com.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/books")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/booking")
    public String booking(@RequestParam("id") String id){
        User user = (User) httpSession.getAttribute("currentUser");
        bookingService.bookingBookForUser(id,user.getId());
        return "redirect:/user/find?id="+user.getId();
    }

    @RequestMapping("/returning")
    public String returning(@RequestParam("id") String id){
        User user = (User) httpSession.getAttribute("currentUser");
        bookingService.returningBook(id,user.getId());
        return "redirect:/user/find?id="+user.getId();
    }
}
