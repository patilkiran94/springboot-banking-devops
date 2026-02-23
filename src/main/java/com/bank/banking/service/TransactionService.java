package com.bank.banking.service;

import com.bank.banking.entity.*;
import com.bank.banking.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void deposit(String accountNumber, Double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setAmount(amount);
        tx.setType("DEPOSIT");
        tx.setTimestamp(LocalDateTime.now());
        tx.setAccount(account);
        transactionRepository.save(tx);
    }
}