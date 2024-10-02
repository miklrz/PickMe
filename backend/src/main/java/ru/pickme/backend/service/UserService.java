package ru.pickme.backend.service;

import org.springframework.stereotype.Service;
import ru.pickme.backend.model.User;
import ru.pickme.backend.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public Optional<User> editUser(User newUser, int id){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(int id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
