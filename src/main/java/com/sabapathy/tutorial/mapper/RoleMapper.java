package com.sabapathy.tutorial.mapper;

import com.sabapathy.tutorial.entity.Role;
import com.sabapathy.tutorial.model.RoleDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleDTO roleDTO);

    RoleDTO toRoleDTO(Role role);

    Set<Role> toRoles(Set<RoleDTO> roleDTOs);

    Set<RoleDTO> toRoleDTOs(Set<Role> roles);
}
