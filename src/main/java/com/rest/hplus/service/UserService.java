package com.rest.hplus.service;
import com.rest.hplus.beans.User;
import com.rest.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // You can add more methods as per your requirements
}
