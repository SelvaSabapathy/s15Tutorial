package com.sabapathy.tutorial.api.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class MvcUserRequest {

    @NotNull(message = "{MvcUserRequest.name.notnull}")
    private String name;

    @NotNull(message = "{MvcUserRequest.email.notnull}")
    private String email;

    @Size(min = 4, max = 10, message = "{MvcUserRequest.username.size}")
    private String username;

    @NotNull(message = "{MvcUserRequest.password.notnull}")
    private String password;

    @NotNull(message = "{MvcUserRequest.captcha.notnull}")
    private String captcha;

    private Set<MvcRoleRequest> roles;
}
