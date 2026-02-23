package com.bank.banking.service;

import com.bank.banking.entity.Account;
import com.bank.banking.entity.User;
import com.bank.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0.0);
        account.setUser(user);
        return accountRepository.save(account);
    }
}