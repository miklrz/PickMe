package ru.pickme.backend.service;

import org.springframework.stereotype.Service;
import ru.pickme.backend.model.User;
import ru.pickme.backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
}
