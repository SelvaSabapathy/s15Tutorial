package com.sabapathy.tutorial.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String username;
    private String password;
    private Set<RoleRequest> roles;
}
