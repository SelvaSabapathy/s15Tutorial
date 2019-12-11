package com.sabapathy.tutorial.mapper;

import com.sabapathy.tutorial.entity.User;
import com.sabapathy.tutorial.model.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);
}
