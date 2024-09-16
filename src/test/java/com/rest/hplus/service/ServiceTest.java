package com.rest.hplus.service;

import com.rest.hplus.beans.Activity;
import com.rest.hplus.beans.Gender;
import com.rest.hplus.beans.Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.rest.hplus.beans.User;
import com.rest.hplus.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testLoginService(){
        String password = "dddd";
        User user = new User();
        user.setUsername("kkkkkkkkkkkk");
        user.setFirst_name("kajhfkjsgkfs");
        user.setLast_name("ksdjfksgfk");
        user.setActivity(Activity.sport);
        user.setGender(Gender.MALE);
        user.setPassword(passwordEncoder.encode(password));
        user.setAge(new Date(99,0,1));
        user.setOrders(null);

        when(userRepository.save(any(User.class))).thenReturn(user);
        User newUser = userService.saveUser(user);
        assertEquals("kajhfkjsgkfs" , newUser.getFirst_name());


    }
}
