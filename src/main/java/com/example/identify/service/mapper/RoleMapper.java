package com.example.identify.service.mapper;

import com.example.identify.service.dto.request.RoleRequest;
import com.example.identify.service.dto.request.UserCreationRequest;
import com.example.identify.service.dto.request.UserUpdateRequest;
import com.example.identify.service.dto.response.RoleResponse;
import com.example.identify.service.dto.response.UserResponse;
import com.example.identify.service.entity.Role;
import com.example.identify.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
