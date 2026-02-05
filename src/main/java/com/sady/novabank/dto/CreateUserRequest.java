package com.sady.novabank.dto;

public record CreateUserRequest(
        String name,
        String email,
        String cpf,
        String password
) {}
