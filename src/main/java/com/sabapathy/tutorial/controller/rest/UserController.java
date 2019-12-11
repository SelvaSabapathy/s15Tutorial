package com.sabapathy.tutorial.controller.rest;

import com.sabapathy.tutorial.entity.User;
import com.sabapathy.tutorial.mapper.RoleMapper;
import com.sabapathy.tutorial.mapper.UserMapper;
import com.sabapathy.tutorial.model.UserDTO;
import com.sabapathy.tutorial.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

@RestController
@RequestMapping("/api/rest")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("user/register")
    @ResponseBody
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userMapper.toUserDTO(userService.addUser(userMapper.toUser(userDTO)));
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public UserDTO getUser(@PathVariable String username) {
        return  userMapper.toUserDTO(userService.getUser(username));
    }

    @GetMapping("/user")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return  userMapper.toUserDTOs(userService.getUsers());
    }
}
