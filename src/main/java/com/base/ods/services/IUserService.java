package com.base.ods.services;

import com.base.ods.domain.User;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;
import com.base.ods.responses.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResponse> getAllUsersWithParam(Optional<Long> roleId, Optional<Long> departmentId);
    User getUserById(Long userId);
    User createUser(UserCreateRequest userCreateRequest);
    User updateUserById(Long userId, UserUpdateRequest userUpdateRequest);
    void deleteUserById(Long userId);
    User getUserByEmail(String email);
}
