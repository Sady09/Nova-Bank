package com.sady.novabank.controller;

import com.sady.novabank.dto.CreateUserRequest;
import com.sady.novabank.model.User;
import com.sady.novabank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
        public User createUser(@RequestBody CreateUserRequest createUserRequest){
            User user = userService.createUser(
                    createUserRequest.getName(),
                    createUserRequest.getCpf(),
                    createUserRequest.getEmail(),
                    createUserRequest.getPassword()
            );

            return user;

        }
}
