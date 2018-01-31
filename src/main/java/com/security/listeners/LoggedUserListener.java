package com.security.listeners;

import com.models.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class LoggedUserListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    HttpSession httpSession;



    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        CurrentUser user = (CurrentUser) event.getAuthentication().getPrincipal();
        httpSession.setAttribute("currentUser",user.getUser());
    }
}
