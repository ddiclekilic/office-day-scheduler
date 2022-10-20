package com.base.ods.services;

import com.base.ods.entities.User;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsersWithParam(Optional<Long> roleId);
    User getUserById(Long userId);
    User createUser(UserCreateRequest userCreateRequest);
    User updateUser(Long userId, UserUpdateRequest userUpdateRequest);
    void deleteUserById(Long userId);

}
