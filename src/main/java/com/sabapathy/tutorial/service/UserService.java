package com.sabapathy.tutorial.service;

import com.sabapathy.tutorial.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    
    List<User> getUsers();

    User getUser(String username);
}
