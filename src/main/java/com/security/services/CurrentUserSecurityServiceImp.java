package com.security.services;

import com.models.CurrentUser;
import com.models.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserSecurityServiceImp implements CurrentUserSecurityService {
    @Override
    public boolean canAccessUser(CurrentUser currentUser, String id) {
        return currentUser != null
                && (currentUser.getRole().equals(Role.USER.name()) || currentUser.getId().equals(id));
    }
}
