package com.sady.novabank.dto;

public record UserResponse(
        String id,
        String name,
        String email,
        String cpf
) {}
