package com.sady.novabank.service;

import com.sady.novabank.dto.UserResponse;
import com.sady.novabank.model.User;
import com.sady.novabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id nao pertence a nenhum usuario"));
    }

    public User createUser(String name, String cpf, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email ja cadastrado");
        }

        if(userRepository.existsByCpf(cpf)){
            throw new RuntimeException("Cpf ja cadastrado");
        }

        var encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);

        User user = new User();
        user.setName(name);
        user.setCpf(cpf);
        user.setEmail(email);
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}
