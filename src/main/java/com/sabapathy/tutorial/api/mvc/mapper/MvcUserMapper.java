package com.sabapathy.tutorial.api.mvc.mapper;

import com.sabapathy.tutorial.api.mvc.model.MvcLoginRequest;
import com.sabapathy.tutorial.api.mvc.model.MvcUserRequest;
import com.sabapathy.tutorial.api.mvc.model.MvcUserResponse;
import com.sabapathy.tutorial.service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MvcRoleMapper.class})
public interface MvcUserMapper {
    User toUser(MvcUserRequest mvcUserRequest);

    User toUser(MvcLoginRequest mvcLoginRequest);

    MvcUserResponse toUserResponse(User user);

}
