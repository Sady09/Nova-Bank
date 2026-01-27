package com.sady.novabank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private String id;

    @Setter
    @Column(nullable = false)
    private BigDecimal balance;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Setter
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime closedAt;

    @Setter
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
