package com.sabapathy.tutorial;

import com.sabapathy.tutorial.service.dao.UserRepository;
import com.sabapathy.tutorial.service.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Slf4j

@Component
public class TutorialInit {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void init() {
        log.debug("PostConstruct: encoding Admin credentials");

        User user = userRepository.findByUsername("admin").get();
        user.setPassword(bCryptPasswordEncoder.encode("password"));
        userRepository.save(user);
    }
}
