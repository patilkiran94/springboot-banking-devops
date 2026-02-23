package com.bank.banking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String type;
    private LocalDateTime timestamp;

    @ManyToOne
    private Account account;
}