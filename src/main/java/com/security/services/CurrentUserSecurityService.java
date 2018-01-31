package com.security.services;

import com.models.CurrentUser;

public interface CurrentUserSecurityService {

    boolean canAccessUser(CurrentUser currentUser, String id);

}
