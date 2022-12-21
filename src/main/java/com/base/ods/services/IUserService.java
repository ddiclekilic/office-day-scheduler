package com.base.ods.services;

import com.base.ods.domain.User;
import com.base.ods.services.requests.UserCreateRequestDTO;
import com.base.ods.services.requests.UserUpdateRequestDTO;
import com.base.ods.services.responses.UserResponseDTO;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IUserService {
    List<UserResponseDTO> getAllUsers(Pageable pageable);

    UserResponseDTO getUserById(Long id);

    UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);

    UserResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO);

    void deleteUsersByIds(List<Long> ids);

    User getUserByEmail(String email);

}
