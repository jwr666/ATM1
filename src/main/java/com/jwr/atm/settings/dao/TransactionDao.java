package com.jwr.atm.settings.dao;

import com.jwr.atm.settings.domain.Transaction;

import java.util.List;

public interface TransactionDao {

    int log(Transaction t);

    List<Transaction> getTransactionList(String accountId);
}
