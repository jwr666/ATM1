package com.jwr.atm.settings.service;

import com.jwr.atm.settings.domain.Transaction;

import java.util.List;

public interface TransactionService {
    boolean log(Transaction t);

    List<Transaction> getTransactionList(String accountId);
}
