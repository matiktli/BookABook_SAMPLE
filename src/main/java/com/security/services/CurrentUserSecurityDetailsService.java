package com.security.services;

import com.models.CurrentUser;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserSecurityDetailsService implements UserDetailsService {

    @Autowired
    UserSecurityService userSecurityService;

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userSecurityService.getUserByEmail(email);
        return new CurrentUser(user);
    }
}
