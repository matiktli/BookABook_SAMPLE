package com.security.services;

import com.models.User;

public interface UserSecurityService {

    User getUserById(String id);
    User getUserByEmail(String email);
    User createUser(User user);
}
