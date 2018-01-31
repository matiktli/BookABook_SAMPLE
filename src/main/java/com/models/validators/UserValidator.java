package com.models.validators;


import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
//TODO: play with validation later

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        validateEmail(errors,user);
    }


    private void validateEmail(Errors errors, User user) {
        if (userService.getUserByEmail(user.getEmail()) == null) {
            errors.reject("email.notExist", "User with this email do not exists");
        }
    }
}
