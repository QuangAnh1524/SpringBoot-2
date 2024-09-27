package com.quanh1524.identity_service.mapper;

import com.quanh1524.identity_service.dto.request.UserCreationRequest;
import com.quanh1524.identity_service.dto.request.UserUpdateRequest;
import com.quanh1524.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
