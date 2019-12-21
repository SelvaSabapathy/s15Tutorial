package com.sabapathy.tutorial.service.impl;

import com.sabapathy.tutorial.service.api.LoginService;
import com.sabapathy.tutorial.service.dao.UserRepository;
import com.sabapathy.tutorial.service.entity.User;
import com.sabapathy.tutorial.service.security.UserDetailsImpl;
import com.sabapathy.tutorial.service.security.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    public User authUser(User user) {
        log.debug("authUser for: " + user.getUsername());

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        if (bCryptPasswordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
            return ((UserDetailsImpl) userDetails).getUser();
        }
        throw new RuntimeException("Password for " + user.getUsername() + " don't match!");
    }
}
