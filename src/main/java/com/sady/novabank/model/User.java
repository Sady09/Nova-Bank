package com.sady.novabank.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@JsonPropertyOrder({ "id", "name", "email", "account" })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Column(name = "user_id", nullable = false)
    private String id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false, unique = true)
    private String cpf;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @OneToOne(mappedBy = "user")
    private Account account;
}

