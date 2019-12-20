package com.sabapathy.tutorial.api.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class MvcLoginRequest {

    private String username;

    private String password;

    @NotNull(message = "{MvcLoginRequest.captcha.notnull}")
    private String captcha;
}
