package com.sabapathy.tutorial.service;

import com.sabapathy.tutorial.dao.UserRepository;
import com.sabapathy.tutorial.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        log.debug("addUser: " + user.getName());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        log.debug("getUser for: " + username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
