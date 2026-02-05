package com.sady.novabank.controller;

import com.sady.novabank.dto.CreateUserRequest;
import com.sady.novabank.dto.UserResponse;
import com.sady.novabank.model.User;
import com.sady.novabank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserResponse> getUser(){
        List<User> users = userService.getUser();
        List<UserResponse> responses = new ArrayList<>();

        for(User user : users){
            UserResponse response = new UserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCpf()
            );

            responses.add(response);
        }
        return responses;
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable String userId){
        User user = userService.getUserById(userId);
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf()
        );
    }

    @PostMapping("/")
    public User createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

}
