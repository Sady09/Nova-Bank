package com.sady.novabank.service;

import com.sady.novabank.model.Account;
import com.sady.novabank.model.AccountStatus;
import com.sady.novabank.model.User;
import com.sady.novabank.repository.AccountRepository;
import com.sady.novabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));


        if(user.getAccount() != null){
            throw new RuntimeException("Usuario ja possui uma conta");
        }

        Account account = new Account();
        account.setUser(user);
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(AccountStatus.ATIVA);
        account.setCreatedAt(LocalDateTime.now());

        accountRepository.save(account);

        return account;
    }
}
