package com.sabapathy.tutorial.api.mvc.model;

import com.sabapathy.tutorial.api.rest.model.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class MvcUserResponse {
    private String name;
    private String email;
    private String username;
    private String password;
    private Set<RoleResponse> roles;
}
