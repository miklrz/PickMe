package ru.pickme.backend.controller;
import org.springframework.web.bind.annotation.*;
import ru.pickme.backend.model.User;
import ru.pickme.backend.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
     private final UserService userService;

    public ApiController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }
}
