package com.sady.novabank.controller;

import com.sady.novabank.model.Account;
import com.sady.novabank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{userId}")
    public Account createAccount(@PathVariable String userId) {
        return accountService.createAccount(userId);
    }
}

