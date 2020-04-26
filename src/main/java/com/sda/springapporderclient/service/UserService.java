package com.sda.springapporderclient.service;

import com.sda.springapporderclient.repository.UserRepository;
import com.sda.springapporderclient.exception.UserNotFoundException;
import com.sda.springapporderclient.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findUserByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new UserNotFoundException(firstName, lastName));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOneById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User toUpdate = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        toUpdate.setUsername(user.getUsername());
        toUpdate.setFirstName(user.getFirstName());
        toUpdate.setLastName(user.getLastName());
        toUpdate.setEmail(user.getEmail());
        return userRepository.save(toUpdate);
    }


    public void deleteUser(Long id) {
        User toDelete = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(toDelete);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}
