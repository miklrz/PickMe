package ru.pickme.backend.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pickme.backend.model.User;
import ru.pickme.backend.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User>getUser(@PathVariable("id") int id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User createdUser = userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> editUser(@Valid @RequestBody User user, @PathVariable int id){
        Optional<User> updatedUser = userService.editUser(user,id);
        return updatedUser
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean deleted = userService.deleteUser(id);
        if(deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
