package com.sabapathy.tutorial.api.rest.mapper;

import com.sabapathy.tutorial.api.mvc.model.MvcUserRequest;
import com.sabapathy.tutorial.api.rest.model.LoginRequest;
import com.sabapathy.tutorial.service.entity.User;
import com.sabapathy.tutorial.api.rest.model.UserRequest;
import com.sabapathy.tutorial.api.rest.model.UserResponse;
import org.mapstruct.Mapper;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    User toUser(UserRequest userRequest);

    User toUser(LoginRequest loginRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponses(List<User> users);
}
