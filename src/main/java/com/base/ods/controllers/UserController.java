package com.base.ods.controllers;

import com.base.ods.entities.User;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;
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
    public List<User> getAllUsers(@RequestParam Optional<Long> roleId){
        return userService.getAllUsersWithParam(roleId);
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
    public User updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUser(userId, userUpdateRequest);
    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }
}
