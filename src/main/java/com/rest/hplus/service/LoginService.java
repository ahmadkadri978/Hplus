package com.rest.hplus.service;

import com.rest.hplus.beans.User;
import com.rest.hplus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public User findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }
}
