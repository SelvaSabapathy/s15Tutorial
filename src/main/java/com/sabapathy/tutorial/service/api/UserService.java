package com.sabapathy.tutorial.service.api;

import com.sabapathy.tutorial.service.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    List<User> getUsers();

    User getUser(String username);
}
