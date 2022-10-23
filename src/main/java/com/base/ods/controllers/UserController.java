package com.base.ods.controllers;

import com.base.ods.entities.User;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;
import com.base.ods.responses.UserResponse;
import com.base.ods.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserResponse> getAllUsers(@RequestParam Optional<Long> roleId, @RequestParam Optional<Long> departmentId){
        return userService.getAllUsersWithParam(roleId, departmentId);
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PostMapping
    public User createUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.createUser(userCreateRequest);
    }
    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUserById(userId, userUpdateRequest);
    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }
}
