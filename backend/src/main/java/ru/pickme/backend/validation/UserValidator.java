package ru.pickme.backend.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pickme.backend.model.User;

@Component("beforeCreateUserValidator")
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println(123);
        User user = (User) target;
        if(checkInputString(user.getUsername())) {
            errors.rejectValue("name", "name.empty");
        }
        if(checkInputString(user.getEmail())) {
            errors.rejectValue("email", "email.empty");
        }
        if(checkInputString(user.getPhone_number())) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty");
        }
        if(checkInputString(user.getPassword())) {
            errors.rejectValue("password", "password.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
