package com.sabapathy.tutorial.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
