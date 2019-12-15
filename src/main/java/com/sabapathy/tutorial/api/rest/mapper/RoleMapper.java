package com.sabapathy.tutorial.api.rest.mapper;

import com.sabapathy.tutorial.service.entity.Role;
import com.sabapathy.tutorial.api.rest.model.RoleRequest;
import com.sabapathy.tutorial.api.rest.model.RoleResponse;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);

    Set<Role> toRoles(Set<RoleRequest> roleRequests);

    Set<RoleResponse> toRoleResponses(Set<Role> roles);
}
