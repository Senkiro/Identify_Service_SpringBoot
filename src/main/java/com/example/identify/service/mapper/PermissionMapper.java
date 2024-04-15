package com.example.identify.service.mapper;


import com.example.identify.service.dto.request.PermissionRequest;
import com.example.identify.service.dto.response.PermissionResponse;
import com.example.identify.service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
