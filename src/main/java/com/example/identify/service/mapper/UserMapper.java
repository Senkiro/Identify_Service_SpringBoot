package com.example.identify.service.mapper;

import com.example.identify.service.dto.request.UserCreationRequest;
import com.example.identify.service.dto.request.UserUpdateRequest;
import com.example.identify.service.dto.response.UserResponse;
import com.example.identify.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
